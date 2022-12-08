package UseCase.Login;

import UseCase.Login.LoginOutputBoundary;

import javax.swing.*;

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
