package org.iti.hrmManager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iti.hrmManager.persistence.Customer;
import org.iti.hrmManager.persistence.Department;
import org.iti.hrmManager.persistence.Employee;
import org.iti.hrmManager.persistence.Janitor;
import org.iti.hrmManager.persistence.Manager;
import org.iti.hrmManager.persistence.Salesperson;
import org.iti.hrmManager.util.HibernateUtil;

public class Main {

	static String employeeQuery = "from Employee employee where " +
								  "employee.department.name = :name";
	
	static String departmentQuery = "from Department";
	
	static String managerQuery = "from Manager";
	
	static String salespersonQuery = "from Salesperson";
	
	static String customerQuery = "from Customer";
	
	static String janitorQuery = "from Janitor";
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();

			Department department = (Department) sess.get(Department.class, 1);
			System.out.println("================================================");
			System.out.println("= Print the name of the department with id 1 =");
			System.out.println("==============================================");
			System.out.println(department.getName());
			
			Query query = sess.createQuery(employeeQuery)
							  .setString("name", department.getName());
			
			@SuppressWarnings("unchecked")
			List<Employee> list = (List<Employee>) query.list();
			
			System.out.println("\n=====================================================");
			System.out.println("= Print the names of all employees of department IT =");
			System.out.println("=====================================================\n");
			
			for (Employee employee : list) {
				System.out.println(employee.getFirstName() + " " + employee.getSurname());
			}
			
			query = sess.createQuery(managerQuery);
			
			@SuppressWarnings("unchecked")
			List<Manager> managers = (List<Manager>) query.list();
			
			System.out.println("\n=======================================================================");
			System.out.println("= Print the names of all managers and their bosses (if a boss exists) =");
			System.out.println("=======================================================================\n");
			
			for (Manager manager : managers) {
				System.out.print(manager.getFirstName() + " " + manager.getSurname() + " (" + manager.getAccount() + ") ");
				
				if (manager.getBoss() != null) {
					System.out.print(" --> " + manager.getBoss().getFirstName());
				}
				System.out.println();
			}
			
			System.out.println("\n========================================================================");
			System.out.println("= Print the names of all customers and the names of their salespersons =");
			System.out.println("========================================================================\n");
			
			query = sess.createQuery(customerQuery);
			
			@SuppressWarnings("unchecked")
			List<Customer> customers = (List<Customer>) query.list();
			
			for (Customer customer : customers) {
				System.out.print(customer.getFirstName() + " " + customer.getSurname());
				
				if (customer.getTakenCareOfBy() != null) {
					Salesperson s = customer.getTakenCareOfBy();
					
					System.out.print(" --> " + s.getFirstName() + " " + s.getSurname());
				}
				
				System.out.println();
			}
			
			System.out.println("\n===================================================================");
			System.out.println("= Print the names of all janitors and the address of the building =");
			System.out.println("===================================================================\n");
			
			query = sess.createQuery(janitorQuery);
			
			@SuppressWarnings("unchecked")
			List<Janitor> janitors = (List<Janitor>) query.list();
			
			for (Janitor janitor : janitors) {
				System.out.println(janitor.getFirstName() + " " + janitor.getSurname()
								   + " (" + janitor.getAddress() + ")");
			}
			
			tx.commit();
		}
		catch (Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
		}
		finally {
			sess.close();
		}
	}
}
