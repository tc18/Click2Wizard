package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import login.login_vo;

public class login_dao {

	public static void search() 
	{
		login_vo v=new login_vo();
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL = "jdbc:mysql://localhost/user_details";	

		//  Database credentials
		String USER = "root";
		String PASS = "";
		   
		
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			
			//STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			
			String sql ="select * from user_data where fname='"+v.getUn()+"'"; 

			/*Query q= session.createQuery(sql);*/
			
			/*while(rs.next())
			{
				v.setUn(rs.getString("un"));// 
				v.setPw(rs.getString("pw"));
			}*/
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
