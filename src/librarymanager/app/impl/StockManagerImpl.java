package librarymanager.app.impl;

import librarymanager.app.StockManager;
import librarymanager.core.Book;
import librarymanager.core.EmptyStockException;
import librarymanager.core.Stock;
import librarymanager.core.StockAlreadyExistException;
import librarymanager.core.StockNotExistException;
import librarymanager.dao.StockDAO;

/**
 * Implementation de la gestion des stocks
 */
public class StockManagerImpl implements StockManager {

	/**
	 * Gestion de la communication entre les {@link Stock} et la base de donnees
	 */
	private StockDAO stockDAO;

	public StockManagerImpl() {
	}

	/**
	 * @return Le {@link StockDAO}
	 */
	public StockDAO getStockDAO() {
		return stockDAO;
	}

	/**
	 * Change le {@link StockDAO}
	 * 
	 * @param stockDAO
	 *            Le nouveau {@link StockDAO}
	 */
	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	@Override
	public Stock createStock(Book book, int totalStock) {
		return new Stock(book, totalStock, totalStock);
	}

	@Override
	public void removeStock(Stock stock) throws StockNotExistException {
		if (!exists(stock))
			throw new StockNotExistException("The stock " + stock
					+ " does not exists");

		try {
			stockDAO.removeStock(stock);
		} catch (Exception exception) {
			System.err.println("Stock#removeStock() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void addStock(Stock stock) throws StockAlreadyExistException {
		if (exists(stock))
			throw new StockAlreadyExistException("The stock " + stock
					+ " already exists");

		try {
			stockDAO.saveStock(stock);
		} catch (Exception exception) {
			System.err.println("Stock#addStock() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public Stock getStock(Book book) throws StockNotExistException {
		Stock stock = null;
		try {
			stock = (Stock) stockDAO.getStock(book);
		} catch (Exception exception) {
			System.err.println("Stock#getStock() exception: "
					+ exception.getMessage());
		}

		if (stock == null)
			throw new StockNotExistException("The stock for the book " + book
					+ " does not exists");
		else
			return stock;
	}

	@Override
	public boolean exists(Stock stock) {
		try {
			return stockDAO.exists(stock);
		} catch (Exception exception) {
			System.err.println("Stock#exists() exception: "
					+ exception.getMessage());
			return false;
		}
	}

	@Override
	public void decrementRemainingStock(Book book, int value)
			throws StockNotExistException, EmptyStockException {
		Stock stock = getStock(book);
		
		if (stock.getRemainingStock() - value < 0)
			throw new EmptyStockException();
		
		stock.setRemainingStock(stock.getRemainingStock() - value);
		try {
			stockDAO.updateStock(stock);
		} catch (Exception exception) {
			System.err.println("Stock#addStock() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void decrementTotalStock(Book book, int value)
			throws StockNotExistException, EmptyStockException {
		Stock stock = getStock(book);
		
		if (stock.getTotalStock() - value < 0 || stock.getRemainingStock() - value < 0)
			throw new EmptyStockException();
		
		stock.setRemainingStock(stock.getRemainingStock() - value);
		stock.setTotalStock(stock.getTotalStock() - value);
		try {
			stockDAO.updateStock(stock);
		} catch (Exception exception) {
			System.err.println("Stock#addStock() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void incrementRemainingStock(Book book, int value)
			throws StockNotExistException {
		Stock stock = getStock(book);

		stock.setRemainingStock(stock.getRemainingStock() + value);
		try {
			stockDAO.updateStock(stock);
		} catch (Exception exception) {
			System.err.println("Stock#addStock() exception: "
					+ exception.getMessage());
		}
	}

	@Override
	public void incrementTotalStock(Book book, int value)
			throws StockNotExistException {
		Stock stock = getStock(book);
		stock.setTotalStock(stock.getTotalStock() + value);
		stock.setRemainingStock(stock.getRemainingStock() + value);
		try {
			stockDAO.updateStock(stock);
		} catch (Exception exception) {
			System.err.println("Stock#addStock() exception: "
					+ exception.getMessage());
		}
	}
}
