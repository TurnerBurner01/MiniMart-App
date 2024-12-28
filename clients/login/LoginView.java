package clients.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginView
 *
 * The Login View class is where the GUI is created and all the necessary assets are added
 */
public class LoginView {

    private static final int H = 300;
    private static final int W = 400;

    private final JLabel        pageTitle = new JLabel();
    private final JTextField    usernameInput = new JTextField();
    private final JTextField    passwordInput = new JTextField();
    private final ImageIcon     logo = new ImageIcon("images/Logo.jpg");
    private final JButton       loginButton = new JButton("Sign In");
    private final LoginModel    loginModel = new LoginModel();
    private LoginListener       listener;

    public interface LoginListener {
        void onLoginSuccess();
    }

    public LoginView (RootPaneContainer rpc, int x, int y) {

        Container cp = rpc.getContentPane();
        Container rootWindow = (Container) rpc;
        cp.setLayout(null);

        rootWindow.setSize( W, H);

        // Add the page title
        pageTitle.setBounds(150, 0, 270, 20);
        pageTitle.setText("Login Page");
        cp.add(pageTitle);

        // Add the username input
        usernameInput.setBounds(135, 150, 100, 20);
        cp.add(usernameInput);

        // Add the password input
        passwordInput.setBounds(135, 180, 100, 20);
        cp.add(passwordInput);

        // Resize the logo
        Image scaledImage = logo.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH); // Resize to 100x100
        ImageIcon resizedLogo = new ImageIcon(scaledImage);

        // Add the Logo
        JLabel logoLabel = new JLabel(resizedLogo);
        logoLabel.setBounds(110, 30, 150, 100);
        cp.add(logoLabel);

        // Add the login button
        loginButton.setBounds(135,210,100,25);
        cp.add(loginButton);

        // Add action listener for button click
        loginButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               validateLogin();
           }
        });
    }

    /**
     * validateLogin()
     * This method is where the View class gathers the details inputted and passes it on to the Login Model class to be checked
     */
    private void validateLogin() {
        String username = usernameInput.getText().trim();
        String password = passwordInput.getText().trim();

        // Use's LoginModel checkLogin() method and passes the username and password
        if (loginModel.checkLogin(username, password)) {

            // Debug to check if the username and password went through
            System.out.println("Login Successful " + username + " " + password);

            // Notify listener login has been validated
            if (listener != null) {
                listener.onLoginSuccess();
            }
        } else {
            System.out.println("Login Failed " + username + " " + password);
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * setLoginListener()
     * This method is used to set the listener
     * @param listener
     */
    public void setLoginListener(LoginListener listener) {
        this.listener = listener;
    }
}

