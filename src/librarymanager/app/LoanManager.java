package librarymanager.app;

import java.util.Date;

import librarymanager.core.Book;
import librarymanager.core.Loan;
import librarymanager.core.LoanAlreadyExistException;
import librarymanager.core.LoanNotExistException;
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
	public Loan createLoan(Book book, User user, Date startDate, Date endDate) ;

	/**
	 * Enregistre un pret dans la base de donnees
	 * 
	 * @param loan
	 *            Le pret specifique a enregistrer
	 * @throws LoanAlreadyExistException
	 *             levee si le pret specifie en parametre est deja present dans
	 *             la base de donnees
	 */
	public void addLoan(Loan loan) throws LoanAlreadyExistException;

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
}
