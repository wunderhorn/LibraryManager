package librarymanager.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.StockManager;
import librarymanager.core.Book;
import librarymanager.core.Stock;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class DeleteBookController extends SimpleFormController
{
	private BookManager bookManager;
	private StockManager stockManager;

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception
	{	
		Book book = bookManager.getBook(request.getParameter("deleteISBN"));
		Stock stock = stockManager.getStock(book);
		
		stockManager.removeStock(stock);
		bookManager.removeBook(book);
		
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
}