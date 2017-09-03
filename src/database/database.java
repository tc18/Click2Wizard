package database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

import cre_pro.cre_pro_vo;

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
			cre_pro_vo v1=new cre_pro.cre_pro_vo();
			
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
}
