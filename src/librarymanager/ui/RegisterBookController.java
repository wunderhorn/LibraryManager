package librarymanager.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import librarymanager.app.BookManager;
import librarymanager.core.Book;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controle les enregistrements de nouveaux livres
 */
public class RegisterBookController extends SimpleFormController {
	/** Interface de gestion des livres de la librairie */
	private BookManager bookManager;

	public RegisterBookController() {
	}

	/**
	 * Retourne l'interface de gestion des livres de la librairie
	 */
	public BookManager getBookManager() {
		return bookManager;
	}

	/**
	 * Change l'interface de gestion des livres de la librairie
	 * 
	 * @param bookManager
	 *            La nouvelle interface
	 */
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		String editor = request.getParameter("editor");

		Book book = bookManager.createBook(isbn, author, editor);

		if (bookManager.exists(book)) {
			// TODO Redirection vers la page d'erreur
		}

		return book;
	}

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request,
			Object command, Errors errors) throws Exception {
		Book book = (Book) command;

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("isbn", book.getIsbn());
		model.put("author", book.getAuthor());
		model.put("editor", book.getEditor());

		return model;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Book book = (Book) command;
		bookManager.register(book);

		return this.showForm(request, response, errors);
	}

}
