package librarymanager.dao;

import librarymanager.core.Book;
import librarymanager.core.Loan;
import librarymanager.core.LoanNotExistException;
import librarymanager.core.User;

/**
 * Interface de gestion de communication entre un {@link Loan} et la base de
 * donnees
 */
public interface LoanDAO {

	/**
	 * Sauvegarde un pret dans la base de donnees
	 * 
	 * @param loan
	 *            Le pret a sauvegarder
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void saveLoan(Loan loan) throws Exception;

	/**
	 * Supprime un pret de la base de donnees
	 * 
	 * @param loan
	 *            Le loan a supprimer
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public void removeLoan(Loan loan) throws Exception;

	/**
	 * Recupere un pret dans la base de donnees
	 * 
	 * @param book
	 *            Le livre du pret specifique a recuperer
	 * @param user
	 *            L'utilisateur du pret specifique a recuperer
	 * @throws LoanNotExistException
	 *             levee si le livre et l'utilisateur specifiés en parametres ne correspondent
	 *             a aucun pret enregistre dans la base de donnees
	 */
	public Loan getLoan(Book book, User user) throws Exception;
	
	/**
	 * Verifie la presence d'un pret dans la base de donnees
	 * 
	 * @param loan
	 *            Le pret a verifier
	 * @return <code>true</code> si le pret a verifier est present dans la base
	 *         de donnees, <code>false</code> sinon
	 * @throws Exception
	 *             Levee si une erreur de communication avec la base de donnees
	 *             survient
	 */
	public boolean exists(Loan loan) throws Exception;
}
