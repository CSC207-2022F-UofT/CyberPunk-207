package UseCase.Login;

/**
 * A response model of login, containing login results (two attributes: isLogin (boolean) and message(string)
 * To be transmitted and viewed by UI
 **/
public class LoginResponseModel {
    private Boolean isLogin;

    private String message;

    public LoginResponseModel(Boolean isLogin, String message) {
        this.isLogin = isLogin;
        this.message = message;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public String getMessage() {
        return message;
    }
}
