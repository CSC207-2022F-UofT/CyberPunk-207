package login_system.usecase;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;

import login_system.LoginInputBoundary;
import login_system.LoginOutputBoundary;
import login_system.entity.Account;

/**
 * Implements the Interface LoginInputBoundary
 */
public class AccountManager implements LoginInputBoundary {

    private HashMap<String, String> accounts = new HashMap<>();
    private final String FILENAME = "src/main/resource/Accounts.txt";
    private IAccountDataManager accountDataManager;
    private LoginOutputBoundary loginOutputBoundary;

    /**
     * Construct the AccountManger
     * @param accountDataManager: the Account Data Manager of the login system
     * @param loginOutputBoundary: the OutputBoundary of the login system
     */
    public AccountManager(IAccountDataManager accountDataManager, LoginOutputBoundary loginOutputBoundary){
        this.accountDataManager = accountDataManager;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    /**
     * Returns true if the input username is the username of an existing account
     * @param username: the input username of the account
     * @return whether the input username is a username of a valid account
     * @throws FileNotFoundException
     */
    public boolean hasAccount(String username) throws FileNotFoundException {
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getUsername(), username)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the input password is the password of an existing account
     * @param password: the input password of the account
     * @return whether the input password is a password of a valid account
     * @throws FileNotFoundException
     */
    public boolean correctPassword(String password) throws FileNotFoundException {
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getPassword(), password)){
                return true;
            }
        }
        return false;
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

    @Override
    public boolean check(String username) throws FileNotFoundException {
        return hasAccount(username);
    }

    @Override
    public void register(String username, String password) {
        Account account = new Account(username, password);
        accountDataManager.newAccount(account);
    }

    @Override
    public void logout() {
//TODO
    }
}
