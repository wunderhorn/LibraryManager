package librarymanager.app.impl;

import librarymanager.app.UserManager;
import librarymanager.core.Admin;
import librarymanager.core.Customer;
import librarymanager.core.LibraryWorker;
import librarymanager.core.User;
import librarymanager.dao.UserDAO;

/**
 * 
 * Classe de gestion des utilisateurs
 * 
 */
public class UserManagerImpl implements UserManager {

	private UserDAO userDAO;

	@Override
	public Admin createAdmin(String login, String password, String lastName,
			String firstName, String email) {
		return new Admin(login, password, lastName, firstName, email);
	}

	@Override
	public Customer createCustomer(String login, String password,
			String lastName, String firstName, String email) {
		return new Customer(login, password, lastName, firstName, email);
	}

	@Override
	public LibraryWorker createLibraryWorker(String login, String password,
			String lastName, String firstName, String email) {
		return new LibraryWorker(login, password, lastName, firstName, email);
	}

	@Override
	public void addUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	public void removeUser(User user) {
		userDAO.removeUser(user);
	}

	@Override
	public User getUser(String login) {
		return (User) userDAO.getUser(login);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
