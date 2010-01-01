package librarymanager.dao;

import librarymanager.core.User;

/**
 * 
 * Interface pour la gestion de la persistance des utilisateurs
 * 
 */
public interface UserDAO
{
	public void saveUser(User user);
	
	public void removeUser(User user);
	
	public User getUser(String login);
}
