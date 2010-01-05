package librarymanager.app;

import java.util.Date;
import java.util.List;

import librarymanager.core.Book;
import librarymanager.core.EmptyStockException;
import librarymanager.core.Loan;
import librarymanager.core.LoanAlreadyClosedException;
import librarymanager.core.LoanAlreadyExistException;
import librarymanager.core.LoanNotExistException;
import librarymanager.core.StockNotExistException;
import librarymanager.core.User;

/**
 * Interface de gestion des prets
 */
public interface LoanManager {

	/**
	 * Cree un nouveau pret et le retourne
	 * 
	 * @param book
	 *            Le livre associe au pret
	 * @param user
	 *            L'utilisateur qui emprunte le livre
	 * @param startDate
	 *            La date de debut de location
	 * @param endDate
	 *            La date de fin de location
	 * @return Le nouveau pret cree
	 */
	public Loan createLoan(Book book, User user, Date startDate) ;

	/**
	 * Enregistre un pret dans la base de donnees
	 * 
	 * @param loan
	 *            Le pret specifique a enregistrer
	 * @throws LoanAlreadyExistException
	 *             levee si le pret specifie en parametre est deja present dans
	 *             la base de donnees
	 * @throws EmptyStockException
	 * 			   levee si le stock descend en dessous de zero
	 * @throws StockNotExistException
	 * 			   levee si le stock specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */
	public void addLoan(Loan loan) throws LoanAlreadyExistException, EmptyStockException, StockNotExistException;

	/**
	 * Supprime un pret dans la base de donnees
	 * 
	 * @param loan
	 *            Le pret specifique a supprimer
	 * @throws LoanNotExistException
	 *             levee si le pret specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */
	public void removeLoan(Loan loan) throws LoanNotExistException;

	/**
	 * Recupere un pret dans la base de donnees
	 * 
	 * @param book
	 *            Le livre du pret specifique a recuperer
	 * @param book
	 *            L'utilisateur du pret specifique a recuperer
	 * @throws LoanNotExistException
	 *             levee si le pret specifie en parametre ne correspond
	 *             a aucun stock enregistre dans la base de donnees
	 */
	public Loan getLoan(Book book, User user) throws LoanNotExistException;
	
	/**
	 * Determine si un pret est existant ou non
	 * 
	 * @param loan
	 *            Pret recherche
	 * @return <code>true</code> si le pret est present dans la base de
	 *         donnees, <code>false</code> sinon
	 */
	public boolean exists(Loan loan);
	
	/**
	 * Cloture un pret
	 * 
	 * @param loan
	 *            Pret a cloturer
	 * @param endDate
	 *            Date de cloture
	 * @throws StockNotExistException
	 * 			   levee si le stock specifie en parametre n'a pas ete
	 *             enregistre dans la base de donnees
	 */
	public void closeLoan(Loan loan, Date endDate) throws StockNotExistException, LoanAlreadyClosedException;
	
	/**
	 * Recupere les prets de tous les utilisateurs
	 * 
	 * @return La liste des tous les prets
	 */
	public List<Loan> getAllLoans();
	
	/**
	 * Recupere des prets en fonction d'utilisateur
	 * 
	 * @param user
	 *            L'utilisateur ayant realisé les prets
	 * @return La liste des prets recherches
	 */
	public List<Loan> getLoansbyUser(User user);
	
	/**
	 * Recupere des prets en fonction d'un livre
	 * 
	 * @param book
	 *            Le livre concernant les prets
	 * @return La liste des prets recherches
	 */
	public List<Loan> getLoansbyBook(Book book);
	
	/**
	 * Determine si un livre est en cours de pret
	 * 
	 * @param book
	 *            Livre recherhce
	 * @return <code>true</code> si le livre est en cours de pret, <code>false</code> sinon
	 */
	public boolean bookIsLoaned(Book book);
	
	/**
	 * Determine si un utilisateur est en cours de pret
	 * 
	 * @param user
	 *            Utilisateur recherhce
	 * @return <code>true</code> si l'utilisateur est en cours de pret, <code>false</code> sinon
	 */
	public boolean userIsLoaned(User user);
}
