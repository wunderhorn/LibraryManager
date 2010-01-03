package librarymanager.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.app.StockManager;
import librarymanager.core.Book;
import librarymanager.core.Stock;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * Controleur du formulaire de recherche de livres
 * 
 */
public class SearchBookController extends SimpleFormController {

	private BookManager bookManager;
	private StockManager stockManager;

	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {

		Hashtable<String, String> parameter = new Hashtable<String, String>();

		parameter.put("isbn", request.getParameter("isbn"));
		parameter.put("author", request.getParameter("author"));
		parameter.put("editor", request.getParameter("editor"));
		List<Book> bookQuery = bookManager.getBooks(parameter);

		List<Stock> stockQuery = new ArrayList<Stock>();
		
		for (Book book : bookQuery)
			stockQuery.add(stockManager.getStock(book));
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("query", stockQuery);

		return model;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

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
