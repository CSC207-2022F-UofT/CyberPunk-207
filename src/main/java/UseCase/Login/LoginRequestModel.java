package UseCase.Login;

/**
 * A request model of login, containing three attributes: username, password and a boolean type representing whether the user want to register a new account
 * Serve as input for user join method within input boundary
 **/
public class LoginRequestModel {
    private Boolean register;
    private String userID;
    private String password;

    public LoginRequestModel(Boolean register, String userID, String password) {
        this.register = register;
        this.userID = userID;
        this.password = password;
    }

    public Boolean getRegister() {
        return register;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }
}
