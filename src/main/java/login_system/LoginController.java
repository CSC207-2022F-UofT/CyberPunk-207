package login_system;

import login_system.usecase.AccountManager;

import java.io.FileNotFoundException;

public class LoginController {
        private String username;
        private String password;
        private final LoginInputBoundary loginInputBoundary;

        public LoginController(LoginInputBoundary loginInputBoundary) {
            this.loginInputBoundary = loginInputBoundary;
        }

        public void login(String username, String password) throws FileNotFoundException {
            loginInputBoundary.login(username, password);
        }
        public void register(String username, String password){
            loginInputBoundary.register(username, password);
        }

        public void logout(){loginInputBoundary.logout();
        }
}
