package cre_tbl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cre_pro.cre_pro_dao;

@WebServlet("/cre_tbl_servlet")
public class cre_tbl_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cre_tbl_servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String flag=request.getParameter("flag");
		
		if(flag.equals("pro_name"))
		{
			String s = request.getParameter("tbl_name");
			System.out.println("table_name" +s);
			String i = request.getParameter("i");
			System.out.println("table_name" +i);
			
			String text[]=request.getParameterValues("text");
			String select[]=request.getParameterValues("select");
			String size[]=request.getParameterValues("size");
			String pk[]=request.getParameterValues("pk");
			String nn[]=request.getParameterValues("nn");
			String ai[]=request.getParameterValues("ai");
			
			String text1[]=request.getParameterValues("text");
			int aa=text1.length;
			String pk1[]=new String[aa];
			String nn1[]=new String[aa];
			String ai1[]=new String[aa];
			System.out.println("lenght of PK1[]="+pk1.length);
			int a=pk.length;
			int b=nn.length;
			int c=ai.length;
			for(int q=0;q<aa;q++)
			{
				pk1[q]=""+q;
				nn1[q]=""+q;
				ai1[q]=""+q;
				System.out.println("pk1[q]="+pk1[q]);
				System.out.println("nn1[q]="+nn1[q]);
				System.out.println("ai1[q]="+ai1[q]);
			}
			for(int q=0;q<aa;q++)
			{
				int a1=Integer.parseInt(pk1[q]);
				int a3=Integer.parseInt(nn1[q]);
				int a5=Integer.parseInt(nn1[q]);
				breakLoop:
				for(int j=0;j<a;j++)
				{	
					int a2=Integer.parseInt(pk[j]);
					int a4=Integer.parseInt(nn[j]);
					if(pk1[q].equals(pk[j]))
					{
						System.out.println("If pk1["+q+"]="+pk1[q]+" " +"pk["+j+"]= "+pk[j]);
						pk1[q]="ok";
						break breakLoop;
					}
					else if(a1<a2)
					{
						System.out.println("Else pk1["+q+"]="+pk1[q]+" " +"pk["+j+"]= "+pk[j]);
						pk1[q]="no";
						j--;
						j--;
						break breakLoop;
					}
				}
				
				breakLoop1:
				for(int j=0;j<b;j++)
				{	
					int a4=Integer.parseInt(nn[j]);
					if(nn1[q].equals(nn[j]))
					{
						System.out.println("nn1["+q+"]="+nn1[q]+" " +"nn["+j+"]= "+nn[j]);
						nn1[q]="ok";
						break breakLoop1;
					}
					else if(a3<a4)
					{
						System.out.println("nn1["+q+"]="+nn1[q]+" " +"nn["+j+"]= "+nn[j]);
						nn1[q]="no";
						j--;
						j--;
						break breakLoop1;
					}
				}
				
				breakLoop2:
					for(int j=0;j<c;j++)
					{	
						int a4=Integer.parseInt(ai[j]);
						if(ai1[q].equals(ai[j]))
						{
							System.out.println("ai1["+q+"]="+ai[q]+" " +"ai["+j+"]= "+ai[j]);
							ai1[q]="ok";
							break breakLoop2;
						}
						else if(a3<a4)
						{
							System.out.println("ai1["+q+"]="+ai1[q]+" " +"ai["+j+"]= "+ai[j]);
							ai1[q]="no";
							j--;
							j--;
							break breakLoop2;
						}
					}
					
				System.out.println("pk1["+q+"]= "+pk1[q] +" nn1["+q+"]= "+nn1[q] +" ai1["+q+"]= "+ai1[q]);
			}
			for(int q=0;q<text.length;q++)
			{
				System.out.print(+q+"-"+pk1[q]+" ");
				System.out.print(+q+"-"+nn1[q]+" ");
				System.out.print(+q+"-"+ai1[q]+" ");
			}
			
			
			String que=null;
			String key=null;
			String primarykey=null;
			String primarykey0=null;
			for(int q=0;q<pk1.length;q++)
			{
				
				if(que!=null)
				{	
					System.out.println("If part "+pk1[q]);
					if(pk1[q].equals("ok") || nn1[q].equals("ok") || ai1[q].equals("ok"))
					{
						if(pk1[q].equals("ok"))
						{
							System.out.println("if if While"+q);
							if(ai1[q].equals("ok"))
							{
								que=que +" "+ text[q] +" "+select[q] +"("+ size[q] +") not NULL AUTO_INCREMENT, ";
								key="'"+text[q]+"' ('"+text[q]+"')" ;
								if(q<pk1.length-1)
								{
									System.out.println("-----------"+primarykey0);
									if(primarykey0!=null)
									{
										primarykey0=primarykey0+","+text[q]+",";
									}
									else
									{
										primarykey0=primarykey0+text[q]+",";
									}
								}
								else
								{
									primarykey0=primarykey0+text[q];
								}
							}
							else
							{
								que=que +" "+ text[q] +" "+select[q] +"("+ size[q] +") not NULL , ";
								if(q<pk1.length-1)
								{
									if(primarykey0!=null)
									{
										primarykey0=primarykey0+","+text[q];
									}
									else
									{
										primarykey0=primarykey0+text[q]+",";
									}
								}
								else
								{
									primarykey0=primarykey0+text[q];
								}
							}
						}
						else if(nn1[q].equals("ok"))
						{
							System.out.println("if if While"+q);
							if(ai1[q].equals("ok"))
							{
								que=que +" "+ text[q] +" "+select[q] +"("+ size[q] +") not NULL AUTO_INCREMENT, ";
								key="'"+text[q]+"' ('"+text[q]+"')" ;
								
							}
							else
							{
								que=que +" "+ text[q] +" "+select[q] +"("+ size[q] +") not NULL, ";
							}
						}
						else if(ai1[q].equals("ok"))
						{
							que=que +" "+ text[q] +" "+select[q] +"("+ size[q] +") AUTO_INCREMENT, ";
							key="'"+text[q]+"' ('"+text[q]+"')" ;
							
						}
						else
						{
							System.out.println("if else While"+q);
							que=que + text[q] +" "+select[q] +"("+ size[q] +"),";
						}
					}
				}
				else
				{
					System.out.println("Else part "+pk1[q]);
					if(pk1[q].equals("ok") || nn1[q].equals("ok") || ai1[q].equals("ok"))
					{
						if(pk1[q].equals("ok"))
						{
							if(ai1[q].equals("ok"))
							{
								que=text[q] +" "+select[q] +"("+ size[q] +") not NULL AUTO_INCREMENT, ";
								key=""+text[q]+" ("+text[q]+")" ;
								if(q<pk1.length-1)
								{
									primarykey0=text[q]+",";
								}
								if(q<=0)
								{
									primarykey0=text[q];
								}
								else
								{
									primarykey0="";
								}
							}
							else
							{
								System.out.println("else if While"+q);
								que=text[q] +" "+select[q] +"("+ size[q] +") not NULL, ";
								if(q<pk1.length-1)
								{
									primarykey0=text[q]+",";
								}
								else
								{
									primarykey0="";
								}
							}
							
						}
						else if(nn1[q].equals("ok"))
						{
							System.out.println("if if While"+q);
							if(ai1[q].equals("ok"))
							{
								que=text[q] +" "+select[q] +"("+ size[q] +") not NULL AUTO_INCREMENT, ";
								key=""+text[q]+" ("+text[q]+")" ;
								primarykey0="";
							}
							else
							{
								que=text[q] +" "+select[q] +"("+ size[q] +") not NULL, ";
								primarykey0="";
							}
						}
						else if(ai1[q].equals("ok"))
						{
							que=text[q] +" "+select[q] +"("+ size[q] +") AUTO_INCREMENT, ";
							key="'"+text[q]+"' ('"+text[q]+"')" ;
							primarykey0="";
						}
						else
						{
							System.out.println("else else While"+q);
							que=text[q] +" "+select[q] +" ("+ size[q] +"),";
							primarykey0="";
						}
					}
				}
				
				
			}
			
			if(primarykey0!=null)
			{
				primarykey=" PRIMARY KEY ( " +primarykey0+ " ),";
			}
			else
			{
				primarykey="";
			}
			
			if(key!=null)
			{
				key=" KEY "+key;
			}
			else
			{
				key="";
			}
			System.out.println(primarykey);
			
			System.out.println(que);
			String s1 = request.getParameter("pro_name").toLowerCase();
			System.out.println(s1);
			
			cre_tbl_vo cre=new cre_tbl_vo();
			cre.setPro_name(s1);
			cre.setTbl_name(s);
			
			
			String query="CREATE TABLE "+cre.getTbl_name() +"("+ que+ primarykey+key +")"; 
			
			String quety="CREATE TABLE "+cre.getTbl_name() +
					"(id INTEGER not NULL, " +
	                " first VARCHAR(255), " + 
	                " last VARCHAR(255), " + 
	                " age INTEGER, " + 
	                " PRIMARY KEY ( id ))"; 
			
			System.out.println(query);
			System.out.println(quety);
			
			cre_tbl_dao cre1=new cre_tbl_dao();
			cre1.create(query);
			
			/*HttpSession s2=request.getSession();
			List ls=cre.search(cre1);
				
			s2.setAttribute("list", ls);*/
			
			response.sendRedirect("Click 2 Wizard/pro1.jsp");
		}
		else
		{
			System.out.println("Can't go in IF part");
		}
		
	}

}
