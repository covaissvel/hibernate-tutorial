package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			//now start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieving the student
			System.out.println("Getting the student with id: "+studentId);			
			Student retrievedStud = session.get(Student.class, studentId);
			System.out.println("retrievedStudent : "+retrievedStud.toString());
			
			//updating student
			retrievedStud.setFirstName("scooby");
			
			//committing the transaction
			session.getTransaction().commit();
			
			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//bulk update
			session.createQuery("update Student set firstName='Daffy'").executeUpdate();			
			
			//committing the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
