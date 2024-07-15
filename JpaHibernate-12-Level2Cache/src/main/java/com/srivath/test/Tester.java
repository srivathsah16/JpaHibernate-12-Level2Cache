package com.srivath.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.QueryHints;

import com.srivath.entities.Employee;

public class Tester {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

		/*
		 * testig Level2 cache
		 */

//		EntityManager em1 = factory.createEntityManager();
//		EntityManager em2 = factory.createEntityManager();
//
//		Employee e1 = em1.find(Employee.class, 500);
//		System.out.println("==========================  1");
//		try {
//			Thread.sleep(9000);
//		} catch (Exception e) {
//		}
//		Employee e2 = em2.find(Employee.class, 500);
//		System.out.println("==========================  2");
//		try {
//			Thread.sleep(9000);
//		} catch (Exception e) {
//		}
//		Employee e3 = em1.find(Employee.class, 500);
//		System.out.println("==========================  3");
//		try {
//			Thread.sleep(9000);
//		} catch (Exception e) {
//		}
//		Employee e4 = em2.find(Employee.class, 500);
//		System.out.println("==========================  4");
//		em1.close();
//		em2.close();

		/*
		 * testing Query Cache
		 */

		EntityManager em3 = factory.createEntityManager();
		String jpql1 = "SELECT e FROM Employee e WHERE e.salary >?1";
		TypedQuery<Employee> query1 = em3.createQuery(jpql1, Employee.class);
		query1.setParameter(1, 5000.0);
		query1.setHint("org.hibernate.cacheable", true);
		List<Employee> list1 = query1.getResultList();
		for (Employee emp : list1) {
			System.out.println(emp.getName());
		}

		System.out.println("========================================");

		EntityManager em4 = factory.createEntityManager();
		String jpql2 = "SELECT e FROM Employee e WHERE e.salary >?1";
		TypedQuery<Employee> query2 = em3.createQuery(jpql2, Employee.class);
		query2.setParameter(1, 5000.0);
		query2.setHint("org.hibernate.cacheable", true);
		List<Employee> list2 = query2.getResultList();
		for (Employee emp : list2) {
			System.out.println(emp.getName());
		}

		em3.close();
		em4.close();

	}

}
