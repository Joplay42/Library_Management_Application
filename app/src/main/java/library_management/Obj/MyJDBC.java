package library_management.Obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.password4j.Password;

import io.github.cdimascio.dotenv.Dotenv;

public class MyJDBC {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USERNAME = dotenv.get("DB_USERNAME");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    /**
     * 
     * This function is used to validate the login of a user by the username and
     * the encrypted password in the database
     * 
     * @param username
     * @param password
     * @return
     */
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

    /**
     * 
     * This method is used to register a new user in the database. It needs a username, 
     * password, email, and phoneNumber. It returns a boolean, if true the user has been 
     * registered.
     * 
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
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

    /**
     * 
     * This method is used to check if a user already exist in the database. This method is used
     * when the user is trying to log in and when the user wants to register. It returns a boolean
     * if true the user already exist.
     * 
     * @param userName
     * @return
     */
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

    /**
     * 
     * This method is used if the email of an account is already in use. It returns a boolean,
     * if true then the email is already in use. 
     * 
     * @param email
     * @return
     */
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

    /**
     * 
     * This method is used if the phone of an account is already in use. It returns a boolean,
     * if true then the phone is already in use. 
     * 
     * @param phone
     * @return
     */
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

    /**
     * 
     * This method uses BCrypt to encrypt the password before it is stored
     * in the database which is useful for security protocol.
     * 
     * @param password
     * @return
     */
    public static String encryptPassword(String password) {
        return Password.hash(password).withBcrypt().getResult();
    }

    /**
     * 
     * This method checks when the user is trying to log in, if the real password
     * matches with the encrypted password in the database. 
     * 
     * @param password
     * @param encryptedPassword
     * @return
     */
    public static boolean checkPassword(String password, String encryptedPassword) {
        return Password.check(password, encryptedPassword).withBcrypt();
    }

    /**
     * 
     * This method is used when the libraryApp gui is loaded it fetches all the 
     * books in the database.
     * 
     * @return
     */
    public static List<Book> fecthBook() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement fetchBook = connection.prepareStatement(
                "SELECT * FROM books"
            );

            ResultSet resultSet = fetchBook.executeQuery();

            List<Book> fetchedBooks = new ArrayList<>();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isbn = resultSet.getString("isbn");
                int published_year = resultSet.getInt("published_year");
                boolean is_available = resultSet.getBoolean("is_available");

                Book book = new Book(title, author, isbn, published_year, is_available);

                fetchedBooks.add(book);
            }

            return fetchedBooks;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 
     * This method is used for the admin to delete the specified book in the list
     * 
     * @return
     */
    public static boolean deleteBook(Book book) {
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement deleteIndex = connection.prepareStatement(
                "DELETE FROM books WHERE title=?"
            );
            deleteIndex.setString(1, book.getTitle());

            // Execute the query
            int resultSet = deleteIndex.executeUpdate();

            // Check if error 
            if (resultSet > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}