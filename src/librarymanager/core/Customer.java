package librarymanager.core;

/**
 * Classe representant un client
 * 
 */
public class Customer extends User {

	public Customer() {
		super();
	}

	public Customer(String login, String password, String lastName,
			String firstName, String email) {
		super(login, password, lastName, firstName, email);
	}
}
