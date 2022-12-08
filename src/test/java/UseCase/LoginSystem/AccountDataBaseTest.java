package UseCase.LoginSystem;

import UseCase.Login.AccountDataBase;
import entity.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AccountDataBaseTest {
    AccountDataBase dataManager = new AccountDataBase();
    Account account1 = new Account("SpongeBob", "1357924680");
    Account account2 = new Account("PatrickStar", "1234567890");

    @Test
    @DisplayName("Test getAccounts and newAccount")
    public void testGetAccountAndNewAccount() {
        dataManager.newAccount(account1);
        dataManager.newAccount(account2);
        Assertions.assertTrue(dataManager.getAccounts().contains(account1));
        Assertions.assertTrue(dataManager.getAccounts().contains(account2));
    }
}