package librarymanager.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.UserManager;
import librarymanager.core.User;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class DeleteUserAccountController extends SimpleFormController
{
	private UserManager userManager;

	protected Object formBackingObject(HttpServletRequest request)
	throws Exception {
		User user = userManager.getUser((String) (request.getParameter("deleteLogin")));
		
		return user;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception
	{	
		User user = (User) command;
		
		userManager.removeUser(user);
		
		return this.showForm(request, response, errors);
	}
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}