package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection conn = null;
    private static Util instance = null;
    private Util() {
        try {
            if (null == conn || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }
    public Connection getConnection() {
        return conn;
    }
}