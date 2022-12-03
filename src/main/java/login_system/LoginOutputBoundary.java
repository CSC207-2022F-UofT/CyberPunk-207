package login_system;

public interface LoginOutputBoundary {

    void noAccount();

    void wrongPassword();

    void registerSuccess();

    void loginSuccess();


}
