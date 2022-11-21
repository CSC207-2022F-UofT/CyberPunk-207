package login_system;
public class Account {
    private String username;
    private String password;


    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {return this.password;}

    public String getUsername() {return username;}


}
