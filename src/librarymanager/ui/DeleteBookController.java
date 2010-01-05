package librarymanager.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.LoanManager;
import librarymanager.app.StockManager;
import librarymanager.core.Book;
import librarymanager.core.Stock;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class DeleteBookController extends SimpleFormController {
	private BookManager bookManager;
	private StockManager stockManager;
	private LoanManager loanManager;

	protected Object formBackingObject(HttpServletRequest request)
	throws Exception {
		Book book = bookManager.getBook(request.getParameter("deleteISBN"));
		Stock stock = stockManager.getStock(book);
		
		if (loanManager.bookIsLoaned(book)) {
			DeleteBookException deleteBookException = new DeleteBookException("Delete failed, the book " + book.getIsbn() + " is loaned");
			request
			.setAttribute("deleteBookException",
					deleteBookException);
			throw deleteBookException;
		}
		
		return stock;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Stock stock = (Stock) command;

		stockManager.removeStock(stock);
		bookManager.removeBook(stock.getBook());

		return this.showForm(request, response, errors);
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public StockManager getStockManager() {
		return stockManager;
	}

	public void setStockManager(StockManager stockManager) {
		this.stockManager = stockManager;
	}
	
	public LoanManager getLoanManager() {
		return loanManager;
	}

	public void setLoanManager(LoanManager loanManager) {
		this.loanManager = loanManager;
	}
}