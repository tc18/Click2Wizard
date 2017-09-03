package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import DAO.database;
import DAO.register_dao;
import VO.cre_pro_vo;
import VO.register_vo;
import signup.signup_dao;
import signup.signup_vo;


@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignIn() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String flag1=request.getParameter("flag");
		
		if(flag1.equals("signin"))
		{
			System.out.println("In Signin");
			String s1=request.getParameter("username");
			String s2=request.getParameter("password");
			
			System.out.println(""+s1 +s2);
			
			register_vo v=new register_vo();
			v.setEmail(s1);
			v.setPw(s2);
			
			register_dao d=new register_dao();
			List list=d.search(v);
			
			System.out.println("servlet = "+((register_vo) list.get(0)).getEmail()+" password = "+((register_vo)list.get(0)).getPw());
			
			if(s1.equals(((register_vo) list.get(0)).getEmail()) && s2.equals(((register_vo) list.get(0)).getPw()))
			{
				System.out.println("right user name & pass");
				
				cre_pro_vo cre1=new cre_pro_vo();
				database db=new database();
				
				HttpSession a1=request.getSession();
				List ls=db.search(cre1);
					
				a1.setAttribute("list", ls);
				
				HttpSession a2=request.getSession();
				a2.setAttribute("username", ((register_vo) list.get(0)).getFn() +" "+ ((register_vo) list.get(0)).getLn()) ;
				
				response.sendRedirect("Click 2 Wizard/index.jsp");
			}
			else{
				System.out.println("wrong");
				
				HttpSession a2=request.getSession();
				a2.setAttribute("error", "Please enter Valid Username Or Password");
			
				
				response.sendRedirect("C2W welcome/index.jsp");
			}
		}
		
		
		else
		{
			System.out.println("can't go in if part");
		}
		
	}

}
