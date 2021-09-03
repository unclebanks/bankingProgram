package bankingProgram;

import java.util.Scanner;

public class Administrator {
	
	public void admin() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome and thank you for continuing to be a part of the team. What would you like to do today?\n1. Login\n2. Exit");
		String choice=scan.next();
		switch(choice) {
		case "1": this.login();
		break;
		case "2": Program.main(null);
		break;
		}
		scan.close();
	}
	
	private void login() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter your username");
		String username=scan.next();
		System.out.println("Please enter your password");
		String password=scan.next();
		System.out.println(username+password);
		scan.close();
	}

}
