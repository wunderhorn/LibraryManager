package librarymanager.core;

/**
 * Exception pour un utilisateur qui n'existe pas
 */
@SuppressWarnings("serial")
public class UserNotExistException extends Exception {

	public UserNotExistException() {
	}

	public UserNotExistException(String arg0) {
		super(arg0);
	}

	public UserNotExistException(Throwable arg0) {
		super(arg0);
	}

	public UserNotExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
