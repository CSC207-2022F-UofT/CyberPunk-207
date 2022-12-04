package login_system;

import java.io.FileNotFoundException;

/**
 * The controller of the login system
 */
public class LoginController {
        private String username;
        private String password;
        private final LoginInputBoundary loginInputBoundary;

        /**
         * Construct a LoginController
         * @param loginInputBoundary: the InputBoundary of the login system
         */
        public LoginController(LoginInputBoundary loginInputBoundary) {
            this.loginInputBoundary = loginInputBoundary;
        }

        /**
         * Return if the input username and the input password belong to an exist account in database
         * @param username: the input username of the account
         * @param password: the input password of the account
         * @return whether the input username and input password belong to a valid account
         * @throws FileNotFoundException
         */
        public boolean login(String username, String password) throws FileNotFoundException {
            return loginInputBoundary.login(username, password);
        }

        /**
         * Return if the input username is a username of an existing account
         * @param username: the input username of the account
         * @return whether the username belong to a valid account
         * @throws FileNotFoundException
         */
        public boolean check(String username) throws FileNotFoundException {return loginInputBoundary.check(username);
        }

        /**
         * Add a new account with input username and input password to the database
         * @param username: the input username of the new account
         * @param password: the input password of the new account
         */
        public void register(String username, String password){
            loginInputBoundary.register(username, password);
        }

        public void logout(){loginInputBoundary.logout();
        }
}
