package librarymanager.ui;

/**
 * Exception lors d'une erreur de suppression d'un utilisateur
 */
@SuppressWarnings("serial")
public class DeleteUserException extends Exception {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DeleteUserException() {
		message = "";
	}

	public DeleteUserException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public DeleteUserException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public DeleteUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
