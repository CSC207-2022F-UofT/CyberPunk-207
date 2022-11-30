package UI;

import login_system.LoginController;
import login_system.LoginInputBoundary;
import login_system.LoginOutputBoundary;
import login_system.LoginPresenter;
import login_system.usecase.AccountDataManager;
import login_system.usecase.AccountManager;
import login_system.usecase.IAccountDataManager;
import manager.OutputBoundary;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage {
    public void init() throws IOException{
        JFrame lpage = new JFrame("Login Page");
        lpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lpage.setSize(1920,1080);
        lpage.setLocationRelativeTo(null);

        JPanel container = new JPanel();
        container.setLayout(null);
        lpage.setContentPane(container);

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
        login.setBounds(650,600,200,40);

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter();
        IAccountDataManager accountDataManager = new AccountDataManager();
        LoginInputBoundary loginInputBoundary = new AccountManager(accountDataManager, loginOutputBoundary);
        LoginController controller = new LoginController(loginInputBoundary);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usnm.getText();
                String pass = pswd.getText();
                boolean login = false;
                try {
                    login = controller.login(user, pass);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);// how to handle?
                }

                if(login){
                    lpage.setVisible(false);
                    try {new RulePage().init();} catch (IOException ex) {
                        throw new RuntimeException(ex);}
                } else if (!login) {
                   lpage.setVisible(false);
                    try {new RulePage().init();
                    } catch (IOException ex) {throw new RuntimeException(ex);}
                }
               else{error.setVisible(true);}
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
        container.add(login);
        container.add(myLabel);
        lpage.setVisible(true);
    }

    public static void main(String[] args) throws IOException{ new LoginPage().init();}
}
