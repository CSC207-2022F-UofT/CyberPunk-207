package login_system;
import java.io.*;
import java.util.HashMap;

public class Serialization {
    HashMap<String, Account> accounts;

    public Serialization(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }
    public void write(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/resource/Accounts.txt"));
            objectOutputStream.writeObject(this.accounts);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occurred");;
        }
    }
}
