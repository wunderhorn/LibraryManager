package librarymanager.app;

import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
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
	 */
	public void removeBook(Book book) throws BookNotExistException;

	/**
	 * Determine si un livre est existant ou non
	 * 
	 * @param book
	 *            Livre recherche
	 * @return <code>true</code> si le livre est present dans la base de
	 *         donnees, <code>false</code> sinon
	 */
	public boolean exists(Book book);
}
