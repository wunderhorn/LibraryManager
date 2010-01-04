package librarymanager.ui;

/**
 * Exception lors d'une erreur d'enregistrement d'un pret
 */
@SuppressWarnings("serial")
public class RegisterLoanException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RegisterLoanException() {
		message = "";
	}

	public RegisterLoanException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public RegisterLoanException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public RegisterLoanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
