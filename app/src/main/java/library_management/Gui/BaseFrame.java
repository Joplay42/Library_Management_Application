package library_management.Gui;

import javax.swing.JFrame;

/*
 * This method is the baseFrame of the project which will create the windows for the 
 * interface to display on. 
 */
public abstract class BaseFrame extends JFrame{

    // Public constructor which passes the title of the baseFrame
    public BaseFrame(String title) {
        initialize(title);
    }

    // This method initializes the BaseFrame with multiple parameter of the window
    private void initialize(String title) {

        // Set the title of the baseFrame
        setTitle(title);

        // Set the size
        setSize(1080, 720);

        // Prevent the program to not fully close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set the layout for us to change each component style
        setLayout(null);

        // Make the window not resizable
        setResizable(false);

        // Make the position in the middle of the screen
        setLocationRelativeTo(null);

        // Add component in each different Gui
        addComponent();
    }

    // Abstract method to add different component from each Gui
    protected abstract void addComponent();
}