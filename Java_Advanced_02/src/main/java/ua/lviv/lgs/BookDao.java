package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

	List<Book> getAllBooks();
	void addBook(Book book) throws SQLException;
	void deleteBookById(int id) throws SQLException;
	void close() throws SQLException;
	
}
