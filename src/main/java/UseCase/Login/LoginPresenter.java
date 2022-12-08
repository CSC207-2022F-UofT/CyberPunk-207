package UseCase.Login;

/**
 * Presenter of login use case which implements output boundary
 * Contain a method letting UI display the login or register result, incorporated in login response model
 **/
public class LoginPresenter implements LoginOutputBoundary {
    private LoginUpdatable UI;

    public LoginPresenter(LoginUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit all information of login or register result (represented by login response model) to UI.
     * @param loginResponseModel a response model
     **/
    @Override
    public void displayLogin(LoginResponseModel loginResponseModel) {
        UI.viewLogin(loginResponseModel);
    }
}
