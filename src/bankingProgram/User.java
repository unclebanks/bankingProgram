package bankingProgram;

public class User implements java.io.Serializable {
	
	// Users only need these properties
	//Add status and caseNumber properties to Customer class
	//Add admin properties to Admin class

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	
	User(String first, String last, String user, String pass, String email) {
		
		this.firstName=first;
		this.lastName=last;
		this.username=user;
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
