package librarymanager.core;

/**
 * Classe abstraite representant un utilisateur
 *
 */
public abstract class User {
	
	public final String DEFAULT_FIELD = "NONE";
	
	private String login;
	private String password;
	private String lastname;
	private String firstName;
	private String email;
	
	public User() {
		login = DEFAULT_FIELD;
		password = DEFAULT_FIELD;
		lastname = DEFAULT_FIELD;
		firstName = DEFAULT_FIELD;
		email = DEFAULT_FIELD;
	}
	
	public User(String login, String password, String lastname,
			String firstName, String email) {
		this.login = login;
		this.password = password;
		this.lastname = lastname;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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