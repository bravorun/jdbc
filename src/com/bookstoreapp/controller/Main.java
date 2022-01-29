package com.bookstoreapp.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.bookstoreapp.model.exceptions.DataAccessException;
import com.bookstoreapp.model.persistance.Book;
import com.bookstoreapp.model.service.BookService;
import com.bookstoreapp.model.service.BookServiceImplementation;

public class Main {
	private static void printAllBooks(BookService bookService) {
		try{
			List<Book> books=bookService.getAllBooks();
			for(Book book: books) {
				System.out.println(book);
			}
		}catch(DataAccessException ex) {
			
			ex.printStackTrace();
		}
		
	}
	public static void main(String args[]) {
	BookService bookService = new BookServiceImplementation();
	System.out.println("--------Book Details:---");
	printAllBooks(bookService);
	
	Date date=new Date(12, 03, 1998);
	Book book1=new Book("6666", "Thinking in java","Bruce Eckel",1500.00,date);
	bookService.addBook(book1);
	
	Scanner in=new Scanner(System.in);
	System.out.println("enter the book id");
	int bookId=in.nextInt();
	Book book2=bookService.getBookBy(bookId);
	System.out.println(book2);
	
	Date date1=new Date(12, 03, 1998);
	Book book3=new Book(6,"6666", "Thinking in java","Bruce Eckel",2500.00,date1);
	bookService.updateBook(book3.getId(), book3);
	
	System.out.println("enter the book id that you wnat to delete");
	int bookId1=in.nextInt();
	bookService.removeBook(bookId1);
	
	in.close();
	
	}

}
