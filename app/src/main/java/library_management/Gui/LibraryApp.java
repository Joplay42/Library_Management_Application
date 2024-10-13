package library_management.Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.util.List;
import java.util.ArrayList;

import library_management.Obj.Book;
import library_management.Obj.MyJDBC;
import library_management.Obj.Permission;
import library_management.Obj.User;

public class LibraryApp extends BaseFrame{

    public static int PADDING_X = 40, PADDING_Y = 40;

    // Create an object list of book
    public static List<Book> bookList = new ArrayList<>();
    
    // Create the default list model
    public static DefaultListModel<Book> l1 = new DefaultListModel<>();  

    public LibraryApp(String title, User user) {
        super(title, user);
    }

    @Override
    protected void addComponent() {

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome " + user.getUsername());
        welcomeLabel.setBounds(PADDING_X, PADDING_Y / 2, getWidth() - 10, 40);
        welcomeLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(welcomeLabel);

        // List label
        JLabel listLabel = new JLabel("Book List");
        listLabel.setBounds(PADDING_X, PADDING_Y + 50, getWidth() - 10, 40);
        listLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(listLabel);
         
        // Fetch the data
        showData();

        // Create List component
        JList<Book> displayBookList = new JList<Book>(l1);
        displayBookList.setFont(new Font("Dialog", Font.PLAIN, 16));

        
        // Wrap JList in ScrollPane
        JScrollPane scrollPane = new JScrollPane(displayBookList);
        scrollPane.setBounds(PADDING_X, PADDING_Y + 90, getWidth() / 2, getHeight() - 300);
        // Add to gui
        add(scrollPane);
        
        
        // Info label
        JLabel infoLabel = new JLabel("Book information");
        infoLabel.setBounds(getWidth() - 450, getHeight() - 407, getWidth() - 10, 40);
        infoLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(infoLabel);

        
        // Display book information
        JTextArea bookInformation = new JTextArea("");
        bookInformation.setBounds(getWidth() - 450, getHeight() - 370, 400, 200);
        add(bookInformation);
        
        // Event when book is selected
        displayBookList.addListSelectionListener(e -> {
            Book selectedBook = displayBookList.getSelectedValue();

            // Display book information
            if (selectedBook != null) {
                bookInformation.setText(
                    "Title: " + selectedBook.getTitle() + "\n" +
                    "Author: " + selectedBook.getAuthor() + "\n" +
                    "isbn: " + selectedBook.getIsbn() + "\n" +
                    "Published year: " + selectedBook.getPublished_year() + "\n" +
                    "Available: " + selectedBook.isIs_available()
                );
            }
        });

        // If admin 
        if (user.getPermission() == Permission.Admin) {
            // Add books button
            JButton addButton = new JButton("Add books");
            addButton.setBounds(getWidth() - 450, getHeight() - 490, 400, 30);
            add(addButton);

            // Delete books button
            JButton deleteButton = new JButton("Delete books");
            deleteButton.setBounds(getWidth() - 450, getHeight() - 450, 400, 30);
            deleteButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // If no book is selected
                    if (displayBookList.getSelectedIndex() != -1) {
                        // Confirmation message
                        int response = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to delete?",
                            "Confirm deletion",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );

                        // Book deletion
                        if (response == JOptionPane.YES_OPTION) {
                            if (MyJDBC.deleteBook(displayBookList.getSelectedValue())) {
                                bookList.remove(displayBookList.getSelectedIndex());
                                // Realtime database
                                showData();
                            }
                        }
                    } else {
                        // Error message
                        JOptionPane.showMessageDialog(LibraryApp.this, "You must select a book to delete...");
                    }
                }
                
            });
            add(deleteButton);
        }

        // See rented book button
        JButton seeMoreButton = new JButton("See rented books");                                                                                                                                                 
        seeMoreButton.setBounds(getWidth() - 450, getHeight() - 590, 400, 30);
        add(seeMoreButton);

        // Rent book button
        JButton rentButton = new JButton("Rent books");                                                                                                                                                 
        rentButton.setBounds(getWidth() - 450, getHeight() - 550, 400, 30);
        add(rentButton);
    }

    public static void showData() {
        // Fetch the data from database
        bookList = MyJDBC.fecthBook();
        // Clear the data
        l1.clear();
        // Loop to add each data in the list
        for (Book book : bookList) {
            l1.addElement(book);
        }
    }
    
}