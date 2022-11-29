package login_system;

import java.io.FileNotFoundException;

public class LoginController {
    private String username;
    private String password;
    private AccountManager manager;

    public LoginController() {
        this.manager = new AccountManager();
    }
    public void addAccount(String username, String password){
        if (manager.checkUsername(username)) {
            manager.getAccounts().put(username, new Account(username, password));
            Serialization serialize = new Serialization(manager.getAccounts());
            serialize.write();
        }
    }

//    public String login(String username, String password) {
//        if(manager.login(username, password).equals("SUCCESSFUL LOG IN")){
//            //
//        } else if (manager.login(username, password).equals("WRONG PASSWORD")) {
//
//        }
//        else{
//
//        }
//    }

    public void quit() {
        Serialization serialize = new Serialization(manager.getAccounts());
        serialize.write();
        System.out.println("LOG OUT");
    }
}
