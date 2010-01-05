package librarymanager.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.LoanManager;
import librarymanager.app.UserManager;
import librarymanager.core.Book;
import librarymanager.core.Loan;
import librarymanager.core.User;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class DeleteLoanController extends SimpleFormController {
	private BookManager bookManager;
	private UserManager userManager;
	private LoanManager loanManager;

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		Book book = bookManager.getBook(request.getParameter("closeBook"));
		User user = userManager.getUser(request.getParameter("closeUser"));

		Loan loan = loanManager.getLoan(book, user);

		return loan;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Loan loan = (Loan) command;

		loanManager.removeLoan(loan);

		return this.showForm(request, response, errors);
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public LoanManager getLoanManager() {
		return loanManager;
	}

	public void setLoanManager(LoanManager loanManager) {
		this.loanManager = loanManager;
	}
}