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
            FileInputStream f = new FileInputStream("src/main/resource/Accounts.txt");
            ObjectInputStream inputStream = new ObjectInputStream(f);
            accounts = new ArrayList<>();
            accounts.addAll((List<Account>) inputStream.readObject());//zhelianghuang
            f.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            new File("/src/main/resource/Accounts.sav");
            accounts = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        return accounts;

    }

    @Override
    public void newAccount(Account account){
        getAccounts().add(account);
        try {
            FileOutputStream f = new FileOutputStream("Accounts.sav");
            ObjectOutputStream outputStream = new ObjectOutputStream(f);
            outputStream.writeObject(account);
        } catch (IOException e) {
            File f = new File("/src/main/resource/Accounts.sav");
            newAccount(account);
        }
    }

}
