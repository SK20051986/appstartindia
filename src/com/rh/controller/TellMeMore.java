package com.rh.controller;  
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.rh.utility.Util;

@Path("/tellmemore") 

public class TellMeMore {  
 @Path("/{ettid}/{offerId}")  
 @GET
 @Produces(MediaType.TEXT_HTML)  
 
 
 public void urlRedirect(@PathParam("ettid") String ettid,
			@PathParam("offerId") String offerId,
			@Context final HttpServletResponse response,@HeaderParam("user-agent") String userAgent,@HeaderParam("X-FORWARDED-FOR") String remoteIP,@Context HttpServletRequest request) throws IOException { 
	 
	 		
	 		String ip = request.getRemoteAddr();
	 		System.out.println("Brower Name : "+userAgent+" IP ["+remoteIP+"]  requestIdp ["+request.getRemoteHost()+"]["+request.getContextPath()+"]["+request.getRequestURI()+"]["+request.getContextPath()+"]");
	 		System.out.println("["+GetDate()+"] [Recommended SK] ETT_ID  : ["+ettid+"],Offer ID : ["+offerId+"], TID : [ 88"+getTID()+"] ");
	 		//InetAddress inetAddress = InetAddress.getByName(request.getRemoteHost());
	 		String inetAddress=request.getRemoteHost();
	 		//System.out.println(inetAddress.getHostAddress());
	 		
	 		
	 		int result=0;
            String Query="select count(1) from RecomendValidate where ettId="+ettid+" and offerId="+offerId+" and hostIp='"+inetAddress+"' and isCredit=1";
            result=Util.ExecuteQuery(Query);
            int isBlock=0;
            String Query1="select isBlock from recommend_offer where offer_id="+offerId+"";
            isBlock=Util.ExecuteQuery(Query1);
            System.out.println("["+GetDate()+"] [Recommended SK] Select Fraud Data Query: "+Query+" and Resurlt :"+result+"");
            if(result>0 && isBlock==1) //fraud
            {
                 System.out.println("["+GetDate()+"] [Recommended SK] Fraud with same ettId,hostIp and offer ID][request]["+ettid+","+inetAddress+","+offerId+"]");
                 String contextPath= "http://earntalktime.com/ettinvite/jsp/invite.jsp";
                 response.sendRedirect(response.encodeRedirectURL(contextPath ));

            }
            else {
                    if(userAgent.contains("Windows NT"))
                    {
                            
                    		String tid = "88"+getTID();
                            SendUDP(ettid+"#"+ettid+"#"+tid+"#"+inetAddress,"54.209.220.78","9099");
                            String contextPath= "https://play.google.com/store/apps/details?id=info.earntalktime&hl=en";
                    		
                            response.sendRedirect(response.encodeRedirectURL(contextPath ));
                            

                    }
                    else if(userAgent.contains("Android"))
                    {
                            //String aparty_mdn=Util.getMsisdn(ettid,"ett");
                    		String SelectQuery="SELECT actionURLAndroid,offerAmount from ShareOfferDetails where offerId='"+offerId+"'";
                            String offer_details[]=Util.getOffer(SelectQuery).split(",");
                            String tid = "88"+getTID();
                            SendUDP(ettid+"#"+offerId+"#"+tid+"#"+inetAddress,"54.209.220.78","9099");
                            String url=offer_details[0]+",offerId,"+ettid+",123,"+tid+","+offerId+",0,0000000000";
                            System.out.println("["+GetDate()+"] [Recommended SK] URL Redirect : ["+url+"]");
                            response.sendRedirect(response.encodeURL(url));
                    }
                    else if(userAgent.contains("iPhone"))
                    {
                            //String aparty_mdn=Util.getMsisdn(ettid,"ett");
                    		String SelectQuery="SELECT actionURLiOS,offerAmount from ShareOfferDetails where offerId="+offerId+"";
                            String offer_details[]=Util.getOffer(SelectQuery).split(",");
                            String tid = "88"+getTID();
                            SendUDP(ettid+"#"+offerId+"#"+tid+"#"+inetAddress,"54.209.220.78","9099");
                            String url=offer_details[0]+",offerId,"+ettid+",123,"+tid+","+offerId+",0,0000000000";
                            System.out.println("["+GetDate()+"] [Recommended SK] URL Redirect : ["+url+"]");
                            response.sendRedirect(response.encodeURL(url));
                    }
                    else
                    {
                            response.sendRedirect(response.encodeURL("https://play.google.com/store/apps/details?id=info.earntalktime"));
                    }
            }

    }
    public String SendUDP(String strFinal,String IP,String port)
    {
    	System.out.println("[ETT][EDR_CLICK]  [Recommended SK] FINAL String "+strFinal+":::"+IP+"::"+port);
        String resp="";
        try
        {
                DatagramSocket  clientSocket = new DatagramSocket();
                int localport=clientSocket.getLocalPort();
                String portn=localport+"";
                strFinal=strFinal.replace("LPORT",portn);
                InetAddress IPAddress=InetAddress.getByName(IP);
                DatagramPacket sendPacket = new DatagramPacket(strFinal.getBytes(),strFinal.getBytes().length,IPAddress,Integer.parseInt(port));
                clientSocket.send(sendPacket);
                System.out.println("[ETT] [EDR_CLICK] [Recommended SK] SendUDP["+strFinal+"] IP:"+IP+" Port:"+port);
                clientSocket.close();
        }
        catch(Exception e)
        {
                e.printStackTrace();
                System.out.println("[ETT][EDR_CLICK] Exception When send Packet!!!!!!!!!! "+e);
        }
        return resp;
}

	 		
	 		//response.sendRedirect("https://www.google.co.in/#q="+ettid+offerId);  
    


 
 public synchronized String getTID()
 {
         DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSS");
         java.util.Date date = new java.util.Date();
         Calendar cal = Calendar.getInstance();
         return dateFormat.format(cal.getTime());
 }
 public String GetDate()
 {
         Calendar cal = Calendar.getInstance();
         String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
         SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
         return sdf.format(cal.getTime());
 }

}   