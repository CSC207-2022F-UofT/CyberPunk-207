package login_system;

import java.io.FileNotFoundException;

public class LoginController {
    private String username;
    private String password;
    private AccountManager manager;

    public LoginController() throws FileNotFoundException {
        this.manager = new AccountManager();
        manager.getAccount("src/main/resource/Accounts.txt");
    }

    public void login(String username, String password) {
        if(manager.login(username, password)){
            //TODO: asd
        }
    }
}
