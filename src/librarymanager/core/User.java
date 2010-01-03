package librarymanager.core;

/**
 * Classe abstraite representant un utilisateur
 * 
 */
public class User {

	/** Valeur par defaut d'un champ */
	public final String DEFAULT_FIELD = "NONE";

	/** Login de l'utilisateur */
	private String login;

	/** Mot de passe de l'utilisateur */
	private String password;

	/** Nom de famille de l'utilisateur */
	private String lastName;

	/** Prenom de l'utilisateur */
	private String firstName;

	/** Adresse mail de l'utilisateur */
	private String email;

	/**
	 * Construit un utilisateur par defaut
	 */
	public User() {
		login = DEFAULT_FIELD;
		password = DEFAULT_FIELD;
		lastName = DEFAULT_FIELD;
		firstName = DEFAULT_FIELD;
		email = DEFAULT_FIELD;
	}

	/**
	 * Cree un nouvel utilisateur
	 * 
	 * @param login
	 *            Login de l'utilisateur
	 * @param password
	 *            Mot de passe de l'utilisateur
	 * @param lastname
	 *            Nom de famille de l'utilisateur
	 * @param firstName
	 *            Prenom de l'utilisateur
	 * @param email
	 *            Adresse mail de l'utilisateur
	 */
	public User(String login, String password, String lastName,
			String firstName, String email) {
		this.login = login;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	/**
	 * @return Le login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Modifie le login
	 * 
	 * @param login
	 *            Le nouveau login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return Le mot de passe
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Modifie le password
	 * 
	 * @param password
	 *            Le nouveau password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Le nom de famille
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Modifie le nom de famille
	 * 
	 * @param lastName
	 *            Le nouveau nom de famille
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Le prenom
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Modifie le prenom
	 * 
	 * @param firstName
	 *            Le nouveau prenom
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Le mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Modifie l'adresse mail
	 * 
	 * @param email
	 *            La nouvelle adresse mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User characteristics: \n" + "\tLogin\t: " + getLogin() + "\n"
				+ "\tPassword\t: " + getPassword() + "\n" + "\tLastName\t: "
				+ getLastName() + "\n" + "\tFirstName\t:" + getFirstName()
				+ "\n" + "\tEmail\t: " + getEmail() + "\n";
	}

}
