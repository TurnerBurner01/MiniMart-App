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

    public LoginModel() {
        // Adding user details to the Map
        userDetails.put("admin", "xxx");
        userDetails.put("Joshua", "123");
        userDetails.put("James", "456");
        userDetails.put("John", "789");
    }

    /**
     *checkLogin()
     * This method is called in the Login View class and is passed
     * @param username
     * @param password
     * @return
     */
    public boolean checkLogin(String username, String password) {
        // Check if the username exists and if the password matches
        return userDetails.containsKey(username) && userDetails.get(username).equals(password);
    }
}
