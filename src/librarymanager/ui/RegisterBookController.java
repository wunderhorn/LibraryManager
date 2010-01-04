package librarymanager.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.StockManager;
import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
import librarymanager.core.Stock;
import librarymanager.core.StockAlreadyExistException;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controle les enregistrements de nouveaux livres
 */
public class RegisterBookController extends SimpleFormController {

	private BookManager bookManager;
	private StockManager stockManager;

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		String editor = request.getParameter("editor");
		int totalStock = 0;
		try {
			totalStock = new Integer(request.getParameter("stock"))
					.intValue();
		} catch (NumberFormatException exception) {
			RegisterBookException registerBookException = new RegisterBookException(
					"Stock field must be an integer");
			request
					.setAttribute("registerBookException",
							registerBookException);
			throw registerBookException;
		}

		if (isbn.isEmpty() || author.isEmpty() || editor.isEmpty()) {
			RegisterBookException registerBookException = new RegisterBookException(
					"All fields are required");
			request
					.setAttribute("registerBookException",
							registerBookException);
			throw registerBookException;
		}

		Book book = bookManager.createBook(isbn, author, editor);
		Stock stock = stockManager.createStock(book, totalStock);

		return stock;
	}

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {
		Stock stock = (Stock) command;
		Book book = stock.getBook();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("isbn", book.getIsbn());
		model.put("author", book.getAuthor());
		model.put("editor", book.getEditor());
		model.put("stock", stock.getTotalStock());

		return model;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Stock stock = (Stock) command;
		Book book = stock.getBook();

		try {
			bookManager.addBook(book);
			stockManager.addStock(stock);
		} catch (BookAlreadyExistException bookAlreadyExistException) {
			RegisterBookException registerBookException = new RegisterBookException(
					"Book " + book.getIsbn()
							+ " already exists. Please delete him before");
			request
					.setAttribute("registerBookException",
							registerBookException);
			throw registerBookException;
		} catch (StockAlreadyExistException stockAlreadyExistException) {
			RegisterBookException registerBookException = new RegisterBookException(
					"Stock for the " + book.getIsbn()
							+ " already exists. Please delete him before");
			request
					.setAttribute("registerBookException",
							registerBookException);
			throw registerBookException;
		}

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
