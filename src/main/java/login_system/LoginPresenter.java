package login_system;

import javax.swing.*;

public class LoginPresenter implements LoginOutputBoundary{
    @Override
    public void noAcc() {
        JOptionPane.showMessageDialog(null, "Account not registered");
    }

    @Override
    public void wrongPass() {JOptionPane.showMessageDialog(null, "Wrong Password");
    }

    @Override
    public void registerSucc() {JOptionPane.showMessageDialog(null, "Register successful");
    }

    @Override
    public void loginSucc() {JOptionPane.showMessageDialog(null, "Login successful");
    }

}
