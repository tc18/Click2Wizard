package cre_pro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import database.database;

import java.util.*;


@WebServlet("/cre_pro_servlet")
public class cre_pro_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cre_pro_servlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s = request.getParameter("pro_name");
		System.out.println(s);

		cre_pro_vo cre1=new cre_pro_vo();
		cre1.setPro_name(s);
		HttpSession ss=request.getSession();
		ss.setAttribute("name", s);
		
		System.out.println(cre1.getPro_name());
		
		cre_pro_dao cre=new cre_pro_dao();
		cre.create();
		
		database db=new database();
		db.insert(cre1);
		
		HttpSession s2=request.getSession();
		List ls=db.search(cre1);
			
		s2.setAttribute("list", ls);
		response.sendRedirect("Click 2 Wizard/index.jsp");
		
	}

}
