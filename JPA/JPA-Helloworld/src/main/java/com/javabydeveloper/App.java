package com.javabydeveloper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.javabydeveloper.domain.Student;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("pu1");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Student student = new Student();
			student.setFirstName("Sameer");
			student.setLastName("Verma");
			student.setContactNo("75857644058");

			entityManager.persist(student);

			transaction.commit();
			
			System.out.println(student);
			
			Query q = entityManager.createQuery("select s from Stu s");

			List<Student> resultList = q.getResultList();
			System.out.println("num of sudents:" + resultList.size());
			for (Student next : resultList) {
				System.out.println("next student: " + next);
			}

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}
}
