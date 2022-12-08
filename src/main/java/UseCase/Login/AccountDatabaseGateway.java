package UseCase.Login;

import entity.Account;

import java.io.FileNotFoundException;
import java.util.List;

public interface AccountDatabaseGateway {

    List<Account> getAccounts();

    void newAccount(Account account);
}
