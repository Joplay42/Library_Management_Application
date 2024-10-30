package library_management.Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import library_management.Interfaces.Data;
import library_management.Obj.Book;
import library_management.Obj.MyJDBC;
import library_management.Obj.Transaction;
import library_management.Obj.User;

public class RentedList extends BaseFrame implements Data{

    // Position global variable
    private static int PADDING_X = 40, PADDING_Y = 40;

    // Transaction list
    private static List<Transaction> transactionList = new ArrayList<Transaction>();

    // Create the default list model
    private static DefaultListModel<Transaction> listModel = new DefaultListModel<>();  

    public RentedList(String title, User user) {
        super(title, user);
    }

    @Override
    protected void addComponent() {
        // Welcome label
        JLabel titleLabel = new JLabel("Your rented books");
        titleLabel.setBounds(PADDING_X, PADDING_Y, getWidth() - PADDING_X, 40);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        add(titleLabel);

        // Fetch the data
        DisplayData();

        // Create List component
        JList<Transaction> displayTransactionList = new JList<Transaction>(listModel);
        displayTransactionList.setFont(new Font("Dialog", Font.PLAIN, 16));

        // Create ScrollPane Component
        JScrollPane scrollPane = new JScrollPane(displayTransactionList);
        scrollPane.setBounds(PADDING_X, PADDING_Y + 90, getWidth() / 2, getHeight() - 300);
        add(scrollPane);

        // Go back button
        JButton backButton = new JButton("Go back");
        backButton.setBounds(PADDING_X,600,getWidth() - PADDING_X * 3,35);
        backButton.setFont(new Font("Dialog", Font.PLAIN, 16));
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RentedList.this.dispose();
                new LibraryApp("Library management app", user).setVisible(true);;
            }
            
        });
        add(backButton);
        
        // return book button
        JButton returnButton = new JButton("Return book");                                                                                                                                                 
        returnButton.setBounds(getWidth() - 450, getHeight() - 590, 400, 30);
        returnButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if book is selected
                if (displayTransactionList.getSelectedIndex() != -1) {
                    // Store temporarily the transaction
                    Transaction transaction = displayTransactionList.getSelectedValue();

                    // Show confirmation message
                    int response = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to return this book?",
                        "Confirm selection",
                        JOptionPane.YES_NO_OPTION
                    );

                    // Do action
                    if (response == JOptionPane.YES_OPTION) {
                        // Fetch transaction user storage
                        User transactionUser = MyJDBC.fetchUserById(3);

                        // Add return date
                        transaction.setActual_return_date(new Date(System.currentTimeMillis()));
                        transaction.setUser(transactionUser);

                        // Set available
                        Book book = transaction.getBook();
                        book.set_available(true);
                        // Add in database
                        MyJDBC.setAvailability(true, book.getId());

                        // Store in database
                        if (MyJDBC.confirmTransaction(transaction)) {
                            // Show confirmatin message
                            JOptionPane.showMessageDialog(RentedList.this, book.getTitle() + "has been returned");
                        }

                        DisplayData();
                    }
                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(RentedList.this, "A book must be selected");
                }
            }
            
        });
        add(returnButton);
    }

    @Override
    public void DisplayData() {
        transactionList = MyJDBC.fetchTransactions(user);
        // Clear the data
        listModel.clear();
        // Loop to add each data in the list
        for (Transaction transaction : transactionList) {
            listModel.addElement(transaction);
        }
    }
}
