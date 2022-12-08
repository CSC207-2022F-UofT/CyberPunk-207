package UseCase.Login;

import UseCase.EndTurn.EndTurnViewModel;

public class LoginViewModel {

    private static LoginViewModel instance;
    private Boolean isLogin;

    private String message;

    public static LoginViewModel getInstance(){
        if(instance == null){
            instance = new LoginViewModel();
        }
        return instance;
    }


    public void updateView(Boolean isLogin, String message) {
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
