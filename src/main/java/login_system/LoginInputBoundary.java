package login_system;

import java.io.FileNotFoundException;

public interface LoginInputBoundary {

    boolean login(String username, String password) throws FileNotFoundException;

    boolean check(String username) throws FileNotFoundException;

    void register(String username, String password);

    void logout();
}
