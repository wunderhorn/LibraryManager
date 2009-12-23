package librarymanager.dao.impl;

import librarymanager.core.User;
import librarymanager.dao.UserDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO
{
	@Override
	public void saveUser(User user) {
		getHibernateTemplate().save(user);
	}
	
}
