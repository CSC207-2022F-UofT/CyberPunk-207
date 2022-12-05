package UI;

import UseCase.Login.*;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginFrame extends JFrame implements LoginUpdatable{

    private LoginController loginController;


    public LoginFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setLocationRelativeTo(null);

        JPanel container = new JPanel();
        container.setLayout(null);
        setContentPane(container);

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


        register.addActionListener(e -> {
            String user = usnm.getText();
            String pass = pswd.getText();
            loginController.userJoin(true, user, pass);

        });

        login.addActionListener(e -> {
            String user = usnm.getText();
            String pass = pswd.getText();
            loginController.userJoin(false, user, pass);
        });

        BufferedImage background = null;
        try {
            background = ImageIO.read(new File("src/main/resource/rulesbg.jpg"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert background != null;
        JLabel myLabel = new JLabel(new ImageIcon(background));
        myLabel.setSize(1920,1080);


        BufferedImage bg1 = null;
        try {
            bg1 = ImageIO.read(new File("src/main/resource/logo.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert bg1 != null;
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
        setVisible(true);
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }



    @Override
    public void viewLogin(LoginResponseModel loginResponseModel) {
        String msg = loginResponseModel.getMessage();
        JOptionPane.showMessageDialog(null, msg);
        if(loginResponseModel.getLogin()){
            setVisible(false);
        }
    }
}
