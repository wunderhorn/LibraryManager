package librarymanager.core;

public class Admin extends User {
	
	public Admin() {
		super();
	}
	
	public Admin(String login, String password, String lastname,
			String firstName, String email) {
		super(login, password, lastname, firstName, email);
	}

}
