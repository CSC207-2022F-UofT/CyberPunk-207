package login_system;

import java.util.HashMap;
import login_system.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountManager {

    private HashMap<String, Account> accounts = new HashMap<>();
    public AccountManager(){
    }
    public void getAccount(String filename) throws FileNotFoundException {
        File myAccounts = new File(filename);
        Scanner myReader = new Scanner(myAccounts);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String result[] = data.split(",");
            accounts.put(result[0], new Account(result[0], result[1]));
        }
        myReader.close();
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
