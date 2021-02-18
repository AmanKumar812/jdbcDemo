package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		Connection con;
	    Statement stmt;
	    ResultSet rs;
	    PreparedStatement pstmt;
	    String sqlUpdate;
	    
	    
	    try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 System.out.println("connecting to database");
	         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","123QWEasd");
	         
	         sqlUpdate="UPDATE candidates " + "SET last_name= ? "+" WHERE id= ? ";
	         pstmt=con.prepareStatement(sqlUpdate);
	         
	         // prepare data for update
	         Scanner s=new Scanner(System.in);
	         System.out.println("Enter candidate id:");
	         int cid=s.nextInt();
	         System.out.println("Enter candidate new last name:");
	         String lastname=s.next();
	         
	         pstmt.setString(1,lastname);
	         pstmt.setInt(2,cid);
	         
	         int rowAffected=pstmt.executeUpdate();
	         System.out.println(String.format("Row affected %d", rowAffected));
	         
	         //reuse the prepared statement
	         lastname="Grohe";
	         cid=101;
	         pstmt.setString(1,lastname);
	         pstmt.setInt(2,cid);
	         
	         rowAffected=pstmt.executeUpdate();
	         System.out.println(String.format("Row affected %d", rowAffected));
	         con.close();
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	         

	}

}
