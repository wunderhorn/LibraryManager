package librarymanager.ui;

/**
 * Exception lors d'une erreur d'enregistrement d'un livre
 */
@SuppressWarnings("serial")
public class RegisterBookException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RegisterBookException() {
		message = "";
	}

	public RegisterBookException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public RegisterBookException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public RegisterBookException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
