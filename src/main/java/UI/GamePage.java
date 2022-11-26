package UI;

import UI.GamePageCompo.OtherPlayers;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePage {
    public void init() throws IOException {
        JFrame frame = new JFrame("Cyberpunk 207");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(59, 96, 228));
        frame.setLayout(null);


        JPanel player1 = new OtherPlayers();
        frame.add(player1);
        player1.setBounds(30,250,300, 200);

        JPanel player2 = new OtherPlayers();
        frame.add(player2);
        player2.setBounds(360,20,300, 200);

        JPanel player3 = new OtherPlayers();
        frame.add(player3);
        player3.setBounds(800,20,300, 200);

        JPanel player4 = new OtherPlayers();
        frame.add(player4);
        player4.setBounds(1120,250,300, 200);


    }

    public static void main(String[] args) throws IOException {new GamePage().init();}
}