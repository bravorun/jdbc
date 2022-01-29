package com.bookstoreapp.model.exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public MyException(SQLException e) {
		System.out.println("SQL Exception");
		e.printStackTrace();
		}
	public MyException(IOException e) {
		System.out.println("IO Exception");
		e.printStackTrace();
		
	}
	
}
