package UI;

import javax.swing.*;

public class LoginPage {
    public static void main(String[] args) {
        JFrame lpage = new JFrame("Login Page");
        lpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lpage.setSize(1920,1080);
        lpage.setVisible(true);

        JPanel container = new JPanel();
        container.setLayout(null);
        lpage.setContentPane(container);

        JLabel username = new JLabel("Username");
        username.setBounds(550, 300, 80, 25);

        JTextField usnm = new JTextField(20);
        usnm.setBounds(750, 300, 200, 25);

        JLabel password = new JLabel("Password");
        password.setBounds(550,400, 80, 25);

        JTextField pswd = new JTextField(20);
        pswd.setBounds(750, 400, 200, 25);


        JButton login = new JButton("Login");
        login.setBounds(500,600,200,40);

        JButton register = new JButton("Register");
        register.setBounds(800,600,200,40);

        container.add(username);
        container.add(usnm);
        container.add(password);
        container.add(pswd);
        container.add(login);
        container.add(register);
    }

}
