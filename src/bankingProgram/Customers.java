package bankingProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers extends User implements java.io.Serializable{
	
	//Add status and caseNumber here

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		}
		scan.close();
	};
	
	public void provisionalAccount(String first, String last) throws IOException {
		
	    String email;
	    String password;
	    String userName;
	    String status="pending";
	    
		Scanner scan=new Scanner(System.in);
	    Scanner scan2 = new Scanner(new FileInputStream("files/data.text"));
	    System.out.println("Please enter your email.");
	    email=scan.next();
	    System.out.println("Please select a username.");
	    userName=scan.next();
	    System.out.println("Please enter a password to protect your account.");
	    password=scan.next();
		System.out.println("Creating application, thank you for your patience.");
		ArrayList<Customers> users=new ArrayList<>();
		System.out.println("Created list");
		users.add(new Customers(first.toLowerCase(), last.toLowerCase(), userName, password, email, status));
		System.out.println("Added users to list======================================");
	    scan.close();
	    System.out.println("Prepare to jump^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6");
	    this.writeCustomers((ArrayList<Customers>) users);
	};

    public void writeCustomers(ArrayList<Customers> users) {

        try {
    		final String filePath="files/data.text";
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            System.out.println("Prepare to write++++++++++++++++++++++++++++++++++++++++++++++");
            out.writeObject(users);
            System.out.println("Writing complete captain!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(this.readCustomers());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public final String filePath = "files/data.text";

    public ArrayList<Customers> readCustomers() {
        ArrayList<Customers> returnThis = new ArrayList<Customers>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fis);

            returnThis = (ArrayList<Customers>) in.readObject();
            System.out.println(returnThis);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnThis;
    }
	
	public void checkAppStatus() {
		System.out.println("To search for a pending application, please enter the associated email.");
		Scanner scan=new Scanner(System.in);
		String email=scan.next();
		scan.close();
		
		
	}
	
	public void checkForExistingApp(String first, String last) throws IOException {
		// Check for existing pending application
		System.out.println("Looking for existing application.");
		this.readCustomers();
		this.provisionalAccount(first, last);
	}
	
	public void login() {
		
	}

}
