package login_system.usecase;

import java.util.HashMap;
import login_system.entity.Account;

public class AccountManager {
    private HashMap<String, String> accounts = new HashMap<>();
    private final String FILENAME = "src/main/resource/Accounts.txt";
    private IAccountDataManager adm;
    public AccountManager(){

    }
//    public boolean login(String username, String password){
//        if (accounts.containsKey(username)){
//            if(accounts.get(username).getPassword().equals(password)) {
//                System.out.println("SUCCESSFUL LOG IN");
//                return true;
//            }
//            else {
//                System.out.println("WRONG PASSWORD");
//                return false;
//            }
//        }
//        else{
//            System.out.println("WRONG USERNAME");
//            return false;
//        }
//    }

}
