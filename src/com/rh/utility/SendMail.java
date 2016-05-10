package com.rh.utility;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {

	public static void sendMail(String url,String toAddress)
    {
		String subject  = "";
        String message  ="";
               
        try
        {
                        subject ="BONUS of Rs. 10 to your App Start india account";
                        message ="<!doctype html><html><head><meta charset='utf-8'><title></title><style>*{margin:0px;padding:0px;}body{width: 100% !important; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; margin: 0; padding: 0;font-family: Arial,sans-serif;}img{outline: none; text-decoration: none; border: none; -ms-interpolation-mode: bicubic;}.bg-table{width:600px; background:#1e1e1e;}.content-table{width:580px; background:#1e1e1e;}@media only screen and (max-width: 640px){a[href^='tel']{text-decoration: none; color: #ffffff; pointer-events: none; cursor: default;}a[href^='sms']{text-decoration: none; color: #ffffff; pointer-events: none; cursor: default;}.bg-table{width:480px !important;background:#1e1e1e}.content-table{width:440px !important;background:#1e1e1e}}@media only screen and (max-width: 480px){a[href^='tel']{text-decoration: none; color: #ffffff; pointer-events: none; cursor: default;}a[href^='sms']{text-decoration: none; color: #ffffff; pointer-events: none; cursor: default;}.bg-table{width:300px !important;background:#1e1e1e}.content-table{width:240px !important;background:#1e1e1e}}</style></head><body><table class='bg-table' width='580px' border='0' cellspacing='0' cellpadding='0' style='border:1px solid #ccc; margin:auto;background:#1e1e1e'> <tbody> <tr> <td bgcolor='#1e1e1e' style='background: #1e1e1e; padding: 0px;' class='content-table'><img alt='' src='http://54.209.220.78:8888/images/001.png' width='100%'></td></tr><tr> <td> <table class='bg-table' width='580px' border='0' cellspacing='0' cellpadding='0' style=' margin:0 auto;background:#1e1e1e'> <tr> <td style='height:20px;'> </td></tr><tr> <td class='content-table' style=''> <ul type='none' style='width:93%; margin:auto; font-size:17px; text-align:Justify; color:#9F9F9F'> <li><strong>Hi,</li></ul> </td></tr><tr> <td style='height:20px;'> </td></tr><tr><td class='content-table' style=''> <ul type='none' style='width:93%; margin:auto; font-size:17px; text-align:Justify; color:#9F9F9F'><li><strong>We value all our users who come along and give us a chance to help you earn Unlimited Talktime.<strong></li></ul> </td></tr><tr> <td style='height:20px;'> </td></tr><tr> <td class='content-table' style=''> <ul type='none' style='width:93%; margin:auto; font-size:17px; text-align:Justify; color:#9F9F9F'> <li><strong>As a goodwill gesture, we have added <label style='color:#f38020;font-size:18px'>BONUS of Rs. 10 to your Earn Talktime account</label>. To claim your free bonus, please open your Earn Talktime app or download it again from Play Store by 21st October 2015.</li></ul> </td></tr><tr> <td style='height:20px;'> </td></tr><tr> <td class='content-table' style=''> <ul type='none' style='width:93%; margin:auto; font-size:17px; text-align:Justify; color:#9F9F9F'> <li><strong>Warm Regards,<br/>Team Earn Talktime</li></ul> </td></tr><tr> <td style='height:30px;'> </td></tr><tr> <td class='content-table' style='margin:auto; text-align:center;'> <a href='"+url+"'> <img border='0' style='margin:5px auto 10px auto;' alt='click here' src='http://54.209.220.78:8888/images/003.png'></a> </td></tr><tr> <td style='height:20px;'> </td></tr><tr> <td style='height:20px;'> </td></tr></table></td></tr></tbody></table></body></html>";

         }
        catch(Exception ex)
        {
                System.out.println("[MAIL_API ] Exception accured when send mail to ales team : "+ex);
        }
        try{
            String host="104.140.22.50";
            final String user="import";//change accordingly
            final String password="fgtytjuynmgjgyhytyry";//change accordingly
        
            Properties props = new Properties();

            props.put("mail.smtp.host",host);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.enable", "false");

            Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user,password);
                    }
            });
            // creates a new e-mail message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("surendra.singh@rationalheads.com","App Start India"));
            InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(message, "text/html");
            Transport.send(msg);
    }
    catch(Exception EX)
    {
            System.out.println("[MAIL_API ] Send Mail : "+EX);
            EX.printStackTrace();
    }



    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SendMail obj=new SendMail();
		 String url="http://earntalktime.com/earntt/";
		 String toAddress = "singh.surendra19@gmail.com";
         obj.sendMail(url,toAddress);
	}

}
