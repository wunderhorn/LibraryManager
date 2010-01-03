package librarymanager.dao;

import librarymanager.core.Book;
import librarymanager.core.Stock;
import librarymanager.core.StockNotExistException;

/**
 * Interface de gestion de communication entre un {@link Stock} et la base de
 * donnees
 */
public interface StockDAO {

	/**
	 * Sauvegarde un stock dans la base de donnees
	 * 
	 * @param stock
	 *            Le stock a sauvegarder
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void saveStock(Stock stock) throws Exception;

	/**
	 * Supprime un stock de la base de donnees
	 * 
	 * @param stock
	 *            Le stock a supprimer
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void removeStock(Stock stock) throws Exception;

	/**
	 * Recupere un stock dans la base de donnees
	 * 
	 * @param book
	 *            Le livre du stock specifique a recuperer
	 * @throws StockNotExistException
	 *             levee si le livre specifie en parametre ne correspond
	 *             a aucun stock enregistre dans la base de donnees
	 */
	public Stock getStock(Book book) throws Exception;
	
	/**
	 * Verifie la presence d'un stock dans la base de donnees
	 * 
	 * @param stock
	 *            Le stock a verifier
	 * @return <code>true</code> si le stock a verifier est present dans la base
	 *         de donnees, <code>false</code> sinon
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public boolean exists(Stock stock) throws Exception;
	
	/**
	 * Met a jour un stock dans la base de donnees
	 * 
	 * @param stock
	 *            Le stock a mettre a jour
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void updateStock(Stock stock) throws Exception;
}
