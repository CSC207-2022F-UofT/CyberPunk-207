package UI;

import login_system.LoginController;
import login_system.LoginInputBoundary;
import login_system.LoginOutputBoundary;
import login_system.LoginPresenter;
import login_system.usecase.AccountDataManager;
import login_system.usecase.AccountManager;
import login_system.usecase.IAccountDataManager;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public void init() throws IOException{
        JFrame loginPage = new JFrame("Login Page");
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setSize(1920,1080);
        loginPage.setLocationRelativeTo(null);

        JPanel container = new JPanel();
        container.setLayout(null);
        loginPage.setContentPane(container);

        JLabel username = new JLabel("Username");
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Calibri", Font.BOLD, 20));
        username.setBounds(550, 400, 150, 25);

        JTextField usnm = new JTextField(20);
        usnm.setBounds(750, 400, 200, 25);

        JLabel password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Calibri", Font.BOLD, 20));
        password.setBounds(550,500, 150, 25);

        JTextField pswd = new JTextField(20);
        pswd.setBounds(750, 500, 200, 25);

        JLabel error = new JLabel("Wrong Password");
        error.setForeground(Color.WHITE);
        error.setFont(new Font("Calibri", Font.BOLD, 20));
        error.setBounds(650,550, 300, 25);
        container.add(error);
        error.setVisible(false);

        JButton login = new JButton("Login");
        login.setBounds(800,600,200,40);

        JButton register = new JButton("Register");
        register.setBounds(500,600,200,40);

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter();
        IAccountDataManager accountDataManager = new AccountDataManager();
        LoginInputBoundary loginInputBoundary = new AccountManager(accountDataManager, loginOutputBoundary);
        LoginController controller = new LoginController(loginInputBoundary);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usnm.getText();
                String pass = pswd.getText();
                controller.register(user, pass);
                loginOutputBoundary.registerSuccess();
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usnm.getText();
                String pass = pswd.getText();
                try {
                    if(!controller.check(user)){loginOutputBoundary.noAccount();
                    }
                    else if (!controller.login(user,pass)) {loginOutputBoundary.wrongPassword();
                    }
                    else{loginOutputBoundary.loginSuccess();
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        loginPage.setVisible(false);
                        new RulePage().init();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        BufferedImage bg = ImageIO.read(new File("src/main/resource/rulesbg.jpg"));
        JLabel myLabel = new JLabel(new ImageIcon(bg));
        myLabel.setSize(1920,1080);

        BufferedImage bg1 = ImageIO.read(new File("src/main/resource/logo.png"));
        JLabel myLabel1 = new JLabel(new ImageIcon(bg1));
        myLabel1.setBounds(350,0,750,390);
        myLabel.add(myLabel1);

        container.add(username);
        container.add(usnm);
        container.add(password);
        container.add(pswd);
        container.add(register);
        container.add(login);
        container.add(myLabel);
        loginPage.setVisible(true);
    }

    public static void main(String[] args) throws IOException{ new LoginPage().init();}
}
