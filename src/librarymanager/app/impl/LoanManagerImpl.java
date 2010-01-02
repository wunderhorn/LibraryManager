package librarymanager.app.impl;

import java.util.Date;

import librarymanager.app.LoanManager;
import librarymanager.core.Book;
import librarymanager.core.Loan;
import librarymanager.core.LoanAlreadyExistException;
import librarymanager.core.LoanNotExistException;
import librarymanager.core.User;
import librarymanager.dao.LoanDAO;

/**
 * Implementation de la gestion des prets
 */
public class LoanManagerImpl implements LoanManager {

	/** Gestion de la communication entre les {@link Loan} et la base de donnees */
	private LoanDAO loanDAO;

	public LoanManagerImpl() {
	}

	/**
	 * @return Le {@link loanDAO}
	 */
	public LoanDAO getLoanDAO() {
		return loanDAO;
	}

	/**
	 * Change le {@link LoanDAO}
	 * 
	 * @param loanDAO
	 *            Le nouveau {@link LoanDAO}
	 */
	public void setLoanDAO(LoanDAO loanDAO) {
		this.loanDAO = loanDAO;
	}

	@Override
	public Loan createLoan(Book book, User user, Date startDate, Date endDate) {
		return new Loan(book, user, startDate, endDate);
	}

	@Override
	public void removeLoan(Loan loan) throws LoanNotExistException {
		if (!exists(loan))
			throw new LoanNotExistException("The loan " + loan
					+ " does not exists");

		try {
			loanDAO.removeLoan(loan);
		} catch (Exception exception) {
			System.err.println("Loan#removeLoan() exeception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void addLoan(Loan loan) throws LoanAlreadyExistException {
		if (exists(loan))
			throw new LoanAlreadyExistException("The loan " + loan
					+ " already exists");

		try {
			loanDAO.saveLoan(loan);
		} catch (Exception exception) {
			System.err.println("Loan#addLoan() exeception: "
					+ exception.getMessage());
		}
	}

	@Override
	public Loan getLoan(Book book, User user) throws LoanNotExistException {
		Loan loan = null;
		try {
			loan = (Loan) loanDAO.getLoan(book, user);
		} catch (Exception exception) {
			System.err.println("Loan#getLoan() exception: "
					+ exception.getMessage());
		}

		if (loan == null)
			throw new LoanNotExistException("The loan for the book " + book
					+ "and the customer " + user + " does not exists");
		else
			return loan;
	}

	@Override
	public boolean exists(Loan loan) {
		try {
			return loanDAO.exists(loan);
		} catch (Exception exception) {
			System.err.println("Loan#exists() exeception: "
					+ exception.getMessage());
			return false;
		}
	}

}
