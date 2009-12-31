package librarymanager.dao;

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
	public void save(Book book) throws Exception;

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
}
