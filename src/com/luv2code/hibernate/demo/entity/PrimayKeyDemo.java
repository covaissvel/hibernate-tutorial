package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimayKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create 2 student objects
			System.out.println("Creating 2 new student objects..");
			Student newStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student newStudent2 = new Student("Jane", "Doe", "jane@luv2code.com");
			Student newStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
			
			//starting the transaction
			session.beginTransaction();
			
			//saving the student object
			System.out.println("Saving the student..");
			session.save(newStudent1);
			session.save(newStudent2);
			session.save(newStudent3);
						
			//committing the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}


	}

}
