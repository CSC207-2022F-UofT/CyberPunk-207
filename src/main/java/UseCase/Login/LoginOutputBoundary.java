package UseCase.Login;

/**
 *An output boundary interface contains display login being implemented by presenter.
 **/
public interface LoginOutputBoundary {

    /**
     * Transmit all information of login or register result (represented by login response model) to UI.
     * @param loginResponseModel a response model
     **/
    void displayLogin(LoginResponseModel loginResponseModel);

}
