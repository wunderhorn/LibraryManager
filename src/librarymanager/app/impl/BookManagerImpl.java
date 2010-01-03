package librarymanager.app.impl;

import librarymanager.app.BookManager;
import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
import librarymanager.core.BookNotExistException;
import librarymanager.dao.BookDAO;

/**
 * Implementation de la gestion des livres
 */
public class BookManagerImpl implements BookManager {

	/** Gestion de la communication entre les {@link Book} et la base de donnees */
	private BookDAO bookDAO;

	public BookManagerImpl() {
	}

	/**
	 * @return Le {@link BookDAO}
	 */
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	/**
	 * Change le {@link BookDAO}
	 * 
	 * @param bookDAO
	 *            Le nouveau {@link BookDAO}
	 */
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public Book createBook(String isbn, String author, String editor) {
		return new Book(isbn, author, editor);
	}

	@Override
	public void removeBook(Book book) throws BookNotExistException {
		if (!exists(book))
			throw new BookNotExistException("The book " + book
					+ " does not exists");

		try {
			bookDAO.removeBook(book);
		} catch (Exception exception) {
			System.err.println("Book#removeBook() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void addBook(Book book) throws BookAlreadyExistException {
		if (exists(book))
			throw new BookAlreadyExistException("The book " + book
					+ " already exists");

		try {
			bookDAO.saveBook(book);
		} catch (Exception exception) {
			System.err.println("Book#addBook() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public boolean exists(Book book) {
		try {
			return bookDAO.exists(book);
		} catch (Exception exception) {
			System.err.println("Book#exists() exception: "
					+ exception.getMessage());
			return false;
		}
	}

}
