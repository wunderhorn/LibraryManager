package librarymanager.core;

public class Customer extends User {
	
	public Customer() {
		super();
	}
	
	public Customer(String login, String password, String lastname,
			String firstName, String email) {
		super(login, password, lastname, firstName, email);
	}

}
