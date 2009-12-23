package librarymanager.core;

/**
 * Classe representant un administrateur
 * 
 */
public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(String login, String password, String lastName,
			String firstName, String email) {
		super(login, password, lastName, firstName, email);
	}
}
