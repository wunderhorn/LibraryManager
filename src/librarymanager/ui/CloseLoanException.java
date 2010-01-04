package librarymanager.ui;

/**
 * Exception lorsqu'on cloture un pret deja cloture
 */
@SuppressWarnings("serial")
public class CloseLoanException extends Exception {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CloseLoanException() {
		message = "";
	}

	public CloseLoanException(String arg0) {
		super(arg0);
		message = arg0;
	}

	public CloseLoanException(Throwable arg0) {
		super(arg0);
		message = "";
	}

	public CloseLoanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		message = arg0;
	}
}
