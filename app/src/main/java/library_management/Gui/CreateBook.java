package library_management.Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;

import library_management.Obj.Book;
import library_management.Obj.MyJDBC;
import library_management.Obj.User;

public class CreateBook extends BaseFrame{

    // Position global variable
    public static int PADDING_X = 40, PADDING_Y = 40;

    public CreateBook(String title, List<Book> bookList, User user) {
        super(title, bookList, user);
    }

    @Override
    protected void addComponent() {
        // Welcome label
        JLabel createBookLabel = new JLabel("Create a new book");
        createBookLabel.setBounds(PADDING_X, PADDING_Y, getWidth() - PADDING_X, 40);
        createBookLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        createBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(createBookLabel);

        // Create label title
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setBounds(PADDING_X,140,getWidth() - PADDING_X,30);
        titleLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(titleLabel);

        // Create textField title
        JTextField titleTextField = new JTextField();
        titleTextField.setBounds(PADDING_X,180,getWidth() - PADDING_X * 3,30);
        titleTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(titleTextField);

        // Create label author
        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(PADDING_X,220,getWidth() - PADDING_X,30);
        authorLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(authorLabel);

        // Create textField author
        JTextField authorTextField = new JTextField();
        authorTextField.setBounds(PADDING_X,260,getWidth() - PADDING_X * 3,30);
        authorTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(authorTextField);

        // Create label ISBN
        JLabel ISBNLabel = new JLabel("ISBN");
        ISBNLabel.setBounds(PADDING_X,300,getWidth() - PADDING_X,30);
        ISBNLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(ISBNLabel);

        // Create textField author
        JTextField ISBNTextField = new JTextField();
        ISBNTextField.setBounds(PADDING_X,340,getWidth() - PADDING_X * 3,30);
        ISBNTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(ISBNTextField);

        // Create label published year
        JLabel yearLabel = new JLabel("Published year :");
        yearLabel.setBounds(PADDING_X,380,getWidth() - PADDING_X,30);
        yearLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(yearLabel);

        // Create textField author
        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(PADDING_X,420,getWidth() - PADDING_X * 3,30);
        yearTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(yearTextField);

        // Create add book button
        JButton createButton = new JButton("Add book");
        createButton.setBounds(PADDING_X,480,getWidth() - PADDING_X * 3,35);
        createButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        // Add action listener to create book in db and in the list
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String stringYear = yearTextField.getText();
                int year = Integer.parseInt(stringYear);
                Book book = MyJDBC.createBook(titleTextField.getText(), authorTextField.getText(), ISBNTextField.getText(), year);

                // If it is stored in database
                if (!book.isEmpty()) {
                    // Create object in list
                    bookList.add(book);
                    // Confirmation message
                    JOptionPane.showMessageDialog(CreateBook.this, "The book has been created and stored!");
                    // Change gui
                    CreateBook.this.dispose();
                    LibraryApp libraryApp = new LibraryApp("Library management app", user);
                    libraryApp.setVisible(true);
                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(CreateBook.this, "An error has occured...");
                }
            }
            
        });
        add(createButton);

        // Create go back button
        JButton backButton = new JButton("Go back");
        backButton.setBounds(PADDING_X,525,getWidth() - PADDING_X * 3,35);
        backButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        // Add action listener
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CreateBook.this.dispose();
                LibraryApp libraryApp = new LibraryApp("Library management app", user);
                libraryApp.setVisible(true);
            }
            
        });
        add(backButton);
    }
    
}