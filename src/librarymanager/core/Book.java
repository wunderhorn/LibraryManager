package librarymanager.core;

/**
 * Cette classe represente un livre, objet metier elementaire
 */
public class Book {
	/** Valeur par defaut d'un champ */
	public static final String DEFAULT_FIELD = "NONE";

	/** Code ISBN representant le numero international normalise du livre */
	private String isbn;

	/** Auteur du livre */
	private String author;

	/** Editeur du livre */
	private String editor;

	/**
	 * Construit un livre par defaut
	 */
	public Book() {
		isbn = DEFAULT_FIELD;
		author = DEFAULT_FIELD;
		editor = DEFAULT_FIELD;
	}

	/**
	 * Construit un livre suivant les champs specifiques
	 * 
	 * @param isbn
	 *            Code ISBN du livre
	 * @param author
	 *            Auteur du livre
	 * @param editor
	 *            Editeur du livre
	 */
	public Book(String isbn, String author, String editor) {
		this.isbn = isbn;
		this.author = author;
		this.editor = editor;
	}

	/**
	 * Retourne le code ISBN du livre
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Modifie le code ISBN du livre
	 * 
	 * @param iSBN
	 *            Le nouveau code ISBN pour le livre
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Retourne l'auteur du livre
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Modifie l'auteur du livre
	 * 
	 * @param author
	 *            Le nouvel auteur du livre
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Retourne l'editeur du livre
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * Modifie l'editeur du livre
	 * 
	 * @param editor
	 *            Le nouvel editeur du livre
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Override
	public String toString() {
		return "Book characteristics: \n" + "\tISBN\t: " + getIsbn() + "\n"
				+ "\tAuthor\t: " + getAuthor() + "\n" + "\tEditor\t:"
				+ getEditor() + "\n";
	}

}
