package librarymanager.ui;

/**
 * Exception lors d'une erreur tres grave de creation d'utilisateur
 */
@SuppressWarnings("serial")
public class ExtremlyBadCreateUserException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExtremlyBadCreateUserException() {
		message = "";
	}

	public ExtremlyBadCreateUserException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public ExtremlyBadCreateUserException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public ExtremlyBadCreateUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
