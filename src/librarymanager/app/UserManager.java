package librarymanager.app;

import librarymanager.core.Admin;
import librarymanager.core.Customer;
import librarymanager.core.LibraryWorker;
import librarymanager.core.User;
import librarymanager.core.UserAlreadyExistException;
import librarymanager.core.UserNotExistException;

/**
 * 
 * Interface de gestion des utilisateurs
 * 
 */
public interface UserManager {

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
	 * @return Le nouvel administrateur cree
	 */
	public Admin createAdmin(String login, String password, String lastName,
			String firstName, String email);

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
	 * @return Le nouveau client cree
	 */
	public Customer createCustomer(String login, String password,
			String lastName, String firstName, String email);

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
	 * @return Le nouveau libraire cree
	 */
	public LibraryWorker createLibraryWorker(String login, String password,
			String lastName, String firstName, String email);
	
	/**
	 * Enregistre un utilisateur dans la base de donnees
	 * 
	 * @param user
	 *            L'utilisateur specifique a enregistrer
	 * @throws UserAlreadyExistException
	 *             levee si l'utilisateur specifie en parametre est deja present dans
	 *             la base de donnees
	 */
	public void addUser(User user) throws UserAlreadyExistException;
	
	/**
	 * Supprime un utilisateur dans la base de donnees
	 * 
	 * @param user
	 *            L'utilisateur specifique a supprimer
	 * @throws UserNotExistException
	 *             levee si l'utilisateur specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */
	public void removeUser(User user) throws UserNotExistException;
	
	/**
	 * Recupere un utilisateur dans la base de donnees
	 * 
	 * @param login
	 *            Le login de l'utilisateur specifique a recuperer
	 * @throws UserNotExistException
	 *             levee si le login de l'utilisateur specifie en parametre ne correspond
	 *             a aucun utilisateur enregistre dans la base de donnees
	 */
	public User getUser(String login) throws UserNotExistException;
	
	/**
	 * Determine si un utilisateur est existant ou non
	 * 
	 * @param user
	 *            Utilisateur recherche
	 * @return <code>true</code> si l'utilisateur est present dans la base de
	 *         donnees, <code>false</code> sinon
	 */
	public boolean exists(User user);
}
