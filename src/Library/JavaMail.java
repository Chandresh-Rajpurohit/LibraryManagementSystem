/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author Sanjay
 */
 public class JavaMail {
     
public void SendMail(String rec,String bookName,String author,int isbn,int edition){
String to = rec; // to address. It can be any like gmail, yahoo etc.
  String from = "librarymanagement48@gmail.com"; // from address. As this is using Gmail SMTP your from address should be gmail
  String password = "Library@123"; // password for from gmail address that you have used in above line. 

  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.gmail.com");
  prop.put("mail.smtp.port", "465");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.socketFactory.port", "465");
  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

  Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(from, password);
   }
  });

  try {

   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   message.setSubject("Return Book Message");
   StringBuilder sb  = new StringBuilder();
   sb.append("This message is to inform that tommorrow is last date of returning the Library book that you have issued.\n");
   sb.append("\n");
   sb.append("Following are the book details.");
    sb.append("\n");
   sb.append("Book Name = ").append(bookName);
   sb.append("\n");
       sb.append("Book Author = ").append(author);
    sb.append("\n");
       sb.append("Book isbn = ").append(isbn);
    sb.append("\n");
    sb.append("Book Edition = ").append(edition);
   
  message.setText(sb.toString());


   Transport.send(message);

   System.out.println("Mail Sent...");

  } catch (MessagingException e) {
   e.printStackTrace();
  }
 
    }
 }
