package library_management.Gui;

import java.awt.Font;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import library_management.Obj.MyJDBC;
import library_management.Obj.User;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPage extends BaseFrame {

    /**
     * 
     * Here is the default constructor which herits from the baseFrame title
     * 
     */
    public RegisterPage() {
        super("Library management system - Register");
    }

    /**
     * 
     * This abstract method is used to add component to a page. You can add each
     * component you want to your window.
     * 
    */
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
        emailLabel.setBounds(60,410,getWidth() / 2 - 100,40);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(emailLabel);

        // Create textField email
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(60,450,getWidth() / 2 - 100,40);
        emailTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(emailTextField);
        
        // Create label Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(getWidth() / 2,410,getWidth() / 2 - 50,40);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        // Create textField Password
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(getWidth() / 2,450,getWidth() / 2 - 50,40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(passwordField);
        
        // Create Login button
        JButton logInButton = new JButton("Create account");
        logInButton.setBounds(60,550,getWidth() - 120,40);
        logInButton.setFont(new Font("Dialog", Font.PLAIN, 24));

        // Add event when clicked
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // FIELD - the fild for the users when it will be created
                String username = userNameTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // VALIDATION - check is username, email, phone or password is empty
                if (inputValidation(username, email, phone, password)) {
                    // VALIDATION - check if the email is already in use in the database
                    if (!MyJDBC.emailAlreadyInUse(email)) {
                        // VALIDATION - check is the phoneNumber is already in use in the databse
                        if (!MyJDBC.phoneNumberAlreadyInUse(phone)) {
                            // CREATION - create a new user if all the validation is false
                            if (MyJDBC.registerNewUser(username, password, email, phone)) {
                                // DISPOSE
                                RegisterPage.this.dispose();
                                // SHOW - login page
                                LoginPage loginPage = new LoginPage();
                                loginPage.setVisible(true);
                                // DEBUG - show a messageBox with a succesfull message
                                JOptionPane.showMessageDialog(loginPage, "User created successfully!");
                            } else {
                                // DEBUG - show an error message
                                JOptionPane.showMessageDialog(RegisterPage.this, "ERROR : User already exist with this username");
                            }
                        } else {
                            // DEBUG - show an error message
                            JOptionPane.showMessageDialog(RegisterPage.this, "ERROR : Phone number is already in use...");    
                        }
                    } else {
                        // DEBUG - show an error message
                        JOptionPane.showMessageDialog(RegisterPage.this, "ERROR : Email is already in use...");
                    }
                } else {
                    // DEBUG - show an error message
                    JOptionPane.showMessageDialog(RegisterPage.this, "ERROR : All field must have a value...");
                }
            }
            
        });

        add(logInButton);

        // LABEL - to log in to your account if you already have one
        JLabel registerLabel = new JLabel("<html><a href=\"#\">Already have an account? Log in</a></html>");
        registerLabel.setBounds(0, 600, getWidth(), 40);
        registerLabel.setFont(new Font("dialog", Font.PLAIN, 24));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);

        // ACTION - when the link has been clicked it will open the long in page
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterPage.this.dispose();
                new LoginPage().setVisible(true);
            }
        });

    }

    /**
     * 
     * This method is used right before the creation of a user. It validates if all the user
     * input are not null so there is no error in the database with blank value
     * 
     * @param username the name of the user
     * @param email the email of the user
     * @param phone the phone number of the user
     * @param password the password of the user
     * 
     * @return a boolean if the validation is complete
     * 
     **/
    private Boolean inputValidation(String username, String email, String phone, String password) {
        if (username.length() == 0 || email.length() == 0 || phone.length() == 0 || password.length() == 0) return false;
    
        return true;
    }
}