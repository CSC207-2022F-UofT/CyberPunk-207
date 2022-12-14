package Database;

import Gateway.AccountDatabaseGateway;
import entity.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Account Database use case, containing methods including get accounts and add new accounts from and towards database
 **/
public class AccountDataBase implements AccountDatabaseGateway {
    private List<Account> accounts = new ArrayList<>();

    /**
     * Get accounts from database
     * @return list of accounts
     **/
    @Override
    public List<Account> getAccounts(){
        try {
            FileInputStream f = new FileInputStream("src/main/resource/Accounts.txt");
            ObjectInputStream inputStream = new ObjectInputStream(f);
            accounts = (List<Account>) inputStream.readObject();
            f.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            accounts = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            accounts = new ArrayList<>();
            System.out.println("An exception occurred: " + e.getMessage());
        }
        return accounts;

    }

    /**
     * Write new account into database
     * @param account The new account to be added
     **/
    @Override
    public void newAccount(Account account){
        try {
            FileOutputStream f = new FileOutputStream("src/main/resource/Accounts.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(f);
            accounts.add(account);
            outputStream.writeObject(accounts);
            f.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}

