package org.iti.hrmManager.test.util;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;

    static {
        try {
        	Path path = FileSystems.getDefault().getPath("src/test/java/hibernate.cfg.xml");
        	Configuration configuration = new Configuration();
        	
        	configuration.configure(path.toUri().toURL());
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        			configuration.getProperties()).build();

        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex.getMessage());
        }
    }

    public static Session getSession()
            throws Exception {
        return sessionFactory.openSession();
    }
}
