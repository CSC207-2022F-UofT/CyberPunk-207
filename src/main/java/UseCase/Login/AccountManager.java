package UseCase.Login;

import entity.Account;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;

public class AccountManager implements LoginInputBoundary {
    private HashMap<String, String> accounts = new HashMap<>();
    private final String FILENAME = "src/main/resource/Accounts.txt";
    private AccountDatabaseGateway accountDataManager;
    private LoginOutputBoundary loginOutputBoundary;
    public AccountManager(AccountDatabaseGateway accountDataManager, LoginOutputBoundary loginOutputBoundary){
        this.accountDataManager = accountDataManager;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    public boolean hasAccount(String username){
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getUsername(), username)){
                return true;
            }
        }

        return false;
    }

    public boolean correctPassword(String password){
        for(Account account: accountDataManager.getAccounts()){
            if(Objects.equals(account.getPassword(), password)){
                return true;
            }
        }
        return false;
    }

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

    public void register(String username, String password) {
        Account account = new Account(username, password);
        accountDataManager.newAccount(account);
    }

}
