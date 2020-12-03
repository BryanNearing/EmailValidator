package verifyerPack;
import java.util.Hashtable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;

public class emailVerification {

	public static void main(String[] args) {
		
		ArrayList<EmailInfo> ht = new ArrayList<EmailInfo>();
		
		EmailInfo e = new EmailInfo("bryan@nearing.com");
		ht.add(e);
		EmailInfo e1 = new EmailInfo("brad@nearing.com");
		ht.add(e1);
		EmailInfo e2 = new EmailInfo("brent@nearing.com");
		ht.add(e2);
		
		Scanner s = new Scanner(System.in);
		
		boolean done = false;
		
		while(done == false) {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1) Check to see if an email is in the system");
			System.out.println("2) Enter an email into the system");
			System.out.println("3) Print all emails currently in the system");
			System.out.println("4) Exit");
			int choice = -1;
			String emailString = "";
			try {
				choice = s.nextInt();
			}
			catch(Exception ex) {
				System.out.println("Exception " + ex);
			}
			s.nextLine();
			
			switch(choice) {
			
			case 1:
				System.out.println("What is the email you would like to check for?");
				emailString = s.nextLine();
				verifyEmail(ht, emailString);
				break;
			case 2:
				boolean valid = false;
				while(valid == false) {
					System.out.println("What is the email you would like to enter into the system?");
					emailString = s.nextLine();
					valid = validEmail(emailString);
					if(valid == false)
						System.out.println("That was not a valid email.");
					if(inSystem(ht, emailString))
						System.out.println("Already in the system.");
				}
				EmailInfo e3 = new EmailInfo(emailString);
				ht.add(e3);
				break;
			case 3:
				printEmails(ht);
				break;
			case 4:
				done = true;
				break;
			default:
				System.out.println("The entry was not valid.");
			
			}
			
		}

	}
	
	public static void verifyEmail(ArrayList<EmailInfo> ht, String email) {
		boolean inSystem = false;
		
		for(EmailInfo e : ht) {
			if(e.getEmail().equals(email)) 
				inSystem = true;
		}
		
		if(inSystem == true) {
			System.out.println("This email is in the system.");
			System.out.println();
		}
		else {
			System.out.println("This email is not in the system.");
			System.out.println();
		}
	}
	
	public static boolean validEmail(String email) {
		boolean validity = false;
		
		Pattern p = Pattern.compile("[a-zA-Z0-9]*@[a-zA-Z0-9]*.[a-zA-Z]*");
		Matcher m = p.matcher(email);
		validity = m.matches();
		
		return validity;
	}
	
	public static boolean inSystem(ArrayList<EmailInfo> ht, String email) {
		boolean inSystem = false;
		
		for(EmailInfo e : ht) {
			if(e.getEmail().equals(email)) 
				inSystem = true;
		}
		
		return inSystem;
	}
	
	public static void printEmails(ArrayList<EmailInfo> ht){
		for(EmailInfo e : ht) {
			System.out.println(e.getEmail());
		}
	}

}
