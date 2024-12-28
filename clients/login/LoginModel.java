package clients.login;

import java.util.HashMap;
import java.util.Map;

/**
 * LoginModel
 * The login Model class is where all the logic and details are stored for profile validation
 * The logic is returned to the view where the GUI will update
 */

public class LoginModel {

    // Map - Stores multiple usernames and password pairs
    final Map<String, String> userDetails = new HashMap<>();
    static final Map<String, String> paymentDetails = new HashMap<>();


    // Variables to store the current logged-in user's details
    private static String currentUsername;
    private static String currentPassword;
    private static String currentPaymentDetails;

    public LoginModel() {
        // Adding user details to the Map
        userDetails.put("admin", "xxx");
        userDetails.put("Joshua", "123");
        userDetails.put("James", "456");
        userDetails.put("John", "789");

        // Adding payment details
        paymentDetails.put("admin", "Visa **** 1234");
        paymentDetails.put("Joshua", "Mastercard **** 5678");
        paymentDetails.put("James", "PayPal **** 9876");
        paymentDetails.put("John", "Visa **** 4321");
    }

    /**
     *checkLogin()
     * This method is called in the Login View class and checks the username and the password
     */
    public boolean checkLogin(String username, String password) {
        // Check if the username exists and if the password matches
        if (userDetails.containsKey(username) && userDetails.get(username).equals(password)) {
            // Set the current logged-in user's details
            currentUsername = username;
            currentPassword = password;
            currentPaymentDetails = paymentDetails.get(username);  // Get the payment details for this user
            return true;
        }
        return false;
    }

    public static String getUsername() {
        return currentUsername;
    }

    public static String getPassword() {
        return currentPassword;
    }

    public static String getPaymentDetails() {
        return currentPaymentDetails;
    }

    // Method to update the payment details for the logged-in user
    public static void updatePaymentDetails(String newPaymentDetails) {
        paymentDetails.put(currentUsername, newPaymentDetails);
        currentPaymentDetails = newPaymentDetails;  // Update the current payment details for the logged-in user
    }
}
