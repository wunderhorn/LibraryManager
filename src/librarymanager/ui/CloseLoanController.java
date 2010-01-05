package librarymanager.ui;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.LoanManager;
import librarymanager.app.UserManager;
import librarymanager.core.Book;
import librarymanager.core.Loan;
import librarymanager.core.LoanAlreadyClosedException;
import librarymanager.core.User;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CloseLoanController extends SimpleFormController {
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
		try {
			loanManager.closeLoan(loan, Calendar.getInstance().getTime());
		} catch (LoanAlreadyClosedException exception) {
			CloseLoanException closeLoanException = new CloseLoanException(
					"The loan of the book " + loan.getBook().getIsbn()
							+ " by the user " + loan.getUser().getLogin() + " has already been closed at " + loan.getEndDate());
			request.setAttribute("closeLoanException",
					closeLoanException);
			throw closeLoanException;
		}
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