package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		Connection con;
	    Statement stmt;
	    ResultSet rs;
	    int cnt=0;
	    try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 System.out.println("connecting to database");
	         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","123QWEasd");
	         
	         String sql="Delete from candidates WHERE rtrim(last_name) like \'Y%g\';";
	         System.out.println(" ");
	         stmt=con.createStatement();
	         cnt=stmt.executeUpdate(sql);
	         
	         if(cnt>0)
	         {
	        	 System.out.println("Record for Young is deleted");
	         }
	         else
	         {
	        	 System.out.println("Record not found");
	         }
	         con.close();
	    }
	    catch(Exception ce)
	    {
	    	System.out.println(ce);
	    }
	
	}

}
