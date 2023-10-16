package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        userService.createUsersTable();
        userService.saveUser("Name", "Lastname", (byte) 10);
        userService.saveUser("Me", "My", (byte) 20);
        userService.saveUser("You", "Yuor", (byte) 30);
        userService.saveUser("He", "Hes", (byte) 40);
        userService.removeUserById(4);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeConnection();
    }
}
