package login_system;

import java.util.ArrayList;
import java.util.HashMap;
import login_system.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountManager {

    private HashMap<String, Account> accounts;
    public void getAccounts(IDeserialization deserialization) {
        String filename = "src/main/resource/Accounts.txt";
        this.accounts = deserialization.read(filename);
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }

    public void addAccount(String username, String password){
        accounts.put(username, new Account(username, password));
        Serialization serialize = new Serialization(accounts);
        serialize.write();
    }

//    public void getAccount(String filename) throws FileNotFoundException {
//        File myAccounts = new File(filename);
//        Scanner myReader = new Scanner(myAccounts);
//        while (myReader.hasNextLine()) {
//            String data = myReader.nextLine();
//            String result[] = data.split(",");
//            accounts.put(result[0], new Account(result[0], result[1]));
//        }
//        myReader.close();
//    }

//    public String login(String username, String password){
//        if (accounts.containsKey(username)){
//            if(accounts.get(username).getPassword().equals(password)) {
//                return "SUCCESSFUL LOG IN";
//            }
//            else {
//                return "WRONG PASSWORD";
//            }
//        }
//        else{
//            return "WRONG USERNAME";
//        }
//    }
    //check username
    public boolean checkUsername(String username){
        return accounts.containsKey(username);
    }
    //check username and password
    public boolean checkPassword(String username, String password){
            if (accounts.get(username).equals(password)) {
                return true;
            }
            else{
                return false;
            }


    }
    //create account


}
