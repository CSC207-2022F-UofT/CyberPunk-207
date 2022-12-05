package UseCase.Login;

import entity.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDataBase implements AccountDatabaseGateway {
    private List<Account> accounts;


    @Override
    public List<Account> getAccounts(){
        try {
            FileInputStream f = new FileInputStream("Accounts.sav");
            ObjectInputStream inputStream = new ObjectInputStream(f);
            accounts = (List<Account>) inputStream.readObject();
            f.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            new File("Accounts.sav");
            accounts = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        return accounts;

    }

    @Override
    public void newAccount(Account account){
        accounts.add(account);
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
