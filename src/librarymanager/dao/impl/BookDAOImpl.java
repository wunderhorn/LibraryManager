package librarymanager.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import librarymanager.core.Book;
import librarymanager.dao.BookDAO;

/**
 * Implementation de la gestion de la communication entre un {@link Book} et la
 * base de donnees
 */
public class BookDAOImpl extends HibernateDaoSupport implements BookDAO {

	public BookDAOImpl() {
	}

	@Override
	public boolean exists(Book book) throws Exception {
		return getHibernateTemplate().get(Book.class, book.getIsbn()) != null;
	}

	@Override
	public void save(Book book) throws Exception {
		getHibernateTemplate().save(book);
	}

	@Override
	public void delete(Book book) throws Exception {
		Book bookToDelete = (Book) getHibernateTemplate().get(Book.class,
				book.getIsbn());
		getHibernateTemplate().delete(bookToDelete);
	}
}
