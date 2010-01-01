package librarymanager.test;

import librarymanager.app.BookManager;
import librarymanager.core.Book;
import librarymanager.core.BookAlreadyExistException;
import librarymanager.core.BookNotExistException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBook.xml");
		
		 BookManager bookManager = (BookManager)context.getBean("bookManager");
		 
		 Book book = bookManager.createBook("123-456-789", "Matthieu", "Bras casse");
		
		 boolean catched = false;
		 if (bookManager.exists(book)) {
			 try  {
				 bookManager.delete(book); 
			 } catch (BookNotExistException bookNotExistException) {
				 catched = true;
			}
		 }
		 
		 System.out.println("Le book existe ? " + bookManager.exists(book));
		 
		 catched = false;
		 try {
			 bookManager.register(book);
		 } catch(BookAlreadyExistException bookAlreadyExistException) {
			 catched = true;
		 }
		 
		 System.out.println("Exception catchee ? " + catched);
		 
		 System.out.println("Le book existe ? " + bookManager.exists(book));
		 
		 catched = false;
		 try {
			 bookManager.register(book);
		 } catch(BookAlreadyExistException bookAlreadyExistException) {
			 catched = true;
		 }
		 
		 System.out.println("Exception catchee ? " + catched);
	}

}
