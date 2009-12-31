package librarymanager.app.impl;

import librarymanager.app.BookManager;
import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
import librarymanager.dao.BookDAO;

/**
 * Implementation de la gestion des livres
 */
public class BookManagerImpl implements BookManager {

	/** Gestion de la communication entre les {@link Book} et la base de donnees */
	private BookDAO bookDAO;

	public BookManagerImpl() {
	}

	@Override
	public Book createBook(String isbn, String author, String editor) {
		return new Book(isbn, author, editor);
	}

	@Override
	public void register(Book book) throws BookAlreadyExistException {
		if (exists(book))
			throw new BookAlreadyExistException("The book " + book
					+ " already exists");

		try {
			bookDAO.save(book);
		} catch (Exception exception) {
			System.err.println("Book#register() exeception: "
					+ exception.getMessage());
		}
	}

	@Override
	public boolean exists(Book book) {
		try {
			return bookDAO.exists(book);
		} catch (Exception exception) {
			System.err.println("Book#exists() exeception: "
					+ exception.getMessage());
			return false;
		}
	}

}
