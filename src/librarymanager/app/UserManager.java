package librarymanager.app;

import librarymanager.core.Admin;
import librarymanager.core.Customer;
import librarymanager.core.LibraryWorker;
import librarymanager.core.User;

/**
 * 
 * Interface de gestion des utilisateurs
 * 
 */
public interface UserManager {

	/**
	 * Cree un nouvel utilisateur
	 * 
	 * @param login
	 * @param password
	 * @param lastname
	 * @param firstName
	 * @param email
	 * @return
	 */
	public Admin createAdmin(String login, String password, String lastName,
			String firstName, String email);

	/**
	 * Cree un nouveau client
	 * 
	 * @param login
	 * @param password
	 * @param lastname
	 * @param firstName
	 * @param email
	 * @return Un nouveau client
	 */
	public Customer createCustomer(String login, String password,
			String lastName, String firstName, String email);

	/**
	 * Cree un nouveau libraire
	 * 
	 * @param login
	 * @param password
	 * @param lastname
	 * @param firstName
	 * @param email
	 * @return Un nouveau libraire
	 */
	public LibraryWorker createLibraryWorker(String login, String password,
			String lastName, String firstName, String email);
	
	public void addUser(User user);
}
