package com.valuemomentum.training.jdbcdemo;
import java.sql.*;

public class BatchDemo {

	public static void main(String[] args) throws Exception
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
    	 System.out.println("connecting to database");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","123QWEasd");
         Statement stmt=con.createStatement();
         
         //Create batch
         stmt.addBatch("Insert into candidate_skills values(100,5)");
         stmt.addBatch("update skills set name='Ajax' where id=3");
         stmt.addBatch("delete from candidates where id=80");
         
         //disable auto commit mode
         con.setAutoCommit(false);
         try
         {
        	 stmt.executeBatch();
        	 con.commit();
        	 System.out.println("BAtch is successfully executed");
         }
         catch(Exception e)
         {
        	 try
        	 {
        		 con.rollback();
        		 System.out.println("Batch is failed");
        		 System.out.println("Exception is :"+e);
        		 
        	 }
        	 catch(Exception e1)
        	 {
        		 System.out.println("Exception is "+e1);
        	 }
         }

	}

}
