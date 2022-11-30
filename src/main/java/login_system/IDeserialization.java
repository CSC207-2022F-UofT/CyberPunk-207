package login_system;

import java.util.HashMap;

public interface IDeserialization {
    public HashMap<String, Account> read(String filename);
}
