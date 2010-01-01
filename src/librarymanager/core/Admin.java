package librarymanager.core;

/**
 * Classe representant un administrateur
 * 
 */
public class Admin extends User {

	/**
	 * Construit un administrateur par defaut
	 */
	public Admin() {
		super();
	}

	/**
	 * Cree un nouvel administrateur
	 * 
	 * @param login
	 * 				Login de l'administrateur
	 * @param password
	 * 				Mot de passe de l'administrateur
	 * @param lastname
	 * 				Nom de famille de l'administrateur
	 * @param firstName
	 * 				Prenom de l'administrateur
	 * @param email
	 * 				Adresse mail de l'administrateur
	 */
	public Admin(String login, String password, String lastName,
			String firstName, String email) {
		super(login, password, lastName, firstName, email);
	}
}
