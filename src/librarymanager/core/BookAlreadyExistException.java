package librarymanager.core;

/**
 * Exception pour un livre deja existant
 */
@SuppressWarnings("serial")
public class BookAlreadyExistException extends Exception {

	public BookAlreadyExistException() {
	}

	public BookAlreadyExistException(String arg0) {
		super(arg0);
	}

	public BookAlreadyExistException(Throwable arg0) {
		super(arg0);
	}

	public BookAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
