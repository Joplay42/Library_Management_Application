package library_management.Obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import com.password4j.Password;

import io.github.cdimascio.dotenv.Dotenv;

public class MyJDBC {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USERNAME = dotenv.get("DB_USERNAME");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    public static User validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement loginQuery = connection.prepareStatement(
                "SELECT * FROM users WHERE username=?"
            );

            loginQuery.setString(1, username);

            ResultSet resultSet = loginQuery.executeQuery();

            if (resultSet.next()) {
                if (checkPassword(password, resultSet.getString("password"))) {
                    // Storage database from object
                    int id = resultSet.getInt("id");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");

                    // Conversion String to Permission
                    String permissionString = resultSet.getString("permission");
                    Permission permission = Permission.valueOf(permissionString);
                    Date account_created = resultSet.getDate("account_created");

                    // Return user logged in object
                    return new User(id, username, email, password, phone, permission, account_created);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean registerNewUser(String username, String password, String email, String phone) {
        try {
            if (!userExist(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement newUserQuery = connection.prepareStatement(
                    "INSERT INTO users (username, email, password, phone, permission, account_created) VALUES (?, ?, ?, ?, ?, ?)"
                );
                newUserQuery.setString(1, username);
                newUserQuery.setString(2, email);
                String encryptPassword = encryptPassword(password);
                newUserQuery.setString(3, encryptPassword);
                newUserQuery.setString(4, phone);
                newUserQuery.setString(5, "user");

                String today = String.valueOf(LocalDate.now());

                newUserQuery.setString(6, today);

                newUserQuery.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean userExist(String userName) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement userExistQuery = connection.prepareStatement(
                "SELECT * FROM users WHERE username = ?"
            );
            userExistQuery.setString(1, userName);
            ResultSet resultSet = userExistQuery.executeQuery();

            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean emailAlreadyInUse(String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement emailQuery = connection.prepareStatement(
                "SELECT * FROM users WHERE email=?"
            );
            emailQuery.setString(1, email);
            ResultSet resultSet = emailQuery.executeQuery();
            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static boolean phoneNumberAlreadyInUse(String phone) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement emailQuery = connection.prepareStatement(
                "SELECT * FROM users WHERE phone=?"
            );
            emailQuery.setString(1, phone);
            ResultSet resultSet = emailQuery.executeQuery();
            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static String encryptPassword(String password) {
        return Password.hash(password).withBcrypt().getResult();
    }

    public static boolean checkPassword(String password, String encryptedPassword) {
        return Password.check(password, encryptedPassword).withBcrypt();
    }
}