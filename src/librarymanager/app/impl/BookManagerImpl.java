package librarymanager.app.impl;

import java.util.Hashtable;
import java.util.List;

import librarymanager.app.BookManager;
import librarymanager.app.LoanManager;
import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
import librarymanager.core.BookLoanException;
import librarymanager.core.BookNotExistException;
import librarymanager.dao.BookDAO;

/**
 * Implementation de la gestion des livres
 */
public class BookManagerImpl implements BookManager {

	/** Gestion de la communication entre les {@link Book} et la base de donnees */
	private BookDAO bookDAO;

	private LoanManager loanManager;
	
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

	/**
	 * @return Le {@link LoanManager}
	 */
	public LoanManager getLoanManager() {
		return loanManager;
	}

	/**
	 * Change le {@link LoanManager}
	 * 
	 * @param loanManager
	 *            Le nouveau {@link LoanManager}
	 */
	public void setLoanManager(LoanManager loanManager) {
		this.loanManager = loanManager;
	}
	
	@Override
	public Book createBook(String isbn, String author, String editor) {
		return new Book(isbn, author, editor);
	}

	@Override
	public void removeBook(Book book) throws BookNotExistException, BookLoanException {
		if (!exists(book))
			throw new BookNotExistException("The book " + book
					+ " does not exists");

			if (loanManager.bookIsLoaned(book))
					throw new BookLoanException();
		
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
	
	@Override
	public Book getBook(String isbn) throws BookNotExistException {
		Book book = null;
		try {
			book = (Book) bookDAO.getBook(isbn);
		} catch (Exception exception) {
			System.err.println("Book#getBook() exception: "
					+ exception.getMessage());
		}

		if (book == null)
			throw new BookNotExistException("The book with isbn " + isbn
					+ " does not exists");
		else
			return book;
	}
	
	@Override
	public List<Book> getBooks(Hashtable<String, String> parameter) {

		List<Book> result = null;

		try {
			result = bookDAO.getBooks(parameter);
		} catch (Exception exception) {
			System.err.println("Book#getBooks() exception: "
					+ exception.getMessage());
		}

		return result;
	}
}
