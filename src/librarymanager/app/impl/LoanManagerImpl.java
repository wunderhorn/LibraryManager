package librarymanager.app.impl;

import java.util.Date;

import librarymanager.app.LoanManager;
import librarymanager.app.StockManager;
import librarymanager.core.Book;
import librarymanager.core.EmptyStockException;
import librarymanager.core.Loan;
import librarymanager.core.LoanAlreadyExistException;
import librarymanager.core.LoanNotExistException;
import librarymanager.core.StockNotExistException;
import librarymanager.core.User;
import librarymanager.dao.LoanDAO;

/**
 * Implementation de la gestion des prets
 */
public class LoanManagerImpl implements LoanManager {

	/** Gestion de la communication entre les {@link Loan} et la base de donnees */
	private LoanDAO loanDAO;

	private StockManager stockManager;

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

	/**
	 * @return Le {@link stockManager}
	 */
	public StockManager getStockManager() {
		return stockManager;
	}

	/**
	 * Change le {@link stockManager}
	 * 
	 * @param stockManager
	 *            Le nouveau {@link stockManager}
	 */
	public void setStockManager(StockManager stockManager) {
		this.stockManager = stockManager;
	}

	@Override
	public Loan createLoan(Book book, User user, Date startDate) {
		return new Loan(book, user, startDate, null);
	}

	@Override
	public void removeLoan(Loan loan) throws LoanNotExistException {
		if (!exists(loan))
			throw new LoanNotExistException("The loan " + loan
					+ " does not exists");

		try {
			loanDAO.removeLoan(loan);
		} catch (Exception exception) {
			System.err.println("Loan#removeLoan() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void addLoan(Loan loan) throws LoanAlreadyExistException,
			EmptyStockException, StockNotExistException {
		if (exists(loan))
			throw new LoanAlreadyExistException("The loan " + loan
					+ " already exists");

		try {
			loanDAO.saveLoan(loan);
		} catch (Exception exception) {
			System.err.println("Loan#addLoan() exception: "
					+ exception.getMessage());
		}
		stockManager.decrementRemainingStock(loan.getBook(), 1);

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
			System.err.println("Loan#exists() exception: "
					+ exception.getMessage());
			return false;
		}
	}

	@Override
	public void closeLoan(Loan loan, Date endDate) throws StockNotExistException {
		try {
			loan.setEndDate(endDate);
			loanDAO.updateLoan(loan);
		} catch (Exception exception) {
			System.err.println("Loan#addLoan() exception: "
					+ exception.getMessage());
		}
		stockManager.incrementRemainingStock(loan.getBook(), 1);
	}

}
