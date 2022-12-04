package login_system;

/**
 * The OutputBoundary of the login system
 */
public interface LoginOutputBoundary {

    void noAccount();

    void wrongPassword();

    void registerSuccess();

    void loginSuccess();


}
