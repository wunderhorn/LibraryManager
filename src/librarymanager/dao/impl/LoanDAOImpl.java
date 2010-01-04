package librarymanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import librarymanager.core.Book;
import librarymanager.core.Loan;
import librarymanager.core.User;
import librarymanager.dao.LoanDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Implementation de la gestion de la communication entre un {@link Loan} et la
 * base de donnees
 */
public class LoanDAOImpl extends HibernateDaoSupport implements LoanDAO {

	public LoanDAOImpl() {
	}

	@Override
	public boolean exists(Loan loan) throws Exception {
		return getHibernateTemplate().get(Loan.class, loan) != null;
	}

	@Override
	public void saveLoan(Loan loan) throws Exception {
		getHibernateTemplate().save(loan);
	}

	@Override
	public Loan getLoan(Book book, User user) throws Exception {
		List<?> result = getHibernateTemplate().find(
				"FROM Loan loan WHERE loan.book.isbn LIKE '" + book.getIsbn()
						+ "' AND loan.user.login LIKE '" + user.getLogin()
						+ "'");
		if (result.isEmpty())
			return null;
		else
			return (Loan) result.get(0);
	}

	@Override
	public void removeLoan(Loan loan) throws Exception {
		Loan loanToDelete = (Loan) getHibernateTemplate().get(Loan.class, loan);
		getHibernateTemplate().delete(loanToDelete);
	}

	@Override
	public void updateLoan(Loan loan) throws Exception {
		getHibernateTemplate().update(loan);
	}

	@Override
	public List<Loan> getLoansbyUser(User user) throws Exception {

		List<Loan> result = new ArrayList<Loan>();

		for (Object loan : getHibernateTemplate().find(
				"FROM Loan loan WHERE loan.user.login LIKE '" + user.getLogin() + "'"))
			result.add((Loan) loan);

		return result;
	}

	@Override
	public List<Loan> getAllLoans() throws Exception {

		List<Loan> result = new ArrayList<Loan>();

		for (Object loan : getHibernateTemplate().find(
				"FROM Loan loan"))
			result.add((Loan) loan);

		return result;
	}
}
