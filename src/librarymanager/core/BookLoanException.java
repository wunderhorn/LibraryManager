package librarymanager.core;

/**
 * Exception lors de la suppression d'un livre en cours de location
 */
@SuppressWarnings("serial")
public class BookLoanException extends Exception {

	public BookLoanException() {
	}

	public BookLoanException(String arg0) {
		super(arg0);
	}

	public BookLoanException(Throwable arg0) {
		super(arg0);
	}

	public BookLoanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
