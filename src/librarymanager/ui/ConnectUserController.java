package librarymanager.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import librarymanager.app.UserManager;
import librarymanager.core.User;
import librarymanager.core.UserNotExistException;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controleur du formulaire d'ajout d'un client
 */
public class ConnectUserController extends SimpleFormController {
	/** Interface de gestion des utilisateurs */
	private UserManager userManager;

	/**
	 * @return l'interface de gestion des utilisateurs
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * Change l'interface de gesion des utilisateurs
	 * 
	 * @param userManager
	 *            La nouvelle interface de gestion des utilisateurs
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User user = null;

		try {
			user = userManager.getUser(login);
		} catch (UserNotExistException exception) {
			ErrorConnectException errorConnectException = new ErrorConnectException(
					"User " + login + " doesn't exist");
			request
					.setAttribute("errorConnectException",
							errorConnectException);
			throw errorConnectException;
		}

		if (!user.getPassword().equals(password)) {
			ErrorConnectException errorConnectException = new ErrorConnectException(
					"Authentification failed. Bad password");
			request
					.setAttribute("errorConnectException",
							errorConnectException);
			throw errorConnectException;
		}

		return user;
	}

	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("user", command);

		return new HashMap<String, Object>();
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		return this.showForm(request, response, errors);
	}
}
