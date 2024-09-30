package Gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        logInButton.setBounds(60,600,getWidth() - 120,40);
        logInButton.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(logInButton);
    }
    
}