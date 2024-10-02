package library_management.Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

=======
>>>>>>> 282cc6f (Graddle build)
import library_management.Obj.MyJDBC;
import library_management.Obj.User;

public class LoginPage extends BaseFrame{

    // Constructor that calls the super class with a title parameter
    public LoginPage() {
        super("Library management system - Log in");
    }

    @Override
    protected void addComponent() {

        // Create label welcome
        JLabel velcomeLabel = new JLabel("Log in to your account");
        velcomeLabel.setBounds(0,60,getWidth(),40);
        velcomeLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        velcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(velcomeLabel);

        // Create label UserName
        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(60,210,getWidth() - 60,40);
        userNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(userNameLabel);

        // Create textField userName
        JTextField userNameTextField = new JTextField();
        userNameTextField.setBounds(60,250,getWidth() - 120,40);
        userNameTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(userNameTextField);

        // Create label password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(60,310,getWidth() - 60,40);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        // Create textField password
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(60,350,getWidth() - 120,40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(passwordField);

        // Create Login button
        JButton logInButton = new JButton("Log in");
<<<<<<< HEAD
        logInButton.setBounds(60,550,getWidth() - 120,40);
=======
        logInButton.setBounds(60,600,getWidth() - 120,40);
>>>>>>> 282cc6f (Graddle build)
        logInButton.setFont(new Font("Dialog", Font.PLAIN, 24));

        // Add event when clicked
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userNameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());

                User user = MyJDBC.validateLogin(username, password);

                if (user != null) {
<<<<<<< HEAD
                    LoginPage.this.dispose();
                    LibraryApp libraryApp = new LibraryApp("Library management app", user);
                    libraryApp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "ERROR : User has not been found...");
=======
                    JOptionPane.showMessageDialog(logInButton, "User has been found!");
                } else {
                    JOptionPane.showMessageDialog(logInButton, "ERROR : User has not been found...");
>>>>>>> 282cc6f (Graddle build)
                }
            }
            
        });

        add(logInButton);
<<<<<<< HEAD

        JLabel registerLabel = new JLabel("<html><a href=\"#\">Dont have an account? Register here</a></html>");
        registerLabel.setBounds(0, 600, getWidth(), 40);
        registerLabel.setFont(new Font("dialog", Font.PLAIN, 24));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginPage.this.dispose();
                new RegisterPage().setVisible(true);
            }
        });
=======
>>>>>>> 282cc6f (Graddle build)
    }
    
}