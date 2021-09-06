package bankingProgram;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Customers extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Add status and caseNumber here
	final String filePath="files/data.text";

	Customers(String first, String last, String username, String password, String email, String status) {
		super(first, last, username, password, email);
		// TODO Auto-generated constructor stub
	}
    Program p=new Program();
	
	public void applyForAccount() {

		Scanner scan=new Scanner(System.in);
		
		System.out.println("Thank you for taking a moment to apply for an account with Deadbeef Bank.\n Please enter your first and last name to continue this process.");
		String first=scan.next();
		String last=scan.next();
		
		
		System.out.println(first+" "+last+" Is this correct?\n (Y)es or (N)o?");
		String confirmDeny=scan.next();
		
		if (confirmDeny.equals("Y") || confirmDeny.equals("Yes") || confirmDeny.equals("yes") || confirmDeny.equals("y")) {
			try {
				this.checkForExistingApp(first, last);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (confirmDeny.equals("N") || confirmDeny.equals("No") || confirmDeny.equals("no") || confirmDeny.equals("n")) {
			try {
				this.checkForExistingApp(first, last);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Please enter a valid value");
			System.out.println(" ");
			this.applyForAccount();
		}
		scan.close();
	};
	
	public void provisionalAccount(String first, String last) throws IOException {
		
	    String email;
	    String password;
	    String userName;
	    String status="pending";
	    String pause;
	    String test2;
	    
		Scanner scan=new Scanner(System.in);
	    Scanner scan2 = new Scanner(new FileInputStream("files/data.text"));
	    System.out.println("Prepare for Jesus");
        Set<Customers> returnThis = new HashSet<Customers>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fis);

            returnThis = (Set<Customers>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("It appears there is no data. Jesus cannot arrive, continuing with operations.");
        }
        System.out.println(returnThis);
        System.out.println("Did Jesus arrive?");
	    pause=scan.next();
	    System.out.println("Please enter your email.");
	    email=scan.next();
	    System.out.println("Please select a username.");
	    userName=scan.next();
	    System.out.println("Please enter a password to protect your account.");
	    password=scan.next();
		System.out.println("Creating application, thank you for your patience.");
		Set<Customers> users=new HashSet<>();
		System.out.println("Created list");
		users.add(new Customers(first.toLowerCase(), last.toLowerCase(), userName, password, email, status));
		users.add(new Customers("craig", last.toLowerCase(), userName, password, email, status));
		users.add(new Customers("jones", last.toLowerCase(), userName, password, email, status));
		users.add(new Customers("craig", "Davos", userName, password, email, status));
		System.out.println("Added users to list======================================");
		Customers[] People= users.toArray(new Customers[users.size()]);
		for (Customers C: People) {
			System.out.println(C);
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(People[1]);
		System.out.println("SUPERTESTMONKEY\nSUPERTESTMONKEY\nSUPERTESTMONKEY");

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            System.out.println("Prepare to write to file");
            out.writeObject(users);
            System.out.println("Finished writing to file");
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		test2=scan.next();
	    scan.close();
	    System.out.println("Prepare to jump^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6");
	};
	
	public void checkAppStatus() {
		System.out.println("To search for a pending application, please enter the associated email.");
		Scanner scan=new Scanner(System.in);
		String email=scan.next();
		scan.close();
		
		
	}
	
	public void checkForExistingApp(String first, String last) throws IOException {
		// Check for existing pending application
		System.out.println("Looking for existing application.");
        Set<Customers> returnThis = new HashSet<Customers>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fis);

            returnThis = (Set<Customers>) in.readObject();
            System.out.println(returnThis);
            System.out.println("Successfully read from save data");
            in.close();
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("There is no data in the file/n Continuing process to generate some.");
        } 
		this.provisionalAccount(first, last);
	}
	
	public void login() {
		
	}

}
