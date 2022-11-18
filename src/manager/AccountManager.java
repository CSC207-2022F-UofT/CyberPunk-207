package manager;

import java.util.HashMap;
import entity.Account;

public class AccountManager {
    private HashMap<String, Account> accounts = new HashMap<>();
    public AccountManager(){

    }
    public boolean login(String username, String password){
        if (accounts.containsKey(username)){
            if(accounts.get(username).getPassword().equals(password)) {
                System.out.println("SUCCESSFUL LOG IN");
                return true;
            }
            else {
                System.out.println("WRONG PASSWORD");
                return false;
            }
        }
        else{
            System.out.println("WRONG USERNAME");
            return false;
        }
    }

}
