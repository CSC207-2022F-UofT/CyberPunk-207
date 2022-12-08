package UseCase.Login;

/**
 * An interface for UI to implement
 **/
public interface LoginUpdatable {

    /**
     * A viewer displaying all information of login results
     * @param loginResponseModel A response model containing all information of login results
     **/
    void viewLogin(LoginResponseModel loginResponseModel);
}
