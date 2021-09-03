package bankingProgram;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customers extends User{

	Customers(String first, String last, String username, String pass, String email) {
		super(first, last, username, pass, email);
		// TODO Auto-generated constructor stub
	}

	public static String accountApprovedStatus;
	static FileReader fr;
	static FileWriter fw;
	private static int caseNumber;
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
		
	    caseNumber = 0;
		Scanner scan=new Scanner(System.in);
	    Scanner scan2 = new Scanner(new FileInputStream("files/data.text"));

		fw=new FileWriter("files/data.text", true);
		System.out.println("Creating application, thank you for your patience.");
		if (scan2.hasNextLine()) {
			fw.write(System.getProperty("line.separator"));
			fw.write(first+last);
		} else {
			fw.write(first+last);
		}
		
		fw.close();
		System.out.println("\nFinished creating application");
	    try {
			if (p.accountApplications == 0) {
			p.accountApplications++;
			caseNumber=p.accountApplications;
			System.out.println(p.accountApplications);}
			System.out.println("It may take some time for a team member to review your account. In the meantime, here is a Case Number you can use to track the status. "+caseNumber);
			Program.main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    scan.close();
	};
	
	public void checkAppStatus() {
		System.out.println("Still need to finish");
	}
	
	public void checkForExistingApp(String first, String last) throws IOException {
		// Check for existing pending application
		fr=new FileReader("files/data.text");
		System.out.println("Looking for existing application.");
	    boolean flag = false;
	    int count = 0;
	    //Reading the contents of the file
	    Scanner scan3 = new Scanner(new FileInputStream("files/data.text"));
	    while(scan3.hasNextLine()) {
	       String line = scan3.nextLine();
	       if(line.indexOf(first+last)!=-1) {
	          flag = true;
	          count = count+1;
	       }
	    }
	      if(flag) {
	    	  Scanner scan=new Scanner(System.in);
	         System.out.println("There is currently a pending application.\nAt this time we can not create a new application.\n Would you like to check the status of the pending application (Y)es or (N)o?");
			String confirmDeny=scan.next();
			scan.close();
			if (confirmDeny.equals("Y") ||confirmDeny.equals("y") ||confirmDeny.equals("Yes") ||confirmDeny.equals("yes")) {
				this.checkAppStatus();
			}
	      } else {
	         System.out.println("An existing application could not be found");
	         this.provisionalAccount(first, last);
	      }
		
		fr.close();
		scan3.close();
	}
	
	public void login() {
		
	}

}
