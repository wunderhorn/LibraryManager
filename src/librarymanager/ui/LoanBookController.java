package librarymanager.ui;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.LoanManager;
import librarymanager.core.Book;
import librarymanager.core.EmptyStockException;
import librarymanager.core.Loan;
import librarymanager.core.LoanAlreadyExistException;
import librarymanager.core.User;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoanBookController extends SimpleFormController {
	private BookManager bookManager;
	private LoanManager loanManager;

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Book book = bookManager.getBook(request.getParameter("loanISBN"));
		User user = (User) request.getSession().getAttribute("user");

		Loan loan = loanManager.createLoan(book, user, Calendar.getInstance()
				.getTime());

		return loan;
	}

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {
		Loan loan = (Loan) command;

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", loan.getUser().getLogin());
		model.put("book", loan.getBook().getIsbn());
		model.put("startDate", loan.getStartDate());

		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Loan loan = (Loan) command;
		Book book = loan.getBook();

		try {
			loanManager.addLoan(loan);
		} catch (EmptyStockException exception) {
			RegisterLoanException registerLoanException = new RegisterLoanException(
					"All Books " + book.getIsbn() + " are loaned");
			request
					.setAttribute("registerLoanException",
							registerLoanException);
			throw registerLoanException;
		} catch (LoanAlreadyExistException exception) {
			RegisterLoanException registerLoanException = new RegisterLoanException(
					"You have alrealdy loaned the book " + book.getIsbn() +". Loan a different book");
			request
					.setAttribute("registerLoanException",
							registerLoanException);
			throw registerLoanException;
		}

		return this.showForm(request, response, errors);
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public LoanManager getLoanManager() {
		return loanManager;
	}

	public void setLoanManager(LoanManager loanManager) {
		this.loanManager = loanManager;
	}
}