package librarymanager.test;

import java.util.Calendar;

import librarymanager.app.BookManager;
import librarymanager.app.LoanManager;
import librarymanager.app.StockManager;
import librarymanager.app.UserManager;
import librarymanager.core.Admin;
import librarymanager.core.Book;
import librarymanager.core.Customer;
import librarymanager.core.Loan;
import librarymanager.core.Stock;
import librarymanager.core.User;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		UserManager userManager = (UserManager) context.getBean("userManager");

		Admin admin = userManager.createAdmin("Admin_login", "secret", "Chef",
				"Lui", "Moncul@");

		userManager.addUser(admin);

		User user = userManager.getUser("Admin_login");

		System.out.println(user.getClass());

		BookManager bookManager = (BookManager) context.getBean("bookManager");

		Book book = bookManager.createBook("123-456-789", "Matthieu",
				"Bras casse");
		
		bookManager.addBook(book);
		
		StockManager stockManager = (StockManager) context.getBean("stockManager");
		Stock stock = stockManager.createStock(book, 3);
			
		stockManager.addStock(stock);
		System.out.println(stockManager.exists(stock));
		
		Stock stock_data = stockManager.getStock(book);
		System.out.println("#####" + stock_data.getBook() + "#####");
		
		LoanManager loanManager = (LoanManager) context.getBean("loanManager");
		Loan loan = loanManager.createLoan(book, admin, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		
		loanManager.addLoan(loan);
		
		Loan loan_data = loanManager.getLoan(book,admin);
		System.out.println("#####" + loan_data.getBook() + "#####");
		System.out.println("#####" + loan_data.getUser() + "#####");
		System.out.println("#####" + loan_data.getUser().getClass() + "#####");
		
//		loanManager.removeLoan(loan);
//		stockManager.removeStock(stock);
//		bookManager.removeBook(book);
//		userManager.removeUser(admin);
	}

}
