package login_system.usecase;

import login_system.entity.Account;

import java.io.FileNotFoundException;
import java.util.List;

public interface IAccountDataManager{

    List<Account> getAccounts() throws FileNotFoundException;

    void newAccount(Account account);
}
