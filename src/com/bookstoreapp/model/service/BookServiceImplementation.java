package com.bookstoreapp.model.service;

import java.util.List;

import com.bookstoreapp.model.persistance.Book;
import com.bookstoreapp.model.persistance.BookStoreDaoImplementation;

public class BookServiceImplementation implements BookService {
	private BookStoreDaoImplementation bookstore;
	
	public BookServiceImplementation() {
		this.bookstore = new BookStoreDaoImplementation();
	}

	@Override
	public List<Book> getAllBooks() {
		return bookstore.getAllBooks();
	}

	@Override
	public Book getBookBy(int bookId) {
		return bookstore.getBookBy(bookId);
	}

	@Override
	public void addBook(Book book) {
		bookstore.addBook(book);
	}

	@Override
	public void updateBook(int bookId,Book book) {
		bookstore.updateBook(bookId, book);
		
	}

	@Override
	public void removeBook(int bookId) {
		bookstore.removeBook(bookId);
		
	}

}
