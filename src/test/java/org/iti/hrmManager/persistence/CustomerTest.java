package org.iti.hrmManager.persistence;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iti.hrmManager.test.util.HibernateUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

	private static Session session;
	private static Transaction trx;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		createTestDatabase();

		session = HibernateUtil.getSession();
		trx = session.beginTransaction();
	}

	private static void createTestDatabase() throws IOException, SQLException, ClassNotFoundException {
		Path path = FileSystems.getDefault().getPath("sql", "00_schema.sql");
		String schema = new String(Files.readAllBytes(path));
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:hrm_test.sqlite");
		Statement stm = connection.createStatement();

		try {
			stm.execute(schema);
		} finally {
			connection.close();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			trx.rollback();
			session.close();
		} finally {
			Path database = FileSystems.getDefault().getPath("hrm_test.sqlite");
			
			if (database.toFile().exists()) {
				database.toFile().delete();
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		session.save(createCustomer());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Customer customer = (Customer) session.get(Customer.class, 1);

		assertEquals("Max", customer.getFirstName());
		assertEquals("Mustermann", customer.getSurname());
	}

	private Customer createCustomer() {
		Customer customer = new Customer();

		customer.setFirstName("Max");
		customer.setSurname("Mustermann");

		return customer;
	}
}
