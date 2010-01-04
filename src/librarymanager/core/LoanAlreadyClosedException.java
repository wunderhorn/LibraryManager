package librarymanager.core;

/**
 * Exception pour un pret deja cloture
 */
@SuppressWarnings("serial")
public class LoanAlreadyClosedException extends Exception {

	public LoanAlreadyClosedException() {
	}

	public LoanAlreadyClosedException(String arg0) {
		super(arg0);
	}

	public LoanAlreadyClosedException(Throwable arg0) {
		super(arg0);
	}

	public LoanAlreadyClosedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
