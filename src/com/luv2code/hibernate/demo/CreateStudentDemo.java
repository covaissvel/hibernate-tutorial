package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create the student object
			System.out.println("Creating a new student object..");
			Student newStudent = new Student("Paul", "newton", "paul@luv2code.com");
			
			//starting the transaction
			session.beginTransaction();
			
			//saving the student object
			System.out.println("Saving the student..");
			session.save(newStudent);
						
			//committing the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
