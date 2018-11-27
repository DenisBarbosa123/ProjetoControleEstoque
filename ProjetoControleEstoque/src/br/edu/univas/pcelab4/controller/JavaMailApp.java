package br.edu.univas.pcelab4.controller;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class JavaMailApp{
	static Properties props;
	private  Address[] toUser;
	public JavaMailApp() {
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.socketFactory.port", "587");  
        props.put("mail.smtp.port", "587");  
         
	}
      public void enviarEmail(String qtde, String produto, ArrayList<String> listaEmailComercial){
 
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("denis.barbosa69@gmail.com", "98886638");
                             }
                        });
 
            /** Ativa Debug para sessão */
            //session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("denis.barbosa69@gmail.com")); //Remetente
                  for (String string : listaEmailComercial) {
                	  toUser = InternetAddress.parse(string);
				}
                  	
                	  
                  //  
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Solicitação de compra");//Assunto
                  message.setText("Favor realizar a compra do seguinte produto: "+produto+ "Quantidade atual do estoque"+qtde);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
 
                  System.out.println("Feito!!!");
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}