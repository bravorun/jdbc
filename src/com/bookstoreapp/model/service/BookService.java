package com.bookstoreapp.model.service;

import java.util.List;

import com.bookstoreapp.model.persistance.Book;

public interface BookService {
	public List<Book> getAllBooks() ;
	public Book getBookBy(int bookId);
	public void addBook(Book book);
	public void updateBook(int bookId,Book book);
	public void removeBook(int bookId);
}
