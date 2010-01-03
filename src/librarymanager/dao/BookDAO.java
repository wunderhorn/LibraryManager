package librarymanager.dao;

import java.util.Hashtable;
import java.util.List;

import librarymanager.core.Book;

/**
 * Interface de gestion de communication entre un {@link Book} et la base de
 * donnees
 */
public interface BookDAO {

	/**
	 * Sauvegarde un livre dans la base de donnees
	 * 
	 * @param book
	 *            Le livre a sauvegarder
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void saveBook(Book book) throws Exception;

	/**
	 * Supprime un livre de la base de donnees
	 * 
	 * @param book
	 *            Le livre a supprimer
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void removeBook(Book book) throws Exception;

	/**
	 * Verifie la presence d'un livre dans la base de donnees
	 * 
	 * @param book
	 *            Le livre a verifier
	 * @return <code>true</code> si le livre a verifier est present dans la base
	 *         de donnees, <code>false</code> sinon
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public boolean exists(Book book) throws Exception;

	/**
	 * Recupere un livre dans la base de donnees
	 * 
	 * @param parameter
	 *            Les parametres de la requete
	 */
	public List<Book> getBooks(Hashtable<String, String> parameter)
			throws Exception;

	/**
	 * Recupere des livres dans la base de donnees
	 * 
	 * @param parameter
	 *            Les parametres de la requete
	 * @return La liste des livres recherches
	 */
	public Book getBook(String isbn)
			throws Exception;
}
