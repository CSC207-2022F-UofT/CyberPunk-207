package login_system.entity;

import java.io.Serializable;

/**
 * Class Account, represents accounts in the database
 */
public class Account implements Serializable {
    private String username;
    private String password;
    private int win;

    /**
     * Construct the Account
     *
     * @param username: the username of the account
     * @param password: the password of the account
     */
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.win = 0;
    }

    /**
     * Returns the password
     * @return password instance attributes
     */
    public String getPassword() {return this.password;}

    /**
     * Returns the username
     * @return username instance attributes
     */
    public String getUsername() {return username;}

    /**
     * Returns a string of username and password and the number of games wins of this account
     * @return String of username and password and the number of games wins of this account
     */
    @Override
    public String toString(){
        return "Account{" + "username: " + username + ", password: " + password + ", win: " + win + "}";
    }

}
