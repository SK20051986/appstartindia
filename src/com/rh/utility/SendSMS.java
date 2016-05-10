package com.rh.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendSMS {

	 public static void sms_url(String msisdn,String massage)
     {
              try
         {
                 URLConnection theURLconn=null;

                 String msg = URLEncoder.encode(massage);
                 System.out.println("text:" + msg);
                  String URL_str ="http://api.smscountry.com/SMSCwebservice_bulk.aspx?User=rhtett&passwd=rhead@123&mobilenumber=91"+msisdn+"&message="+msg+"&sid=RHTOTP&mtype=N&DR=Y";
                 URL url=new URL(URL_str);
                 theURLconn = url.openConnection();
                 BufferedReader BR = new BufferedReader (new InputStreamReader(theURLconn.getInputStream()));
                 String show=null;
                 String toprt = "";
                 while((show=BR.readLine())!=null)
                 {
                         toprt= toprt  + show;
                         System.out.println(toprt);
                 }
         }
         catch(Exception e)
         {
                 e.printStackTrace();
         }
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String massage="Congrats! Sucessfully submit your data";
		
		sms_url("9910712928",massage);

	}

}
