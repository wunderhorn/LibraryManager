package librarymanager.ui;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.UserManager;
import librarymanager.core.User;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * Controleur du formulaire de recherche d'utilisateurs
 * 
 */
public class SearchUserAccountController extends SimpleFormController {

	private UserManager userManager;

	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {

		Hashtable<String, String> parameter = new Hashtable<String, String>();

		parameter.put("login", request.getParameter("login"));
		parameter.put("lastName", request.getParameter("lastName"));
		parameter.put("firstName", request.getParameter("firstName"));
		parameter.put("email", request.getParameter("email"));
		List<User> query = userManager.getUsers(parameter);

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("query", query);

		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		return this.showForm(request, response, errors);
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
