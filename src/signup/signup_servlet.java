package signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup_servlet")
public class signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public signup_servlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1=request.getParameter("fn");
		String s2=request.getParameter("ln");
		String s3=request.getParameter("email");
		String s4=request.getParameter("pw");
		String s5=request.getParameter("pn");
		String s6=request.getParameter("cn");
		String s7=request.getParameter("que");
		String s8=request.getParameter("ans");
		
		signup_vo v=new signup_vo();
		v.setFn(s1);
		v.setLn(s2);
		v.setEmail(s3);
		v.setPw(s4);
		v.setPn(s5);
		v.setCn(s6);
		v.setQue(s7);
		v.setAns(s8);
		
		System.out.println("kmk");
		System.out.println(""+s1 +s2 +s3 +s4 +s5 +s6 +s7 +s8);
		
		System.out.println("hiiii");
		
		signup_dao d=new signup_dao();
		d.insert(v);
		
		response.sendRedirect("C2W welcome/index.jsp");
	}

}
