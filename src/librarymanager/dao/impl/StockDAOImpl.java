package librarymanager.dao.impl;

import java.util.List;

import librarymanager.core.Book;
import librarymanager.core.Stock;
import librarymanager.dao.StockDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Implementation de la gestion de la communication entre un {@link Stock} et la
 * base de donnees
 */
public class StockDAOImpl extends HibernateDaoSupport implements StockDAO {

	public StockDAOImpl() {
	}

	@Override
	public boolean exists(Stock stock) throws Exception {
		return getHibernateTemplate().get(Stock.class,stock) != null;
	}

	@Override
	public void saveStock(Stock stock) throws Exception {
		getHibernateTemplate().save(stock);
	}

	@Override
	public Stock getStock(Book book) throws Exception {
		List<?> result = getHibernateTemplate().find("FROM Stock stock WHERE stock.book.isbn LIKE '" + book.getIsbn() + "'");
		if (result.isEmpty())
			return null;
		else
			return (Stock) result.get(0);
	}
	
	@Override
	public void removeStock(Stock stock) throws Exception {
		Stock stockToDelete = (Stock) getHibernateTemplate().get(Stock.class,stock);
		getHibernateTemplate().delete(stockToDelete);
	}
	
	@Override
	public void updateStock(Stock stock) throws Exception {
		getHibernateTemplate().update(stock);
	}
}
