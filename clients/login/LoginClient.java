package clients.login;

import javax.swing.*;

/**
 * LoginClient
 * This class is where all the login validation and GUI is stored
 * The Method displayGUI() is called in main to start up the interface and system
 */

public class LoginClient {
    public static void main(String[] args) {
        displayGUI();
        }

        private static void displayGUI () {
            JFrame window = new JFrame("Login");
            window.setTitle("Login Page");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LoginView view = new LoginView( window, 0, 0);

            window.setVisible(true);
    }

}
