package login_system.usecase;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;

import login_system.LoginInputBoundary;
import login_system.LoginOutputBoundary;
import login_system.entity.Account;

public class AccountManager implements LoginInputBoundary {
    private HashMap<String, String> accounts = new HashMap<>();
    private final String FILENAME = "src/main/resource/Accounts.txt";
    private IAccountDataManager accountDataManager;
    private LoginOutputBoundary loginOutputBoundary;
    public AccountManager(IAccountDataManager accountDataManager, LoginOutputBoundary loginOutputBoundary){
        this.accountDataManager = accountDataManager;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    @Override
    public boolean login(String username, String password) throws FileNotFoundException {
        if (hasAccount(username)){
            if(correctPassword(password)) {
                //System.out.println("SUCCESSFUL LOG IN");
                return true;
            } else {
                //System.out.println("WRONG PASSWORD");
                return false;
            }
        }
        //System.out.println("NO SUCH USER");
        return false;
    }

    public boolean hasAccount(String username) throws FileNotFoundException {
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getUsername(), username)){
                return true;
            }
        }
        return false;
    }

    public boolean correctPassword(String password) throws FileNotFoundException {
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getPassword(), password)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void register(String username, String password) {
        Account account = new Account(username, password);
        accountDataManager.newAccount(account);
    }

    @Override
    public void logout() {

    }
}
