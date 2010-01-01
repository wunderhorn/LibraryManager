package librarymanager.core;

/**
 * Classe abstraite representant un utilisateur
 * 
 */
public abstract class User {

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
	 * 				Login de l'utilisateur
	 * @param password
	 * 				Mot de passe de l'utilisateur
	 * @param lastname
	 * 				Nom de famille de l'utilisateur
	 * @param firstName
	 * 				Prenom de l'utilisateur
	 * @param email
	 * 				Adresse mail de l'utilisateur
	 */
	public User(String login, String password, String lastName,
			String firstName, String email) {
		this.login = login;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
