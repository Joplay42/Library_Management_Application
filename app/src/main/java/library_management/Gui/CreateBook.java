package library_management.Gui;

import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;

import library_management.Obj.Book;

public class CreateBook extends BaseFrame{

    // Position global variable
    public static int PADDING_X = 40, PADDING_Y = 40;

    public CreateBook(String title, List<Book> bookList) {
        super(title, bookList);
    }

    @Override
    protected void addComponent() {
        // Welcome label
        JLabel createBookLabel = new JLabel("Create a new book");
        createBookLabel.setBounds(PADDING_X, PADDING_Y / 2, getWidth() - 10, 40);
        createBookLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(createBookLabel);
    }
    
}