package clients.setting;

import clients.login.LoginModel;
import middle.MiddleFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingView {

    private static final int H = 300;
    private static final int W = 400;

    private final JLabel pageTitle = new JLabel();
    private final JButton contactButton = new JButton("Contact Us");
    private final JButton paymentButton = new JButton("Payment");
    private final JButton profileButton = new JButton("Profile Details");


    public SettingView(RootPaneContainer rpc, MiddleFactory mf, int x, int y) {

        Container cp = rpc.getContentPane();
        Container rootWindow = (Container) rpc;
        cp.setLayout(null);

        // Size and location of window
        rootWindow.setSize(W, H);
        rootWindow.setLocation(x, y);

        // Add the page title
        pageTitle.setBounds(150, 0, 270, 20);
        pageTitle.setText("Settings Page");
        cp.add(pageTitle);

        // Add the contact button
        contactButton.setBounds(16, 25 + 60 * 0, 120, 40);
        cp.add(contactButton);

        // Add the payment button
        paymentButton.setBounds(16, 25 + 60 * 1, 120, 40);
        cp.add(paymentButton);

        // Add the profile button
        profileButton.setBounds(16, 25 + 60 * 2, 120, 40);
        cp.add(profileButton);

        // Add action listener for the profile button
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProfileDetailsWindow();
            }
        });

        // Add action listener for the payment button
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPaymentDetailsWindow();
            }
        });

    }

    /**
     * Open the profile details window.
     */
    private void openProfileDetailsWindow() {
        JFrame profileWindow = new JFrame("Profile Details");
        profileWindow.setSize(400, 300);
        profileWindow.setLocationRelativeTo(null);
        profileWindow.setTitle("Profile Details");

        // Get the user details from the LoginModel
        String username = LoginModel.getUsername();
        String password = LoginModel.getPassword();
        String paymentDetails = LoginModel.getPaymentDetails();

        // labels to display the details
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Username: " + username));
        panel.add(new JLabel("Password: " + password));
        panel.add(new JLabel("Payment Details: " + paymentDetails));

        profileWindow.add(panel);
        profileWindow.setVisible(true);
    }

    /**
     * Open the payment details window where the user can update their payment details.
     */
    private void openPaymentDetailsWindow() {
        // Create a window
        JFrame paymentWindow = new JFrame();
        paymentWindow.setSize(400, 200);
        paymentWindow.setLocationRelativeTo(null);
        paymentWindow.setTitle("Update Payment Details");

        // Get the current payment details
        String currentPaymentDetails = LoginModel.getPaymentDetails();

        // Create text field for the user input
        JTextField newPaymentDetailsField = new JTextField(currentPaymentDetails, 20);

        // Create button for the user to save changes
        JButton saveButton = new JButton("Save Changes");

        // ActionListener for the save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get the new payment details from the text field
                String newPaymentDetails = newPaymentDetailsField.getText();

                // Update the payment details in the LoginModel
                LoginModel.updatePaymentDetails(newPaymentDetails);

                // Close the payment window after saving
                paymentWindow.setVisible(false);

                // Display a message to let the user know it was successful
                JOptionPane.showMessageDialog(paymentWindow, "Payment details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Payment details updated successfully: " + newPaymentDetails);
            }
        });

        // Create a panel for the payment details window
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Current Payment Details: " + currentPaymentDetails));
        panel.add(new JLabel("New Payment Details:"));
        panel.add(newPaymentDetailsField);
        panel.add(saveButton);

        paymentWindow.add(panel);
        paymentWindow.setVisible(true);
    }
}
