package login_system;

public class LoginPresenter {
    private AccountManager manager;
    private boolean checkUsername;
    private boolean checkPassword;
    public LoginPresenter(AccountManager manager, String username, String password){
        this.manager = manager;
        this.checkUsername = manager.checkUsername(username);
        this.checkPassword = manager.checkPassword(username, password);
    }

    public boolean getCheckUsername(){return this.checkUsername;}
    public boolean getCheckPassword(){return this.checkPassword;}
}
