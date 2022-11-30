package login_system.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private int win;


    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.win = 0;
    }

    public String getPassword() {return this.password;}

    public String getUsername() {return username;}


    @Override
    public String toString(){
        return "Account{" + "username: " + username + ", password: " + password + ", win: " + win + "}";
    }

}
