package UseCase.Login;

/**
 *An input boundary interface contains methods handling login or registering request, implemented by AccountManager class.
 **/
public interface LoginInputBoundary {
    /**
     * Handle login request input via request model.
     * If the request is to register account, register.
     * Then identify whether log in is successful based on username and password of request model, send corresponding message to output boundary
     * @param loginRequestModel A login request model input, including whether the user want to register, username input and password input
     **/
    void userJoin(LoginRequestModel loginRequestModel);
}
