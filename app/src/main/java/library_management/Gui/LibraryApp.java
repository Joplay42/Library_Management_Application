package library_management.Gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.List;
import java.util.ArrayList;

import library_management.Obj.Book;
import library_management.Obj.MyJDBC;
import library_management.Obj.User;

public class LibraryApp extends BaseFrame{

    public LibraryApp(String title, User user) {
        super(title, user);
    }

    @Override
    protected void addComponent() {
        // JLabel welcomeLabel = new JLabel("Welcome " + user.getUsername());
        // welcomeLabel.setBounds(0, 20, getWidth() - 10, 40);
        // welcomeLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        // welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // add(welcomeLabel);

        List<Book> bookList = new ArrayList<>();
        bookList = MyJDBC.fecthBook();

        int y = 20;

        for (Book book : bookList) {
            JLabel bookLabel = new JLabel(book.toString());
            bookLabel.setBounds(0, y, getWidth() - 10, 40);
            y += 20;
            bookLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
            bookLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(bookLabel);
        }

        
    }
    
}