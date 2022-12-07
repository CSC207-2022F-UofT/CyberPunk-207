package UseCase.LoginSystem;

import UseCase.Login.LoginRequestModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class LoginRequestModelTest {
    LoginRequestModel a = new LoginRequestModel(true, "Sandy", "123895128");

    @Test
    @DisplayName("Test getRegister")
    public void testGetRegister(){
        Assertions.assertEquals(true, a.getRegister());}

    @Test
    @DisplayName("Test getUserID")
    public void testGetUserID(){
        Assertions.assertEquals("Sandy", a.getUserID());}

    @Test
    @DisplayName("Test getPassword")
    public void testGetPassword(){
        Assertions.assertEquals("123895128", a.getPassword());}

}
