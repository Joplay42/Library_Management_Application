package library_management;

import javax.swing.SwingUtilities;
import java.time.LocalDate;

import library_management.Gui.LibraryApp;
import library_management.Gui.LoginPage;
import library_management.Obj.Permission;
import library_management.Obj.Transaction;
import library_management.Obj.User;

public class AppLauncher {
        public static void main(String[] args) {

            // use InvokeLater to make update to the gui more thread safe
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //new LoginPage().setVisible(true);
                    new LibraryApp("Library_management app", new User(1, "Jonathan", null, null, null, Permission.admin, null)).setVisible(true);
                }
            });
        }
}