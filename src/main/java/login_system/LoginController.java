package login_system;

import java.io.FileNotFoundException;

public class LoginController {
        private String username;
        private String password;
        private final LoginInputBoundary loginInputBoundary;

        public LoginController(LoginInputBoundary loginInputBoundary) {
            this.loginInputBoundary = loginInputBoundary;
        }

        public boolean login(String username, String password) throws FileNotFoundException {
            return loginInputBoundary.login(username, password);
        }
        public void register(String username, String password){
            loginInputBoundary.register(username, password);
        }

        public void logout(){loginInputBoundary.logout();
        }
}
