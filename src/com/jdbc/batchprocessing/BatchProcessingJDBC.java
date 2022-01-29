package com.jdbc.batchprocessing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookstoreapp.model.persistance.ConnectionFactory;

public class BatchProcessingJDBC {
	
	public static void main(String[] args) {
		
		Connection connection=ConnectionFactory.getConnection();
		
		long start= System.currentTimeMillis();
		
		
			try {
				for(int i=1;i<=1000;i++)
				{
					String s="Ranjan"+i;
				PreparedStatement pstmt=connection.prepareStatement("insert into batchprocessing(name) values(?)");
				pstmt.setString(1, s);
				
				pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		
		
		
		long end= System.currentTimeMillis();
		
		System.out.println("Time taken without using batch processing: "+ (end-start) +"ms");
		
		
		
		long start1= System.currentTimeMillis();
		
		try {
			
			connection.setAutoCommit(false);
			for(int i=1;i<=1000;i++)
			{
				String s="Ranjan"+i;
				PreparedStatement pstmt=connection.prepareStatement("insert into batchprocessing(name) values(?)");
				pstmt.setString(1, s);
				
				//pstmt.executeUpdate();
				
				pstmt.addBatch();
				
				if(i%200==0)
				{
					pstmt.executeBatch();
				}
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		long end1= System.currentTimeMillis();
		
		System.out.println("Time taken using batch processing: "+ (end1-start1) +"ms");
	}
}