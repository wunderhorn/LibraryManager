package librarymanager.core;

/**
 * Classe representant un libraire
 *
 */
public class LibraryWorker extends User {
	
	/**
	 * Construit un libraire par defaut
	 */
	public LibraryWorker() {
		super();
	}
	
	/**
	 * Cree un nouveau libraire
	 * 
	 * @param login
	 * 				Login du libraire
	 * @param password
	 * 				Mot de passe du libraire
	 * @param lastname
	 * 				Nom de famille du libraire
	 * @param firstName
	 * 				Prenom du libraire
	 * @param email
	 * 				Adresse mail du libraire
	 */
	public LibraryWorker(String login, String password, String lastName,
			String firstName, String email) {
		super(login, password, lastName, firstName, email);
	}
}
