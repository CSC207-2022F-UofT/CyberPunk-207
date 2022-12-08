package UseCase.Login;

/**
 * Login use case's controller.
 **/
public class LoginController {
    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary) {
            this.loginInputBoundary = loginInputBoundary;
        }

    /**
     * Let input boundary handle a log-in or register request, by creating a new login request model incorporating all information
     * @param register A boolean instance of whether requesting register
     * @param username A string instance of the username input
     * @param password A string instance of the password input
     **/
    public void userJoin(Boolean register, String username, String password){
        loginInputBoundary.userJoin(new LoginRequestModel(register, username, password));
    }

}
