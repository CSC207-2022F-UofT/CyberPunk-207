package LoginSystem;

import UseCase.Login.LoginResponseModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class LoginResponseModelTest {
    LoginResponseModel a = new LoginResponseModel(false,"This is a message.");

    @Test
    @DisplayName("Test getLogin")
    public void testGetLogin(){
        Assertions.assertEquals(false, a.getLogin());}
    @Test
    @DisplayName("Test getMessage")
    public void testGetMessage(){
        Assertions.assertEquals("This is a message.", a.getMessage());}

}
