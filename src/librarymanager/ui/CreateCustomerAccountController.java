package librarymanager.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.UserManager;
import librarymanager.core.Customer;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * Controleur du formulaire d'ajout d'un client
 *
 */
public class CreateCustomerAccountController extends SimpleFormController {

	private UserManager userManager;
	
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		
		if (login.isEmpty() || password.isEmpty() || lastName.isEmpty() || firstName.isEmpty()|| email.isEmpty()) {
			//TODO Retour sur la page, champs invalides
		}
		
		return userManager.createCustomer(login, password, lastName, firstName, email);
	}

	protected Map<String, Object> referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Customer customer = ((Customer) command);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("login", customer.getLogin());
		model.put("password", customer.getPassword());
		model.put("lastName", customer.getLastName());
		model.put("firstName", customer.getFirstName());
		model.put("email", customer.getEmail());
		
		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		Customer customer = (Customer)command;
		userManager.addUser(customer);
		
		return this.showForm(request, response, errors);
	}
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
