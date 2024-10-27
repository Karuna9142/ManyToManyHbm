package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToManyDemo {

	public static void main(String[] args) {
		
		Configuration c = new Configuration();
	    c.configure("hibernate.cfg.xml");
	    SessionFactory sf = c.buildSessionFactory();
	    
	    Session s = sf.openSession();	    
	    Transaction t = s.beginTransaction();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setId(11);
		e1.setName("Priyanka");
		
		e2.setId(21);
		e2.setName("Karuna");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(121);
		p1.setProjectName("Railway Management");
		
		p2.setPid(131);
		p1.setProjectName("Zoo Management System");
		
		List<Emp> l1 = new ArrayList<Emp>();
		List<Project> l2 = new ArrayList<Project>();
		
		//for emp
		l1.add(e1);
		l1.add(e2);
		
		//for project
		l2.add(p1);
		l2.add(p2);
		
		//set the project
		e1.setProjects(l2);
		p2.setEmps(l1);
	
		s.save(e1);
		s.save(e2);
		
		s.save(p1);
		s.save(p2);
		
		t.commit();
		s.close();

	}

}
