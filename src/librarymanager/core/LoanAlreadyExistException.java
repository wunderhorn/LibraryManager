package librarymanager.core;

/**
 * Exception pour un pret deja existant
 */
@SuppressWarnings("serial")
public class LoanAlreadyExistException extends Exception {

	public LoanAlreadyExistException() {
	}

	public LoanAlreadyExistException(String arg0) {
		super(arg0);
	}

	public LoanAlreadyExistException(Throwable arg0) {
		super(arg0);
	}

	public LoanAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
