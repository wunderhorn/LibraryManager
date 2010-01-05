package librarymanager.ui;

/**
 * Exception lors d'une erreur de suppression de livre
 */
@SuppressWarnings("serial")
public class DeleteBookException extends Exception {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DeleteBookException() {
		message = "";
	}

	public DeleteBookException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public DeleteBookException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public DeleteBookException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
