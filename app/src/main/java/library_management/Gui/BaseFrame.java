package library_management.Gui;

import javax.swing.JFrame;
<<<<<<< HEAD
import java.util.List;

import library_management.Obj.Book;
import library_management.Obj.User;
=======
>>>>>>> 282cc6f (Graddle build)

/*
 * This method is the baseFrame of the project which will create the windows for the 
 * interface to display on. 
 */
public abstract class BaseFrame extends JFrame{

<<<<<<< HEAD
    protected User user;
    protected List<Book> bookList;

=======
>>>>>>> 282cc6f (Graddle build)
    // Public constructor which passes the title of the baseFrame
    public BaseFrame(String title) {
        initialize(title);
    }

<<<<<<< HEAD
    public BaseFrame(String title, User user) {
        this.user = user;
        initialize(title);
    }

    public BaseFrame(String title, List<Book> bookList, User user) {
        this.bookList = bookList;
        this.user = user;
        initialize(title);
    }

=======
>>>>>>> 282cc6f (Graddle build)
    // This method initializes the BaseFrame with multiple parameter of the window
    private void initialize(String title) {

        // Set the title of the baseFrame
        setTitle(title);

        // Set the size
        setSize(1080, 720);

        // Prevent the program to not fully close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set the layout for us to change each component style
        setLayout(null);

        // Make the window not resizable
        setResizable(false);

        // Make the position in the middle of the screen
        setLocationRelativeTo(null);

        // Add component in each different Gui
        addComponent();
    }

    // Abstract method to add different component from each Gui
    protected abstract void addComponent();
}