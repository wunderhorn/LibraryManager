package librarymanager.dao.impl;

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
}
