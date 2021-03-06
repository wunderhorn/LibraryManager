package librarymanager.app;

import librarymanager.core.Book;
import librarymanager.core.EmptyStockException;
import librarymanager.core.Stock;
import librarymanager.core.StockAlreadyExistException;
import librarymanager.core.StockNotExistException;

/**
 * Interface de gestion des stock
 */
public interface StockManager {

	/**
	 * Cree un nouveau stock et le retourne
	 * 
	 * @param book
	 *            Le livre associe au stock
	 * @param totalStock
	 *            Le stock total que possede la bibliotheque
	 * @return Le nouveau stock cree
	 */
	public Stock createStock(Book book, int totalStock);

	/**
	 * Enregistre un stock dans la base de donnees
	 * 
	 * @param stock
	 *            Le stock specifique a enregistrer
	 * @throws StockAlreadyExistException
	 *             levee si le stock specifie en parametre est deja present dans
	 *             la base de donnees
	 */
	public void addStock(Stock stock) throws StockAlreadyExistException;

	/**
	 * Supprime un stock dans la base de donnees
	 * 
	 * @param stock
	 *            Le stock specifique a supprimer
	 * @throws StockNotExistException
	 *             levee si le stock specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */
	public void removeStock(Stock stock) throws StockNotExistException;

	/**
	 * Recupere un stock dans la base de donnees
	 * 
	 * @param book
	 *            Le livre du stock specifique a recuperer
	 * @throws StockNotExistException
	 *             levee si le livre specifie en parametre ne correspond
	 *             a aucun stock enregistre dans la base de donnees
	 */
	public Stock getStock(Book book) throws StockNotExistException;
	
	/**
	 * Determine si un stock est existant ou non
	 * 
	 * @param stock
	 *            Stock recherche
	 * @return <code>true</code> si le stock est present dans la base de
	 *         donnees, <code>false</code> sinon
	 */
	public boolean exists(Stock stock);
	
	/**
	 * Incremente le stock total d'un livre
	 * 
	 * @param book
	 *            Livre dont le stock total doit etre incremente
	 * @param value
	 * 			  Valeur de l'incrementation       
	 */            
	public void incrementTotalStock(Book book, int value) throws StockNotExistException;
	
	/**
	 * Incremente le stock restant d'un livre
	 * 
	 * @param book
	 *            Livre dont le stock restantd oit etre incremente
	 * @param value
	 * 			  Valeur de l'incrementation       
	 * @throws StockNotExistException
	 * 			   levee si le stock specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */            
	public void incrementRemainingStock(Book book, int value) throws StockNotExistException;
	
	/**
	 * Decremente le stock total d'un livre
	 * 
	 * @param book
	 *            Livre dont le stock total doit etre decremente
	 * @param value
	 * 			  Valeur de la decrementation       
	 * @throws EmptyStockException
	 * 			   levee si le stock descend en dessous de zero
	 * @throws StockNotExistException
	 * 			   levee si le stock specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */            
	public void decrementTotalStock(Book book, int value) throws StockNotExistException, EmptyStockException;
	
	/**
	 * Decremente le stock restant d'un livre
	 * 
	 * @param book
	 *            Livre dont le stock restant doit etre decremente
	 * @param value
	 * 			  Valeur de la decrementation       
	 * @throws EmptyStockException
	 * 			   levee si le stock descend en dessous de zero
	 * @throws StockNotExistException
	 * 			   levee si le stock specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */            
	public void decrementRemainingStock(Book book, int value) throws StockNotExistException, EmptyStockException;
}
