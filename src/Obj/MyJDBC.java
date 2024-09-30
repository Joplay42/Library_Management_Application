package Obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            loginQuery.setString(1, username);
            loginQuery.setString(2, password);

            ResultSet resultSet = loginQuery.executeQuery();

            if (resultSet.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}