package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signup.signup_dao;
import signup.signup_vo;

@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag=request.getParameter("flag");
		
		if(flag=="signin")
		{
			String s1=request.getParameter("username");
			String s2=request.getParameter("password");
			
			System.out.println(""+s1 +s2);
			
			signup_vo v=new signup_vo();
			v.setEmail(s1);
			v.setPw(s2);
			
			signup_dao d=new signup_dao();
			List list=d.search(v);
			System.out.println("servlet = "+((signup_vo) list.get(0)).getEmail()+" password = "+((signup_vo)list.get(0)).getPw());
			if(s1.equals(((signup_vo) list.get(0)).getEmail()) && s2.equals(((signup_vo) list.get(0)).getPw())){
				System.out.println("right user name & pass");
			}
			else{
				System.out.println("rong");
			}
		}
		
		/*HttpSession session =request.getSession();
		session.setAttribute("list", list);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.contains(i));
		}
		PrintWriter out = response.getWriter();
		*/
		
	}

}
