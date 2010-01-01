package librarymanager.test;

import librarymanager.app.UserManager;
import librarymanager.core.Admin;
import librarymanager.core.User;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		 UserManager userManager = (UserManager)context.getBean("userManager");
		 
		 Admin admin = userManager.createAdmin("Admin_login", "secret", "Chef", "Lui", "Moncul@");
		
		 userManager.removeUser(admin);
		 
		 userManager.addUser(admin);
		 
		 User user = userManager.getUser("Admin_login");
		 
		 System.out.println(user.getClass());
		 
		 userManager.removeUser(admin);
	}

}
