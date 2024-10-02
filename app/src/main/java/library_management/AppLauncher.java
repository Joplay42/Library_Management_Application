package library_management;

import javax.swing.SwingUtilities;

<<<<<<< HEAD
import library_management.Gui.LibraryApp;
import library_management.Gui.LoginPage;
import library_management.Obj.Permission;
import library_management.Obj.User;
=======
import library_management.Gui.RegisterPage;
>>>>>>> 282cc6f (Graddle build)

public class AppLauncher {
        public static void main(String[] args) {

            // use InvokeLater to make update to the gui more thread safe
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
<<<<<<< HEAD
                    new LoginPage().setVisible(true);
=======
                    // Launch the first Gui
                    // new LoginPage().setVisible(true);
                    new RegisterPage().setVisible(true);
>>>>>>> 282cc6f (Graddle build)
                }
            });
        }
}