package CONTROLLER;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import project.pro_bord_vo;
import DAO.database;
import DAO.register_dao;
import VO.cre_pro_vo;
import VO.register_vo;
import signup.signup_dao;
import signup.signup_vo;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String flag1=request.getParameter("flag");
		
		if(flag1.equals("cre_pro"))
		{
			String s = request.getParameter("pro_name");
			System.out.println(s);

			cre_pro_vo cre1=new cre_pro_vo();
			cre1.setPro_name(s);
			
			System.out.println(cre1.getPro_name());
			
			database cre=new database();
			cre.create(cre1);
			
			cre.insert(cre1);
			
			HttpSession s2=request.getSession();
			List ls=cre.search(cre1);
				
			s2.setAttribute("list", ls);
			response.sendRedirect("Click 2 Wizard/index.jsp");
		}
		
		if(flag1.equals("go_pro"))
		{
			String s = request.getParameter("pro_name");
	    	System.out.println(s);
	    	
	    	cre_pro_vo c=new cre_pro_vo();
			c.setPro_name(s);
	    	
	    	System.out.println(c.getPro_name());
	    	
	    	HttpSession s2=request.getSession();
			database cre=new database();
	    	List ls=cre.searchTable(c);
			
	    	s2.setAttribute("p1", ls);
			s2.setAttribute("p2", c.getPro_name());
			System.out.println(s2.getAttribute("p1"));
			response.sendRedirect("Click 2 Wizard/pro1.jsp");
		}
		if(flag1.equals("go_tbl"))
		{
			String s1 = request.getParameter("pro_name");
	    	System.out.println(s1);
	    	String s2 = request.getParameter("tbl_name");
	    	System.out.println(s2);
	    	
	    	cre_pro_vo c=new cre_pro_vo();
			c.setPro_name(s1);
			c.setTbl_name(s2);
			
			System.out.println("pro_name = "+c.getPro_name());
			System.out.println("tbl_name = "+c.getTbl_name());
			
			HttpSession hs=request.getSession();
			database sf=new database();
			List ls=sf.searchfield(c);
			
			hs.setAttribute("p1", ls);
			hs.setAttribute("tbl_name",c.getTbl_name());
			hs.setAttribute("pro_name",c.getPro_name());
			
			System.out.println(((cre_pro_vo) ls.get(0)).getField_name());
			response.sendRedirect("Click 2 Wizard/pro1_t1_datasheet.jsp");
			
	    	
		}
		/*else if(flag1.equals("demo"))
		{
			Class.forName("com.mysql.jdbc.Driver");

			
		}*/
		if(flag1.equals("logout"))
		{
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("C2W welcome/index.jsp");
		}
		else
		{
			System.out.println("can't go in if part");
		}
		
	}

}
