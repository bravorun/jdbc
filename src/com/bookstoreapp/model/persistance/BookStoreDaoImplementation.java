package com.bookstoreapp.model.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;

public class BookStoreDaoImplementation implements BookDao {
	private Connection connection;

	public BookStoreDaoImplementation() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		PreparedStatement stmt;
		Book tempBook = null;
		try {
			stmt = connection.prepareStatement("select * from books");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tempBook = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(6),
						rs.getDate(5));
				books.add(tempBook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public Book getBookBy(int bookId) {
		Book book = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement("select * from books where id=?");
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(6),
						rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void addBook(Book book) {
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement("insert into books (isbn,title,author,pubdate,price) values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDate(4, book.getDate());
			pstmt.setDouble(5, book.getPrice());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				System.out.println("Book Inserted Sucessfully Book Id =" + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(int bookId, Book book) {
		try {
			PreparedStatement pstmt = connection.prepareStatement("update books set price =? where id=?");
			pstmt.setDouble(1, book.getPrice());
			pstmt.setInt(2, bookId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeBook(int bookId) {

		try {
			PreparedStatement pstmt = connection.prepareStatement("delete from books where id=?");
			pstmt.setInt(1, bookId);
			pstmt.executeUpdate();
			System.out.println("Book Deleted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
