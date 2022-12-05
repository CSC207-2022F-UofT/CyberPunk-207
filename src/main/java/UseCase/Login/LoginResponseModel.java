package UseCase.Login;

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
