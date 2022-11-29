package login_system;

public class LoginPresenter {
    private AccountManager manager;
    private boolean checkUsername;
    private boolean checkPassword;
    public LoginPresenter(String username, String password){
        this.manager = new AccountManager();
        this.checkUsername = manager.checkUsername(username);
        this.checkPassword = manager.checkPassword(username, password);
    }

    public boolean getCheckUsername(){return this.checkUsername;}
    public boolean getCheckPassword(){return this.checkPassword;}
}
