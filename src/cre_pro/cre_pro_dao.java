package cre_pro;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;

public class cre_pro_dao 
{
	
	public void create() 
	{
		
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL = "jdbc:mysql://localhost/";
	
		//  Database credentials
		String USER = "root";
		final String PASS = "";
	   
		
		Connection conn = null;
		Statement stmt = null;
		try
		{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
	   
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			//STEP 4: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			
			cre_pro_vo cre1=new cre_pro_vo();
			String s1=cre1.getPro_name();
			System.out.println(s1);
			
			String sql = "CREATE DATABASE " +s1;
			
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
				stmt.close();
			}
			catch(SQLException se2)
			{
			}// nothing we can do
			try
			{
				if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}//end finally try
		}//end try
	
		System.out.println("Goodbye!");
	}
}