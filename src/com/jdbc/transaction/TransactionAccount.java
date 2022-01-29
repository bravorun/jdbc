package com.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookstoreapp.model.persistance.ConnectionFactory;

public class TransactionAccount {
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			PreparedStatement pstmt = connection.prepareStatement("update account set balance=balance-1000 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("update account set balance=balance+1000 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();
			connection.commit();
			System.out.println("Transfer is done following ACID principles");

		} catch (SQLException e) {

			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}