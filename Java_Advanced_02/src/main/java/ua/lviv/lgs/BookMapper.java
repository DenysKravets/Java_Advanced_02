package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMapper {
	
	public static List<Book> map(ResultSet result) throws SQLException {
		
		List<Book> books = new ArrayList<>();
		
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			int price = result.getInt("price");
			
			books.add(new Book(id, name, price));
		}
		
		return books;
	}

	
}
