package librarymanager.ui;

/**
 * Exception lors d'une erreur de connexion
 */
@SuppressWarnings("serial")
public class ErrorConnectException extends Exception {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorConnectException() {
		message = "";
	}

	public ErrorConnectException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public ErrorConnectException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public ErrorConnectException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
