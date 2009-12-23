package librarymanager.core;

/**
 * Classe representant un libraire
 *
 */
public class LibraryWorker extends User {
	
	public LibraryWorker() {
		super();
	}
	
	public LibraryWorker(String login, String password, String lastName,
			String firstName, String email) {
		super(login, password, lastName, firstName, email);
	}
}
