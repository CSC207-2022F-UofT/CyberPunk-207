package login_system;

import java.io.FileNotFoundException;

public class LoginController {
    private String username;
    private String password;
    private AccountManager manager;

    public LoginController(AccountManager manager) throws FileNotFoundException {
        this.manager = manager;
    }

//    public String login(String username, String password) {
//        if(manager.login(username, password).equals("SUCCESSFUL LOG IN")){
//            //TODO: asd
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
