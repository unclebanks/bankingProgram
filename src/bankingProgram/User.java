package bankingProgram;

public class User {

	String firstName;
	String lastName;
	String username;
	String password;
	String email;
	
	User(String first, String last, String username, String pass, String email) {
		
		this.firstName=first;
		this.lastName=last;
		this.username=username;
		this.password=pass;
		this.email=email;
	}
	
	public String toString() {
		
		return firstName+" "+lastName+" "+username+" "+password+" "+email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
