package librarymanager.dao.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import librarymanager.core.Book;
import librarymanager.dao.BookDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
	public void saveBook(Book book) throws Exception {
		getHibernateTemplate().save(book);
	}

	@Override
	public void removeBook(Book book) throws Exception {
		Book bookToDelete = (Book) getHibernateTemplate().get(Book.class,
				book.getIsbn());
		getHibernateTemplate().delete(bookToDelete);
	}
	
	@Override
	public Book getBook(String isbn) throws Exception {
		return (Book) getHibernateTemplate().get(Book.class, isbn);
	}
	
	@Override
	public List<Book> getBooks(Hashtable<String, String> parameter)
			throws Exception {

		Enumeration<String> eQuery = parameter.keys();
		String whereClause = "";

		while (eQuery.hasMoreElements()) {
			String parameterName = eQuery.nextElement();

			if (parameter.get(parameterName).equals(""))
				continue;

			whereClause += whereClause.equals("") ? "WHERE " : "AND ";

			if (parameterName.equals("isbn")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "book.isbn LIKE '"
						+ parameter.get(parameterName) + "' ";

			if (parameterName.equals("author")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "book.author LIKE '"
						+ parameter.get(parameterName) + "' ";

			if (parameterName.equals("editor")
					&& !parameter.get(parameterName).equals(""))
				whereClause += "book.editor LIKE '"
						+ parameter.get(parameterName) + "' ";

		}
		
		List<Book> result = new ArrayList<Book>();

		for (Object book : getHibernateTemplate().find(
				"FROM Book book " + whereClause))
			result.add((Book) book);

		return result;
	}
}
