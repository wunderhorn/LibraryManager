package librarymanager.core;

import java.io.Serializable;
import java.util.Date;

/**
 * Cette classe represente un pret de livre par un utilisateur
 */
@SuppressWarnings("serial")
public class Loan implements Serializable {

	/** Livre a preter */
	private Book book;

	/** Utilisateur qui emprunte le livre */
	private User user;

	/** Date de debut de pret */
	private Date startDate;

	/** Date de fin de pret */
	private Date endDate;

	/**
	 * Construit un pret par defaut
	 */
	public Loan() {
		book = null;
		user = null;
		startDate = null;
		endDate = null;
	}

	/**
	 * Construit un pret suivant les champs specifiques
	 * 
	 * @param book
	 *            Le livre associe au pret
	 * @param user
	 *            L'utilisateur qui emprunte le livre
	 * @param startDate
	 *            La date de debut de location
	 * @param endDate
	 *            La date de fin de location
	 */
	public Loan(Book book, User user, Date startDate, Date endDate) {
		this.book = book;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Retourne le livre
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Modifie le livre
	 * 
	 * @param book
	 *            Le nouveau livre a emprunter
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Retourne l'utilisateur
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Modifie l'utilisateur
	 * 
	 * @param user
	 *            Le nouvel utilisateur
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Retourne la date de debut de location
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Modifie la date de debut de location
	 * 
	 * @param startDate
	 *            La nouvelle date de debut de location
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Retourne la date de fin de location
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Modifie la date de fin de location
	 * 
	 * @param endDate
	 *            La nouvelle date de fin de location
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Stock characteristics: \n" + "\tBook\t: " + getBook() + "\n"
				+ "\tUser\t: " + getUser() + "\n" + "\tStartDate\t: "
				+ getStartDate() + "\n" + "\tendDate\t:" + getEndDate() + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		return ((Loan) obj).getBook().getIsbn() == getBook().getIsbn()
				&& ((Loan) obj).getUser().getLogin() == getUser().getLogin();
	}

	@Override
	public int hashCode() {
		return (getBook().getIsbn() + getUser().getLogin()).hashCode();
	}

}
