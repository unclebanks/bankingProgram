package bankingProgram;

import java.util.Scanner;

public class Program {
	
	public int accountApplications;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);		
		System.out.println("Welcome to Deadbeef Bank. How may we assist you today?\n1. Apply for account\n2. Login\n3. Admin\n4. Application Status");
		String initial=scan.next();
		Customers c=new Customers(initial, initial, initial, initial, initial, initial, 0);
		Administrator a=new Administrator();
		switch(initial) {
		case "1": c.applyForAccount();
		break;
		case "2": c.login();
		break;
		case "3": a.admin();
		break;
		case "4":c.checkAppStatus();
		break;
		default: System.out.println("Please make a valid selection");
		};
		scan.close();

	}

}
