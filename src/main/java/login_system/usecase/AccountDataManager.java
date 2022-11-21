package login_system.usecase;

import java.io.*;
import java.util.HashMap;

public class AccountDataManager implements IAccountDataManager{

    private String filename;

    public AccountDataManager(String filename) {
        this.filename = filename;
    }

    HashMap<String, String> pairs;

    @Override
    public HashMap<String, String> getAccounts() {
        HashMap<String, String> accounts;
        accounts = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                accounts.put(data[0], data[1]);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accounts;

    }

    @Override
    public void writeAccount() {

    }
}
