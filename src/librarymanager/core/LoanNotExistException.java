package librarymanager.core;

/**
 * Exception pour un pret qui n'existe pas
 */
@SuppressWarnings("serial")
public class LoanNotExistException extends Exception {

	public LoanNotExistException() {
	}

	public LoanNotExistException(String arg0) {
		super(arg0);
	}

	public LoanNotExistException(Throwable arg0) {
		super(arg0);
	}

	public LoanNotExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
