package login_system;

import javax.swing.*;

/**
 * The presenter of the login system, Implements the LoginOutputBoundary
 */
public class LoginPresenter implements LoginOutputBoundary{
    @Override
    public void noAccount() {
        JOptionPane.showMessageDialog(null, "Account not registered");
    }

    @Override
    public void wrongPassword() {JOptionPane.showMessageDialog(null, "Wrong Password");
    }

    @Override
    public void registerSuccess() {JOptionPane.showMessageDialog(null, "Register successful");
    }

    @Override
    public void loginSuccess() {JOptionPane.showMessageDialog(null, "Login successful");
    }

}
