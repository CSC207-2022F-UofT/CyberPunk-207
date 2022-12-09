package UseCase.LoginSystem;

import Database.AccountDataBase;
import entity.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class AccountDataBaseTest {
    AccountDataBase dataManager = new AccountDataBase();
    Account account1 = new Account("SpongeBob", "1357924680");
    Account account2 = new Account("PatrickStar", "1234567890");
    List<Account> lst1 = new ArrayList<>();
    List<Account> lst2 = new ArrayList<>();


    @Test
    @DisplayName("Test getAccounts and newAccount")
    @org.junit.Test
    public void testGetAccountAndNewAccount() {
        lst1.add(account1);
        lst1.add(account2);
        dataManager.newAccount(account1);
        dataManager.newAccount(account2);
        List<Account> lst2 = new ArrayList<>(dataManager.getAccounts());
        Assertions.assertEquals(lst1.get(0).getUsername(),lst2.get(0).getUsername());
        Assertions.assertEquals(lst1.get(0).getPassword(),lst2.get(0).getPassword());
        Assertions.assertEquals(lst1.get(1).getUsername(),lst2.get(1).getUsername());
        Assertions.assertEquals(lst1.get(1).getPassword(),lst2.get(1).getPassword());
    }
}