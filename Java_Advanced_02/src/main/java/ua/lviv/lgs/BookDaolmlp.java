package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDaolmlp implements BookDao {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private String GET_ALL = "select * from book";
	private String ADD_BOOK = "insert into book(name, price)"
			+ " values (?, ?)";
	private String DELETE_BOOK_BY_ID = "delete from book where id = ?";
	
	BookDaolmlp(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Book> getAllBooks() {
		try {
			preparedStatement = connection.prepareStatement(GET_ALL);
			return BookMapper.map(preparedStatement.executeQuery());
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return null;
	}
	@Override
	public void addBook(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(ADD_BOOK);
		preparedStatement.setString(1, book.getName());
		preparedStatement.setInt(2, book.getPrice());
		preparedStatement.executeUpdate();
	}
		
	@Override
	public void deleteBookById(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BOOK_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public void close() throws SQLException {
		connection.close();
	}
	
}
