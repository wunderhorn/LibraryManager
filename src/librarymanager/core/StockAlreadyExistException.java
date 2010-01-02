package librarymanager.core;

/**
 * Exception pour un stock deja existant
 */
@SuppressWarnings("serial")
public class StockAlreadyExistException extends Exception {

	public StockAlreadyExistException() {
	}

	public StockAlreadyExistException(String arg0) {
		super(arg0);
	}

	public StockAlreadyExistException(Throwable arg0) {
		super(arg0);
	}

	public StockAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
