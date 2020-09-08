package ua.lviv.lgs;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/book_store";
		String user = "root";
		String password = "123321";
		
		ConnectionUtils connectionUtils = new ConnectionUtils(url, user, password);
		BookDao bookDao = new BookDaolmlp(connectionUtils.makeConnection());
		
		bookDao.getAllBooks().stream().forEach(System.out::println);
		System.out.println();
		
		bookDao.addBook(new Book("Selamat pagi", 141));
		
		bookDao.getAllBooks().stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println(bookDao.getBookById(1));
		
		System.out.println();
		
		bookDao.updateBook(new Book(1, "selamat malam", 134));
		
		bookDao.deleteBookById(1);
		
		bookDao.getAllBooks().stream().forEach(System.out::println);
		System.out.println();
		
		bookDao.close();
		
	}

}
