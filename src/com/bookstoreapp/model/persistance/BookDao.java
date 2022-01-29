package com.bookstoreapp.model.persistance;

import java.util.List;

public interface BookDao {
	public List<Book> getAllBooks();
	public Book getBookBy(int bookId);
	public void addBook(Book book);
	public void updateBook(int bookId,Book book);
	public void removeBook(int bookId);
}
