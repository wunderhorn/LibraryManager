package librarymanager.core;

/**
 * Exception pour un stock qui n'existe pas
 */
@SuppressWarnings("serial")
public class StockNotExistException extends Exception {

	public StockNotExistException() {
	}

	public StockNotExistException(String arg0) {
		super(arg0);
	}

	public StockNotExistException(Throwable arg0) {
		super(arg0);
	}

	public StockNotExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
