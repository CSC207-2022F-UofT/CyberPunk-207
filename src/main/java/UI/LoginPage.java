package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginPage {
    public void init() throws IOException {
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
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                from loginsystem/usecase/accountdatamanager
//                if(use_case.check(usnm) == false){
//                    use_case.write(usnm,pswd);
//                    lpage.setVisible(false);
//                    new RulePage().init();
//                } else if (use_case.check(usnm) && use_case.verify(usnm, pswd)) {
//                    lpage.setVisible(false);
//                    new RulePage().init();
//                }
//                else{
//                }
                error.setVisible(true);
//                lpage.setVisible(false);
//                try {
//                    new RulePage().init();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
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

    public static void main(String[] args) throws IOException { new LoginPage().init();}
}
