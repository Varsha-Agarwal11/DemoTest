import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class Promos 
{

    // main function. Project run starts from main function...
   public static void main(String[] args) {

      String host = "IMAP.gmail.com";// change accordingly
      String mailStoreType = "IMAP4";
      String username = "kusuma.newell@gmail.com";// change accordingly
      String password = "Newell@123";// change accordingly

      check(host, mailStoreType, username, password);
   }


   // function to make connection and get mails from server known as "Pop" server
   public static void check(String host, String storeType, String user, String password) 
   {
      try {

      //create properties field
      Properties properties = new Properties();

      properties.put("mail.IMAP4.host", host);
      properties.put("mail.IMAP4.port", "995");
      properties.put("mail.IMAP4.starttls.enable", "true");
      Session emailSession = Session.getDefaultInstance(properties);

      //create the POP3 store object and connect with the pop server
      Store store = emailSession.getStore("pop3s");

      store.connect(host, user, password);

      //create the folder object and open it
      Folder emailFolder = store.getFolder("Inbox");

      emailFolder.open(Folder.READ_ONLY);

      // retrieve the messages from the folder in an array and print it
      Message[] messages = emailFolder.getMessages();
      System.out.println("messages.length---" + messages.length);
      for (int i = 0, n = messages.length; i < n; i++) {
          Message message = messages[i];


          Object obj = message.getContent();
          Multipart mp = (Multipart)obj;
          BodyPart bp = mp.getBodyPart(0);


          System.out.println("---------------------------------");
          System.out.println("Email Number " + (i + 1));
          System.out.println("Subject: " + message.getSubject());
          System.out.println("From: " + message.getFrom()[0]);
          System.out.println("To: " + message.getAllRecipients().toString());
          System.out.println("Received Date:" + message.getReceivedDate());
          System.out.println("Text: " + bp.getContent().toString());
       }

       //close the store and folder objects
       emailFolder.close(false);
       store.close();

       } catch (MessagingException e) {
          e.printStackTrace();
       } catch (Exception e) {
          e.printStackTrace();
       }
   }
  }