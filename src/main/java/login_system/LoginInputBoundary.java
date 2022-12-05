package login_system;

import java.io.FileNotFoundException;

/**
 * The InputBoundary of the login system
 */
public interface LoginInputBoundary {
    /**
     * Return if the username and the password belong to an existing account in database
     * @param username: the username of the account
     * @param password: the password of the account
     * @return whether the username and password belong to a valid account
     * @throws FileNotFoundException
     */
    boolean login(String username, String password) throws FileNotFoundException;

    /**
     * Return if the username is a username of an existing account
     * @param username: the username of the account
     * @return whether the username belong to a valid account
     * @throws FileNotFoundException
     */
    boolean check(String username) throws FileNotFoundException;

    /**
     * Add a new account to the database
     * @param username: the username of the new account
     * @param password: the password of the new account
     */
    void register(String username, String password);


    void logout();
}
