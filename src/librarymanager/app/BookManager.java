package librarymanager.app;

import java.util.Hashtable;
import java.util.List;

import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
import librarymanager.core.BookLoanException;
import librarymanager.core.BookNotExistException;

/**
 * Interface de gestion des livres
 */
public interface BookManager {

	/**
	 * Cree un nouveau livre et le retourne
	 * 
	 * @param isbn
	 *            Code ISBN du livre
	 * @param author
	 *            Auteur du livre
	 * @param editor
	 *            Editeur du livre
	 * @return Le nouveau livre cree
	 */
	public Book createBook(String isbn, String author, String editor);

	/**
	 * Enregistre un livre dans la base de donnees
	 * 
	 * @param book
	 *            Le livre specifique a enregistrer
	 * @throws BookAlreadyExistException
	 *             levee si le livre specifie en parametre est deja present dans
	 *             la base de donnees
	 * @return Le nouveau livre cree       
	 */
	public void addBook(Book book) throws BookAlreadyExistException;

	/**
	 * Supprime un livre dans la base de donnees
	 * 
	 * @param book
	 *            Le livre specifique a supprimer
	 * @throws BookNotExistException
	 *             levee si le livre specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 * @throws BookLoanException
	 * 			   leve si le livre specifie en parametre est en cours de pret
	 */
	public void removeBook(Book book) throws BookNotExistException, BookLoanException;

	/**
	 * Determine si un livre est existant ou non
	 * 
	 * @param book
	 *            Livre recherche
	 * @return <code>true</code> si le livre est present dans la base de
	 *         donnees, <code>false</code> sinon
	 */
	public boolean exists(Book book);
	
	/**
	 * Recupere un livre dans la base de donnees
	 * 
	 * @param isbn
	 *            L'isbn du livre specifique a recuperer
	 * @throws BookNotExistException
	 *             levee si l'isbn specifie en parametre ne correspond
	 *             a aucun livre enregistre dans la base de donnees
	 * @return Le livre recherche
	 */
	public Book getBook(String isbn) throws BookNotExistException;
	
	/**
	 * Recupere un book dans la base de donnees
	 * 
	 * @param parameter
	 *            Les parametres de la requete
	 * @return La liste des livres recherches        
	 */
	public List<Book> getBooks(Hashtable<String, String> parameter);
}
