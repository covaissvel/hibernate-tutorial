package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
						
			//starting the transaction
			session.beginTransaction();
			
			//query students
			List<Student> students = session.createQuery("from Student s "
					+ "where s.email like 'daffy%'").getResultList();
			
			//display students
			displayStudents(students);
			
			//committing the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student.toString());
		}
	}

}
