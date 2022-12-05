package login_system.usecase;

import login_system.entity.Account;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * The interface of the gateway to interact with the database
 */
public interface IAccountDataManager{
    /**
     * Get accounts from the database and return a list of accounts of Class Account
     * @return A list of accounts of Class Account
     * @throws FileNotFoundException
     */
    List<Account> getAccounts() throws FileNotFoundException;

    /**
     * Restore input account in the database
     * @param account: the new account which need to be added in the database
     */
    void newAccount(Account account);
}
