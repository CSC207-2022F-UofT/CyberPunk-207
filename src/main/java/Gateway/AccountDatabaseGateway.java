package Gateway;

import entity.Account;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Account Database gateway, containing methods including get accounts and add new accounts from and towards database
 * Implemented by AccountDataBase class
 **/
public interface AccountDatabaseGateway {

    /**
     * Get accounts from database
     * @return list of accounts
     **/
    List<Account> getAccounts();

    /**
     * Write new account into database
     * @param account The new account to be added
     **/
    void newAccount(Account account);
}
