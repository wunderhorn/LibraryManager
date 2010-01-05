package librarymanager.core;

/**
 * Exception lors de la suppression d'un utilisateur qui possede un pret en cours
 */
@SuppressWarnings("serial")
public class UserLoanException extends Exception {

	public UserLoanException() {
	}

	public UserLoanException(String arg0) {
		super(arg0);
	}

	public UserLoanException(Throwable arg0) {
		super(arg0);
	}

	public UserLoanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
