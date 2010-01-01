package librarymanager.core;

/**
 * Exception pour un utilisateur deja existant
 */
@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception {

	public UserAlreadyExistException() {
	}

	public UserAlreadyExistException(String arg0) {
		super(arg0);
	}

	public UserAlreadyExistException(Throwable arg0) {
		super(arg0);
	}

	public UserAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
