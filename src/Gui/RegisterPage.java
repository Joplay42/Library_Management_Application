package Gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Obj.MyJDBC;
import Obj.User;

public class RegisterPage extends BaseFrame {

    public RegisterPage() {
        super("Library management system - Register");
    }

    @Override
    protected void addComponent() {

        // Create label welcome
        JLabel velcomeLabel = new JLabel("Create a new account");
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
        
        // Create label Phone
        JLabel phoneLabel = new JLabel("Phone number");
        phoneLabel.setBounds(60,310,getWidth() - 60,40);
        phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(phoneLabel);

        // Create textField Phone
        JTextField phoneTextField = new JTextField();
        phoneTextField.setBounds(60,350,getWidth() - 120,40);
        phoneTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(phoneTextField);
        
        // Create label Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(60,410,getWidth() / 2 - 120,40);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(emailLabel);

        // Create textField email
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(60,450,getWidth() / 2 - 120,40);
        emailTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(emailTextField);
        
        // Create label Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(getWidth() / 2,410,getWidth() / 2 - 60,40);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        // Create textField email
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(getWidth() / 2,450,getWidth() / 2 - 60,40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(passwordField);
        
    // Create Login button
        JButton logInButton = new JButton("Create account");
        logInButton.setBounds(60,600,getWidth() - 120,40);
        logInButton.setFont(new Font("Dialog", Font.PLAIN, 24));

        // Add event when clicked
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TO DO
            }
            
        });

        add(logInButton);

    }
}