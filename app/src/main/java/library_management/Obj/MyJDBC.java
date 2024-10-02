package library_management.Obj;

<<<<<<< HEAD
import java.sql.Statement;
=======
>>>>>>> 282cc6f (Graddle build)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 282cc6f (Graddle build)

import com.password4j.Password;

import io.github.cdimascio.dotenv.Dotenv;

public class MyJDBC {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USERNAME = dotenv.get("DB_USERNAME");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

<<<<<<< HEAD
    /**
     * 
     * This function is used to validate the login of a user by the username and
     * the encrypted password in the database
     * 
     * @param username
     * @param password
     * @return
     */
=======
>>>>>>> 282cc6f (Graddle build)
    public static User validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement loginQuery = connection.prepareStatement(
<<<<<<< HEAD
                "SELECT * FROM users WHERE username=?"
            );

            loginQuery.setString(1, username);
=======
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            loginQuery.setString(1, username);
            loginQuery.setString(2, password);
>>>>>>> 282cc6f (Graddle build)

            ResultSet resultSet = loginQuery.executeQuery();

            if (resultSet.next()) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 282cc6f (Graddle build)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

<<<<<<< HEAD
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
    public static User registerNewUser(String username, String password, String email, String phone) {

        User user = new User();

        try {
            if (!userExist(username)) {
                System.out.println("Test");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement newUserQuery = connection.prepareStatement(
                    "INSERT INTO users (username, email, password, phone, permission, account_created) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
                );
                newUserQuery.setString(1, username);
                newUserQuery.setString(2, email);
                String encryptPassword = encryptPassword(password);
                newUserQuery.setString(3, encryptPassword);
=======
    public static boolean registerNewUser(String username, String password, String email, String phone) {
        try {
            if (!userExist(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement newUserQuery = connection.prepareStatement(
                    "INSERT INTO users (username, email, password, phone, permission, account_created) VALUES (?, ?, ?, ?, ?, ?)"
                );
                newUserQuery.setString(1, username);
                newUserQuery.setString(2, email);
                newUserQuery.setString(3, password);
>>>>>>> 282cc6f (Graddle build)
                newUserQuery.setString(4, phone);
                newUserQuery.setString(5, "user");

                String today = String.valueOf(LocalDate.now());

                newUserQuery.setString(6, today);

                newUserQuery.executeUpdate();
<<<<<<< HEAD

                ResultSet generatedKeys = newUserQuery.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    user.setId(generatedId);
                    user.setUsername(username);
                    user.setPassword(encryptPassword);
                    user.setEmail(email);
                    user.setPhone(phone);
                    user.setPermission(Permission.user);
                    user.setAccount_created(new Date());
                }
                return user;
=======
                return true;
>>>>>>> 282cc6f (Graddle build)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
        return user;
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
=======
        return false;
    }

>>>>>>> 282cc6f (Graddle build)
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

<<<<<<< HEAD
    /**
     * 
     * This method is used if the email of an account is already in use. It returns a boolean,
     * if true then the email is already in use. 
     * 
     * @param email
     * @return
     */
=======
>>>>>>> 282cc6f (Graddle build)
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

<<<<<<< HEAD
    /**
     * 
     * This method is used if the phone of an account is already in use. It returns a boolean,
     * if true then the phone is already in use. 
     * 
     * @param phone
     * @return
     */
=======
>>>>>>> 282cc6f (Graddle build)
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

<<<<<<< HEAD
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
                int book_id = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isbn = resultSet.getString("isbn");
                int published_year = resultSet.getInt("published_year");
                boolean is_available = resultSet.getBoolean("is_available");

                Book book = new Book(book_id ,title, author, isbn, published_year, is_available);

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
    
    /**
     * 
     * This method is used to create a new book and to put it into the database with
     * this right information typed by the user.
     * 
     * @param title
     * @param author
     * @param isbn
     * @param published_year
     * @return
     */
    public static Book createBook(String title, String author, String isbn, int published_year) {
        Book book = new Book();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement createBookQuery = connection.prepareStatement(
                "INSERT INTO books (title, author, isbn, published_year, is_available) VALUES (?, ?, ?, ?, true)",
                Statement.RETURN_GENERATED_KEYS
            );
            createBookQuery.setString(1, title);
            createBookQuery.setString(2, author);
            createBookQuery.setString(3, isbn);
            createBookQuery.setInt(4, published_year);

            createBookQuery.executeUpdate();

            ResultSet generatedKeys = createBookQuery.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                book.setId(generatedId);
                book.setTitle(title);
                book.setAuthor(author);
                book.setIsbn(isbn);
                book.setPublished_year(published_year);
                book.set_available(true);
            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    /**
     * 
     * This method is used to create a transaction when a book is getting rented.
     * It creates an object of transaction which is then stored in the database.
     * 
     * @param user_id
     * @param book_id
     * @return
     */
    public static Transaction addTransaction(User user, Book book) {
        Transaction result = new Transaction(user, book);
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement createTransactionQuery = connection.prepareStatement(
                "INSERT INTO transactions (user_id, book_id, borrow_date, return_date, actual_return_date) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            createTransactionQuery.setInt(1, user.getId());
            createTransactionQuery.setInt(2, book.getId());
            createTransactionQuery.setDate(3, new java.sql.Date(result.getBorrow_date().getTime()));
            createTransactionQuery.setDate(4, new java.sql.Date(result.getReturn_date().getTime()));
            createTransactionQuery.setNull(5, java.sql.Types.DATE);
           

            createTransactionQuery.executeUpdate();

            ResultSet generatedKeys = createTransactionQuery.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                result.setTransaction_id(generatedId);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 
     * Set the availability of the book when it is rented or when it is return
     * 
     * @param response
     * @param index
     */
    public static void setAvailability(boolean response, int index) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement changeAvailabilityQuery = connection.prepareStatement(
               "UPDATE books SET is_available=? WHERE book_id=?"
            );
            changeAvailabilityQuery.setBoolean(1, response);
            changeAvailabilityQuery.setInt(2, index);
            changeAvailabilityQuery.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Fetch the users book transactions
     * 
     * @param currentUser
     * @return
     */
    public static List<Transaction> fetchTransactions(User currentUser) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement fetchTransaction = connection.prepareStatement(
                "SELECT * FROM transactions WHERE user_id=?"
            );

            fetchTransaction.setInt(1, currentUser.getId());

            ResultSet resultSet = fetchTransaction.executeQuery();

            List<Transaction> fetchedTransactions = new ArrayList<>();

            while (resultSet.next()) {
                int transaction_id = resultSet.getInt("transaction_id");
                int user_id = resultSet.getInt("user_id");
                int book_id = resultSet.getInt("book_id");
                Date borrow_date = resultSet.getDate("borrow_date");
                Date return_date = resultSet.getDate("return_date");
                Date actual_return_date = resultSet.getDate("actual_return_date");

                User user = fetchUserById(user_id);
                Book book = fetchBookById(book_id);

                Transaction transaction = new Transaction(transaction_id, user, book, borrow_date, return_date, actual_return_date);

                fetchedTransactions.add(transaction);
            }

            return fetchedTransactions;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 
     * This method is used to fetch the user by id in the database to ensure the data structure
     * 
     * @param user_id
     * @return
     */
    public static User fetchUserById(int user_id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement fetchUser = connection.prepareStatement(
                "SELECT * FROM users WHERE id=?"
            );

            fetchUser.setInt(1, user_id);
            ResultSet resultset = fetchUser.executeQuery();
            
            if (resultset.next()) {

                String username = resultset.getString("username");
                String email = resultset.getString("email");
                String password = resultset.getString("password");
                String phone = resultset.getString("phone");
                String permissionStr = resultset.getString("permission");
                Permission permission = Permission.valueOf(permissionStr);
                Date account_created = resultset.getDate("account_created");

                return new User(user_id, username, email, password, phone, permission, account_created);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * 
     * This method is used to fetch the book by id in the database to ensure the data structure
     * 
     * @param book_id
     * @return
     */
    public static Book fetchBookById(int book_id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement fetchUser = connection.prepareStatement(
                "SELECT * FROM books WHERE book_id=?"
            );

            fetchUser.setInt(1, book_id);
            ResultSet resultset = fetchUser.executeQuery();    
            
            if (resultset.next()) {

                String title = resultset.getString("title");
                String author = resultset.getString("author");
                String isbn = resultset.getString("isbn");
                int published_year = resultset.getInt("published_year");
                boolean is_available = resultset.getBoolean("is_available");

                return new Book(book_id, title, author, isbn, published_year, is_available);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static boolean confirmTransaction (Transaction transaction) {
        boolean result = false;

        try {
            // Conection to the databse
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement confirmTransaction = connection.prepareStatement(
                "UPDATE transactions SET user_id=?, actual_return_date=? WHERE transaction_id=?"
            );

            // Set the custom variable
            confirmTransaction.setInt(1, 3);
            confirmTransaction.setDate(2, new java.sql.Date(transaction.getActual_return_date().getTime()));
            confirmTransaction.setInt(3, transaction.getTransaction_id());

            confirmTransaction.executeUpdate();

            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
=======
    public static String encryptPassword(String password) {
        return Password.hash(password).withArgon2().getResult();
    }
>>>>>>> 282cc6f (Graddle build)
}