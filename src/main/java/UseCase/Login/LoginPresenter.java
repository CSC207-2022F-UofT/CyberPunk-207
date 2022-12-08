package UseCase.Login;



public class LoginPresenter implements LoginOutputBoundary {
    private LoginUpdatable UI;

    public LoginPresenter(LoginUpdatable UI) {
        this.UI = UI;
    }
    @Override
    public void displayLogin(LoginResponseModel loginResponseModel) {
        UI.viewLogin(loginResponseModel);
    }
}
