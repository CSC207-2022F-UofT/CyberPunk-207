package UseCase.Login;

import Gateway.AccountDatabaseGateway;
import entity.Account;

import java.util.HashMap;
import java.util.Objects;

/**
 * Account Manager use case containing a method handling log-in or register request through log in request model
 * If account is registered, add the new account into account database
 * Identify whether the log-in is successful and send corresponding output to output boundary
 **/
public class AccountManager implements LoginInputBoundary {
    private HashMap<String, String> accounts = new HashMap<>();
    private final String FILENAME = "src/main/resource/Accounts.txt";
    private AccountDatabaseGateway accountDataManager;
    private LoginOutputBoundary loginOutputBoundary;
    public AccountManager(AccountDatabaseGateway accountDataManager, LoginOutputBoundary loginOutputBoundary){
        this.accountDataManager = accountDataManager;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    /**
     * Handle login request input via request model.
     * If the request is to register account, register.
     * Then identify whether log in is successful based on username and password of request model, send corresponding message to output boundary
     * @param loginRequestModel A login request model input, including whether the user want to register, username input and password input
     **/
    @Override
    public void userJoin(LoginRequestModel loginRequestModel) {
        Boolean register = loginRequestModel.getRegister();
        String username = loginRequestModel.getUserID();
        String password = loginRequestModel.getPassword();
        if(register){
            register(username, password);
            loginOutputBoundary.displayLogin(new LoginResponseModel(true, "REGISTER SUCCESSFUL"));
            return;
        }
        login(username, password);
    }

    /**
     * A helper function identifying whether a username has already had account
     * @param username A string of username
     * @return boolean of whether a account under input username is registered
     **/
    public boolean hasAccount(String username){
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getUsername(), username)){
                return true;
            }
        }

        return false;
    }

    /**
     * A helper function identifying whether input password is correct
     * @param password A string of password
     * @return boolean of whether input password is equal to some password of other accounts
     **/
    public boolean correctPassword(String password){
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getPassword(), password)){
                return true;
            }
        }
        return false;
    }

    /**
     * A helper function identify whether input password is correct / wrong for the input username, or the username does not exist
     * Send corresponding message to output boundary
     * @param username A string of username
     * @param password A string of password
     **/
    public void login(String username, String password){
        if (hasAccount(username)){
            if(correctPassword(password)) {
                loginOutputBoundary.displayLogin(new LoginResponseModel(true, "SUCCESSFUL LOG IN"));
            } else {
                loginOutputBoundary.displayLogin(new LoginResponseModel(false, "WRONG PASSWORD"));
            }
        }else{
        loginOutputBoundary.displayLogin(new LoginResponseModel(false, "NO SUCH USER"));
        }
    }

    /**
     * A helper function registering a new account of username and password, and add this new account into account data manager
     * @param username A string of username
     * @param password A string of password
     **/
    public void register(String username, String password) {
        Account account = new Account(username, password);
        accountDataManager.newAccount(account);
    }

}
