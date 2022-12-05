package UseCase.Login;

import java.io.FileNotFoundException;

public class LoginController {
        private final LoginInputBoundary loginInputBoundary;

        public LoginController(LoginInputBoundary loginInputBoundary) {
            this.loginInputBoundary = loginInputBoundary;
        }

        public void userJoin(Boolean register, String username, String password){
            loginInputBoundary.userJoin(new LoginRequestModel(register, username, password));
        }

}
