package library_management.Gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.util.List;
import java.util.ArrayList;

import library_management.Obj.Book;
import library_management.Obj.MyJDBC;
import library_management.Obj.User;

public class LibraryApp extends BaseFrame{

    public static int PADDING_X = 40, PADDING_Y = 40;

    public LibraryApp(String title, User user) {
        super(title, user);
    }

    @Override
    protected void addComponent() {

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome " + user.getUsername());
        welcomeLabel.setBounds(PADDING_X, PADDING_Y, getWidth() - 10, 40);
        welcomeLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(welcomeLabel);

        // Create List component
        JList<Book> displayBookList = new JList<Book>();
        displayBookList.setBounds(PADDING_X, PADDING_Y * 2, getWidth() / 2, getHeight() / 2);

        // Add scrollBar in the list
        JScrollPane scrollPane = new JScrollPane(displayBookList);
        scrollPane.setBounds(PADDING_X, PADDING_Y * 2, getWidth() / 2, getHeight() / 2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        // Create an object list of book
        List<Book> bookList = new ArrayList<>();
        // Fetch the data from database
        bookList = MyJDBC.fecthBook();

        // TO DO
        // TO DO - fix the scroll bar to display all the data
        // TO DO

        // Position
        int posY = 0;
        // Loop to add each data in the list
        for (Book book : bookList) {
            // Create label to display the information
            JLabel bookLabel = new JLabel(book.toString());
            bookLabel.setBounds(0, posY, displayBookList.getWidth(), 20);
            bookLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
            // Add it to the list component
            displayBookList.add(bookLabel);
            // Add value to the position Y
            posY += 20;
        }

        
        
    }
    
}