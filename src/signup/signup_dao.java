package signup;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import signup.*;

public class signup_dao {
	
	public void insert(signup_vo v)
	{
		System.out.println("Hiiii");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try{
			session.save(v);
			tr.commit();
		}
		catch(Exception e){}
	}
	
	public List search(signup_vo v){
		List ls=new ArrayList();
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			Query q=session.createQuery("from signup_vo where email='"+v.getEmail()+"'");

			ls=q.list();
			System.out.println("servlet = "+((signup_vo) ls.get(0)).getEmail()+" password = "+((signup_vo)ls.get(0)).getPw());
			t.commit();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	
	}
	
	public void delete(signup_vo v){
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from user_data where id like'"+v.getId()+"'");
			  q.executeUpdate();
			  tr.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}						
	}
	
	public void edit(signup_vo v){
		try
		{
			  System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  session.saveOrUpdate(v);
			  tr.commit();
		}
		catch(Exception e){}

	}
}
 	