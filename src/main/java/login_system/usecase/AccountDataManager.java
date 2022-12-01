package login_system.usecase;

import login_system.entity.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDataManager implements IAccountDataManager {
    private List<Account> accounts;


    @Override
    public List<Account> getAccounts(){
        try {
            FileInputStream f = new FileInputStream("Accounts.sav");
            ObjectInputStream inputStream = new ObjectInputStream(f);
            List<Account> accounts = (ArrayList<Account>) inputStream.readObject();
            f.close();
        } catch (FileNotFoundException e) {
            new File("Accounts.sav");
            List<Account> accounts = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);// unsolved, need to handle
        }
        return accounts;

    }

    @Override
    public void newAccount(Account account){
        try {
            FileOutputStream f = new FileOutputStream("Accounts.sav");
            ObjectOutputStream outputStream = new ObjectOutputStream(f);
            outputStream.writeObject(account);
        } catch (IOException e) {
            File f = new File("Accounts.sav");
            newAccount(account);
        }
    }

}
