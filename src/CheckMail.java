import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckMail
{
	public static void receiveMail(String username, String pwd) throws MessagingException
	{
		Properties p = new Properties();
		p.setProperty("mail.store.protocol", "imaps");
		Session s = Session.getDefaultInstance(p);
		Store email = s.getStore("imaps");
		email.connect("imap.gmail.com",username,pwd);
		Folder f = email.getFolder("INBOX");
		f.open(Folder.READ_ONLY);
		Message m[] = f.getMessages();
		for(int i=m.length-3;i<m.length;i++)
		{
			System.out.println("Email number : "+i+1);
			System.out.println("Subject : "+Message.ATTACHMENT);
		}
	}
	public static void main(String[] args) throws MessagingException 
	{
		CheckMail.receiveMail("pepboysinformation@gmail.com", "pepboys12345");
	}
}