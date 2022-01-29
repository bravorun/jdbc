package com.bookstoreapp.model.persistance;

import java.sql.Date;

public class Book {
	private int id;
	private String isbn;
	private String title;
	private String author;
	private double price;
	private Date date;
	public Book(int id, String isbn, String title, String author, double price, Date date) {
		
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
	}
public Book(String isbn, String title, String author, double price, Date date) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
	}
	@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Book [id=");
	builder.append(id);
	builder.append(", isbn=");
	builder.append(isbn);
	builder.append(", title=");
	builder.append(title);
	builder.append(", author=");
	builder.append(author);
	builder.append(", price=");
	builder.append(price);
	builder.append(", date=");
	builder.append(date);
	builder.append("]");
	return builder.toString();
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
