package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Util {
        //реализуйте настройку соеденения с БД
//    private static Connection conn = null;
//    public static Connection getConnection() {
//        try {
//            if (null == conn || conn.isClosed()) {
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "1");
//                System.out.println("Connection JDBC established successfully");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//    public static void closeConnection() {
//        try {
//            if (conn != null && !conn.isClosed()) {
//                conn.close();
//                System.out.println("Connection JDBC closed successfully");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/myDB");
                configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "1");
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Connection Hibernate established successfully");
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            System.out.println("Connection Hibernate closed successfully");
        }
    }
}