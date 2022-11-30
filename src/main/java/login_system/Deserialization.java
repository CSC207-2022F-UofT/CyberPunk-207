package login_system;
import java.io.*;
import java.util.HashMap;

public class Deserialization{
    public HashMap<String, Account> read(String filename){
            try {
                // Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                // Method for deserialization of object
                HashMap<String, Account> accounts = (HashMap<String, Account>)in.readObject();

                in.close();
                file.close();

                return accounts;

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }
}

