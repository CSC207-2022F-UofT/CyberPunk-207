package login_system;
import java.io.Serializable;
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int wins;
    private int loses;
    private int win_rate;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.wins = 0;
        this.loses = 0;
        this.win_rate = 0;
    }

    public String getPassword() {
        return this.password;
    }

    public void updateRecord(Boolean win) {
        if (win) {
            wins += 1;
        }
    }

    public int getWins(){return this.wins;}

}
