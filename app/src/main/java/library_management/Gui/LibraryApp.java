package library_management.Gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import library_management.Obj.User;

public class LibraryApp extends BaseFrame{

    public LibraryApp(String title, User user) {
        super(title, user);
    }

    @Override
    protected void addComponent() {
        JLabel welcomeLabel = new JLabel("Welcome " + user.getUsername());
        welcomeLabel.setBounds(0, 20, getWidth() - 10, 40);
        welcomeLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel);
    }
    
}