package UseCase.LoginSystem;

import entity.Account;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AccountTest {
    Account account = new Account("SpongeBob","1357924680");

    @Test
    @DisplayName("Test Get Password")
    public void testGetPassword(){
        Assertions.assertEquals("1357924680", account.getPassword());}


    @Test
    @DisplayName("Test Get Username")
    public void testGetUsername(){
        Assertions.assertEquals("SpongeBob", account.getUsername());}

    @Test
    @DisplayName("Test ToString")
    public void testToString(){
        Assertions.assertEquals("Account{" + "username: " + "SpongeBob" + ", password: " + "1357924680" + ", win: " + 0 + "}", account.toString());}
}