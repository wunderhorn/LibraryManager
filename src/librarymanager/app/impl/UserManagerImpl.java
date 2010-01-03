package librarymanager.app.impl;

import java.util.Hashtable;
import java.util.List;

import librarymanager.app.UserManager;
import librarymanager.core.Admin;
import librarymanager.core.Customer;
import librarymanager.core.LibraryWorker;
import librarymanager.core.User;
import librarymanager.core.UserAlreadyExistException;
import librarymanager.core.UserNotExistException;
import librarymanager.dao.UserDAO;

/**
 * 
 * Classe de gestion des utilisateurs
 * 
 */
public class UserManagerImpl implements UserManager {

	private UserDAO userDAO;

	public UserManagerImpl() {
	}

	/**
	 * @return Le {@link UserDAO}
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Change le {@link UserDAO}
	 * 
	 * @param userDAO
	 *            Le nouveau {@link UserDAO}
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

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
	public void addUser(User user) throws UserAlreadyExistException {
		if (exists(user))
			throw new UserAlreadyExistException("The user " + user
					+ " already exists");

		try {
			userDAO.saveUser(user);
		} catch (Exception exception) {
			System.err.println("User#addUser() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void removeUser(User user) throws UserNotExistException {
		if (!exists(user))
			throw new UserNotExistException("The user " + user
					+ " does not exists");

		try {
			userDAO.removeUser(user);
		} catch (Exception exception) {
			System.err.println("User#removeUser() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public User getUser(String login) throws UserNotExistException {
		User user = null;
		try {
			user = (User) userDAO.getUser(login);
		} catch (Exception exception) {
			System.err.println("User#getUser() exception: "
					+ exception.getMessage());
		}

		if (user == null)
			throw new UserNotExistException("The user with login " + login
					+ " does not exists");
		else
			return user;
	}

	@Override
	public boolean exists(User user) {
		try {
			return userDAO.exists(user);
		} catch (Exception exception) {
			System.err.println("User#exists() exception: "
					+ exception.getMessage());
			return false;
		}
	}

	@Override
	public List<User> getUsers(Hashtable<String, String> parameter) {

		List<User> result = null;

		try {
			result = userDAO.getUsers(parameter);
		} catch (Exception exception) {
			System.err.println("User#getUser() exception: "
					+ exception.getMessage());
		}

		return result;
	}
}
