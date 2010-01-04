
package librarymanager.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import librarymanager.app.LoanManager;
import librarymanager.core.Customer;
import librarymanager.core.Loan;
import librarymanager.core.User;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * Controleur du formulaire de recherche de pret
 * 
 */
public class SearchLoanController extends SimpleFormController {

	private LoanManager loanManager;

	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		List<Loan> query = new ArrayList<Loan>();
		
		if (user instanceof Customer)
			query = loanManager.getLoansbyUser(user);
		else
			query = loanManager.getAllLoans();
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("query", query);

		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		return this.showForm(request, response, errors);
	}

	public LoanManager getLoanManager() {
		return loanManager;
	}

	public void setLoanManager(LoanManager loanManager) {
		this.loanManager = loanManager;
	}

}
