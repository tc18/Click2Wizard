package project;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pro_bord")
public class pro_bord_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public pro_bord_servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String s = request.getParameter("pro_name");
    	System.out.println(s);
    	
    	pro_bord_vo c=new pro_bord_vo();
    	c.setPname(s);
    	
    	System.out.println(c.getPname());
    	
    	HttpSession s2=request.getSession();
		s2.setAttribute("p", s);
		
		System.out.println(s2.getAttribute("p"));
		response.sendRedirect("Click 2 Wizard/pro1.jsp");
    	
	}

}
