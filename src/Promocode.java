import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class Promocode {

	public static void main(String[] args) throws NoClassDefFoundError {

		Promocode gmail = new Promocode();
		gmail.read();

	}

	public void read() {

		Properties props = new Properties();

		try {
			props.load(new FileInputStream(new File("C:\\Users\\virsha.agarwal\\Desktop\\smtp.properties")));
			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", "kusuma.newell@gmail.com", "Newell@123");

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_ONLY);
			int messageCount = inbox.getMessageCount();
			Message[] messages = inbox.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = messages.length-1; i >= 1; i--) 
			{
				Message message = messages[i];

				Object obj = message.getContent();
				Multipart mp = (Multipart) obj;
				BodyPart bp = mp.getBodyPart(0);

				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("To: " + message.getAllRecipients().toString());
				System.out.println("Received Date:" + message.getReceivedDate());
				System.out.println("Text: " + bp.getContent().toString());
				String body = bp.getContent().toString();
				try {
					/*
					 * Pattern p = Pattern.compile("*PARKER647314SAVE*"); // ab Matcher m =
					 * p.matcher(body);
					 */
				/*	String[] promoCode = body.split("\\P");
					String promoCodes = promoCode[1];*/
					 
					//String promoCodes = body.substring(body.indexOf("code")+5,body.indexOf("at")-1);
					//System.out.println("Promocode ------------:" + promoCodes);
					
					String promoCodes = "PARKER454823SAVE";
					Pattern p = Pattern.compile(promoCodes);
					Matcher m = p.matcher(body);
					while(m.find())
					{
						System.out.println("Promo code fethed ");
						System.out.println("Start : "+m.start()+" End : "+m.end()+" Pattern : "+m.group());
					}
				} 
				catch (Exception e) {
					// Do Nothing
				}
				break;
			}

			/*// close the store and folder objects
			// emailFolder.close(false);
			store.close();
			System.out.println("Total Messages:- " + messageCount);

			Message[] messagess = inbox.getMessages();
			System.out.println("------------------------------");

			for (int i = 0; i < 10; i++) {
				System.out.println("Mail Subject:- " + messagess[i].getSubject() + messagess[i].getContent());
			}

			inbox.close(true);
			store.close();*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}