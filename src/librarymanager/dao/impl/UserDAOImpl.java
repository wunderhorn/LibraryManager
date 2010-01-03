package librarymanager.dao.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import librarymanager.core.User;
import librarymanager.dao.UserDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * Classe pour la gestion de la persistance des utilisateurs
 * 
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	@Override
	public void saveUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void removeUser(User user) throws Exception {
		User userToDelete = (User) getHibernateTemplate().get(User.class,
				user.getLogin());
		getHibernateTemplate().delete(userToDelete);
	}

	@Override
	public User getUser(String login) throws Exception {
		return (User) getHibernateTemplate().get(User.class, login);
	}

	@Override
	public boolean exists(User user) throws Exception {
		return getHibernateTemplate().get(User.class, user.getLogin()) != null;
	}

	@Override
	public List<User> getUsers(Hashtable<String, String> parameter)
			throws Exception {

		Enumeration<String> eQuery = parameter.keys();
		String whereClause = "";

		while (eQuery.hasMoreElements()) {
			String parameterName = eQuery.nextElement();

			if (parameter.get(parameterName).equals(""))
				continue;

			whereClause += whereClause.equals("") ? "WHERE " : "AND ";

			if (parameterName.equals("login")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "user.login LIKE '"
						+ parameter.get(parameterName) + "' ";

			if (parameterName.equals("lastName")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "user.lastName LIKE '"
						+ parameter.get(parameterName) + "' ";

			if (parameterName.equals("firstName")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "user.firstName LIKE '"
						+ parameter.get(parameterName) + "' ";

			if (parameterName.equals("email")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "user.email LIKE '"
						+ parameter.get(parameterName) + "' ";
		}
		
		List<User> result = new ArrayList<User>();

		for (Object user : getHibernateTemplate().find(
				"FROM User user " + whereClause))
			result.add((User) user);

		return result;
	}
}
