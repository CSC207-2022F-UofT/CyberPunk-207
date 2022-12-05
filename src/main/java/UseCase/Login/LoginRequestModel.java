package UseCase.Login;

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
