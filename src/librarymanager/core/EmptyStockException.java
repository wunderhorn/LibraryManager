package librarymanager.core;

/**
 * Exception lorsque le stock d'un livre est a zero
 */
@SuppressWarnings("serial")
public class EmptyStockException extends Exception {

	public EmptyStockException() {
	}

	public EmptyStockException(String arg0) {
		super(arg0);
	}

	public EmptyStockException(Throwable arg0) {
		super(arg0);
	}

	public EmptyStockException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
