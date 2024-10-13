package library_management;

import javax.swing.SwingUtilities;

import library_management.Gui.LibraryApp;
import library_management.Gui.LoginPage;
import library_management.Obj.Permission;
import library_management.Obj.User;

public class AppLauncher {
        public static void main(String[] args) {

            // use InvokeLater to make update to the gui more thread safe
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //new LoginPage().setVisible(true);
                    new LibraryApp("Library_management app", new User(0, "Jonathan", null, null, null, Permission.Admin, null)).setVisible(true);
                }
            });
        }
}