package login_system.usecase;

import java.io.*;
import java.util.HashMap;

public interface IAccountDataManager {

    HashMap<String, String> getAccounts();

    void writeAccount();


}
