package UseCase.Login;

import UseCase.Login.LoginOutputBoundary;

import javax.swing.*;

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
        LoginViewModel.getInstance().updateView(loginResponseModel.getLogin(), loginResponseModel.getMessage());
        UI.viewLogin(LoginViewModel.getInstance());
    }
}
