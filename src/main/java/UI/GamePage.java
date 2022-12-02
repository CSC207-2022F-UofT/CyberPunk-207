package UI;

import UI.GamePageCompo.OtherPlayers;
import UI.GamePageCompo.panel1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GamePage {

    OtherPlayers position1 = new OtherPlayers();
    OtherPlayers position2 = new OtherPlayers();
    OtherPlayers position3 = new OtherPlayers();
    OtherPlayers position4 = new OtherPlayers();


    public GamePage() throws IOException {
        JFrame frame = new JFrame("Cyberpunk 207");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);


        frame.add(position1);
        position1.setBounds(30,250,300, 200);


        frame.add(position2);
        position2.setBounds(360,20,300, 200);

        frame.add(position3);
        position3.setBounds(800,20,300, 200);

        frame.add(position4);
        position4.setBounds(1120,250,300, 200);

        JPanel us = new panel1();
        us.setBackground(new Color(59, 96, 228));
        frame.add(us);
        us.setBounds(0,400,1080,480);

        frame.setVisible(true);
    }


    public void displayOtherNames(List<String> names) {
        position1.displayName(names.get(0));
        position2.displayName(names.get(1));
        position3.displayName(names.get(2));
        position4.displayName(names.get(3));
    }

    public void displayHP(List<String> hps) {

    }
    public static void main(String[] args) throws IOException {new GamePage();}
}