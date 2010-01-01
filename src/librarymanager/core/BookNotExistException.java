package librarymanager.core;

/**
 * Exception pour un livre qui n'existe pas
 */
@SuppressWarnings("serial")
public class BookNotExistException extends Exception {

	public BookNotExistException() {
	}

	public BookNotExistException(String arg0) {
		super(arg0);
	}

	public BookNotExistException(Throwable arg0) {
		super(arg0);
	}

	public BookNotExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
