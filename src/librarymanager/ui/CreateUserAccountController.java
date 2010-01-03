package librarymanager.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.UserManager;
import librarymanager.core.User;
import librarymanager.core.UserAlreadyExistException;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controleur du formulaire d'ajout d'un client
 */
public class CreateUserAccountController extends SimpleFormController {

	private UserManager userManager;

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String type = request.getParameter("type");

		if (login.isEmpty() || password.isEmpty() || lastName.isEmpty()
				|| firstName.isEmpty() || email.isEmpty()) {
			ExtremlyBadCreateUserException extremlyBadCreateUserException = new ExtremlyBadCreateUserException(
					"All fields are required");
			request.setAttribute("extremlyBadCreateUserException",
					extremlyBadCreateUserException);
			throw extremlyBadCreateUserException;
		}

		User user = null;

		if (type.equals("Customer"))
			user = userManager.createCustomer(login, password, lastName,
					firstName, email);
		else if (type.equals("Admin"))
			user = userManager.createAdmin(login, password, lastName,
					firstName, email);
		else if (type.equals("LibraryWorker"))
			user = userManager.createLibraryWorker(login, password, lastName,
					firstName, email);

		return user;
	}

	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {
		User user = ((User) command);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("login", user.getLogin());
		model.put("password", user.getPassword());
		model.put("lastName", user.getLastName());
		model.put("firstName", user.getFirstName());
		model.put("email", user.getEmail());

		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		User user = (User) command;

		try {
			userManager.addUser(user);
		} catch (UserAlreadyExistException userAlreadyExistException) {
			ExtremlyBadCreateUserException extremlyBadCreateUserException = new ExtremlyBadCreateUserException(
					"User " + user.getLogin()
							+ " already exists. Please delete him before");
			request.setAttribute("extremlyBadCreateUserException",
					extremlyBadCreateUserException);
			throw extremlyBadCreateUserException;
		}

		return this.showForm(request, response, errors);
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
