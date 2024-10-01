import javax.swing.SwingUtilities;

import Gui.LoginPage;
import Gui.RegisterPage;

public class AppLauncher {
        public static void main(String[] args) {

            // use InvokeLater to make update to the gui more thread safe
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Launch the first Gui
                    // new LoginPage().setVisible(true);
                    new RegisterPage().setVisible(true);
                }
            });
        }
}