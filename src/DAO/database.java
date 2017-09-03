package DAO;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import VO.cre_pro_vo;

public class database {
	
	public List search(cre_pro_vo v)
	{
		List ls=new ArrayList<cre_pro_vo>();
		try
		{
		
		System.out.println("in search");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user_data","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from details_db");
		
		System.out.println("hello");
		
		while(rs.next())
		{
			cre_pro_vo v1=new cre_pro_vo();
			
			System.out.println(rs.getString("ProjectName"));
			v1.setPro_name(rs.getString("ProjectName"));
			v1.setData(rs.getString("Data_size"));
			ls.add(v1);
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	public void insert(cre_pro_vo v)
	{
		try
		{
			System.out.println("in db");
			System.out.println(v.getPro_name());
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user_data","root","");
			Statement st=con.createStatement();
			st.executeUpdate("insert into details_db(ProjectName,Data_size) values('"+v.getPro_name()+"','')");
		
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public List searchTable(cre_pro_vo v)
	{
		List ls=new ArrayList<cre_pro_vo>();
		try
		{
		
		System.out.println("DAO at search list of tables");
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+v.getPro_name(),"root","");
		 
		
		DatabaseMetaData md = con.getMetaData();
		ResultSet rs = md.getTables(null, null, "%", null);
		while (rs.next()) 
		{
			cre_pro_vo v1=new cre_pro_vo();
			System.out.println(rs.getString(3));
			v1.setData(rs.getString(3).toString());
			ls.add(v1);
		}
		
		
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	public List searchfield(cre_pro_vo v)
	{
		List ls=new ArrayList<cre_pro_vo>();
		try
		{
		
		System.out.println("DAO at search list of tables");
		System.out.println("project name"+v.getPro_name());
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+v.getPro_name(),"root","");
		
		System.out.println("tablename="+v.getTbl_name());
		String query="SHOW COLUMNS FROM "+v.getTbl_name();
		System.out.println(query);
		
		DatabaseMetaData md = con.getMetaData();
		ResultSet resultSet = md.getColumns(null, null, v.getTbl_name(), null);
		    while (resultSet.next()) {
		      String name = resultSet.getString("COLUMN_NAME");
		      String type = resultSet.getString("TYPE_NAME");
		      int size = resultSet.getInt("COLUMN_SIZE");
		      
		      System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
		      
		      cre_pro_vo v1=new cre_pro_vo();
		      v1.setField_name(name);
		      v1.setType(type);
		      v1.setSize(size);
		      ls.add(v1);
		    }
		
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return ls;
	}
	
	public void create(cre_pro_vo v) 
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
			
			String s1=v.getPro_name();
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
