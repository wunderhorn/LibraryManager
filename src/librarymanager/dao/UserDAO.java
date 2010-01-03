package librarymanager.dao;

import java.util.Hashtable;
import java.util.List;

import librarymanager.core.User;
import librarymanager.core.UserNotExistException;

/**
 * Interface de gestion de communication entre un {@link User} et la base de
 * donnees
 */
public interface UserDAO
{
	/**
	 * Sauvegarde un utilisateur dans la base de donnees
	 * 
	 * @param user
	 *            L'utilisateur a sauvegarder
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void saveUser(User user) throws Exception;
	
	/**
	 * Verifie la presence d'un utilisateur dans la base de donnees
	 * 
	 * @param user
	 *            L'utilisateur a verifier
	 * @return <code>true</code> si l'utilisateur a verifier est present dans la base
	 *         de donnees, <code>false</code> sinon
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void removeUser(User user) throws Exception;
	
	/**
	 * Recupere un utilisateur dans la base de donnees
	 * 
	 * @param login
	 *            Le login de l'utilisateur specifique a recuperer
	 * @throws UserNotExistException
	 *             levee si le login de l'utilisateur specifie en parametre ne correspond
	 *             a aucun utilisateur enregistre dans la base de donnees
	 */
	public User getUser(String login) throws Exception;
	
	/**
	 * Verifie la presence d'un utilisateur dans la base de donnees
	 * 
	 * @param user
	 *            L'utilisateur a verifier
	 * @return <code>true</code> si l'utilisateur a verifier est present dans la base
	 *         de donnees, <code>false</code> sinon
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public boolean exists(User user) throws Exception;
	
	/**
	 * Recupere un utilisateur dans la base de donnees
	 * 
	 * @param parameter
	 *            Les parametres de la requete
	 */
	public List<User> getUsers(Hashtable<String, String> parameter) throws Exception;
}
