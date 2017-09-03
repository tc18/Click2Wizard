package cre_tbl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class cre_tbl_dao {

	public static void create(String q) 
	{
		cre_tbl_vo c=new cre_tbl_vo();
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL = "jdbc:mysql://localhost/"+c.getPro_name();			//here "kk" is database name Important

		//  Database credentials
		String USER = "root";
		String PASS = "";
		   
		
		Connection conn = null;
		Statement stmt = null;
		try
		{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			
			//STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			
			String sql = q;
			/*String sql = "CREATE TABLE "+c.getTbl_name() +
						"(id INTEGER not NULL, " +
		                " first VARCHAR(255), " + 
		                " last VARCHAR(255), " + 
		                " age INTEGER, " + 
		                " PRIMARY KEY ( id ))"; */

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
		    se.printStackTrace();
		}
		catch(Exception e)
		{
		    //Handle errors for Class.forName
		    e.printStackTrace();
		}
		finally
		{
			try
		    {
		         if(stmt!=null)
		            conn.close();
		    }
		    catch(SQLException se)
		    {
		    }
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
