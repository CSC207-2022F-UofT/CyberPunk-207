public class Account {
    private String username;
    private String password;
    private int wins;
    private int loses;
    private int win_rate;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.wins = 0;
    }

    public String getPassword() {
        return this.password;
    }
}
