package librarymanager.core;

import java.io.Serializable;


/**
 * Cette classe represente un stock de livre
 */
@SuppressWarnings("serial")
public class Stock implements Serializable {
	/** Valeur par defaut d'un champ */
	public static final int DEFAULT_FIELD = 0;
	
	/** Livre a associer au stock */
	private Book book;
	
	/** Stock total que possede la bibliotheque */
	private int totalStock;
	
	/** Stock restant suite aux emprunts */
	private int remainingStock;

	/**
	 * Construit un livre par defaut
	 */
	public Stock() {
		book = null;
		totalStock = DEFAULT_FIELD;
		remainingStock = DEFAULT_FIELD;
	}

	/**
	 * Construit un stock suivant les champs specifiques
	 * 
	 * @param book
	 *            Le livre associe au stock
	 * @param totalStock
	 *            Le stock total que possede la bibliotheque
	 */
	public Stock(Book book, int totalStock, int remainingStock) {
		this.book = book;
		this.totalStock = totalStock;
		this.remainingStock = remainingStock;
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
	 *            Le nouveau livre associe au stock
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Retourne le stock total
	 */
	public int getTotalStock() {
		return totalStock;
	}

	/**
	 * Modifie le stock total
	 * 
	 * @param totalStock
	 *            Le nouvel stock total
	 */
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	/**
	 * Retourne le stock restant
	 */
	public int getRemainingStock() {
		return remainingStock;
	}

	/**
	 * Modifie le stock restant
	 * 
	 * @param remainingBook
	 *            Le nouvel editeur du livre
	 */
	public void setRemainingStock(int remainingStock) {
		this.remainingStock = remainingStock;
	}

	@Override
	public String toString() {
		return "Stock characteristics: \n" + "\tBook\t: " + getBook() + "\n"
				+ "\tTotal stock\t: " + getTotalStock() + "\n" + "\tRemaining stock\t:"
				+ getRemainingStock() + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Stock)obj).getBook().getIsbn() == getBook().getIsbn();
	}
	
	@Override
	public int hashCode() {
		return getBook().getIsbn().hashCode();
	}

}
