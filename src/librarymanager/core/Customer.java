package librarymanager.core;

/**
 * Classe representant un client
 * 
 */
public class Customer extends User {

	/**
	 * Construit un client par defaut
	 */
	public Customer() {
		super();
	}

	/**
	 * Cree un nouvel client
	 * 
	 * @param login
	 * 				Login du client
	 * @param password
	 * 				Mot de passe du client
	 * @param lastname
	 * 				Nom de famille du client
	 * @param firstName
	 * 				Prenom du client
	 * @param email
	 * 				Adresse mail du client
	 */
	public Customer(String login, String password, String lastName,
			String firstName, String email) {
		super(login, password, lastName, firstName, email);
	}
}
