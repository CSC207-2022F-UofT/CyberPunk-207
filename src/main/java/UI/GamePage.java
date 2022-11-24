package UI;

import javax.swing.*;
import java.awt.*;

public class GamePage {
    public void init(){
        JFrame frame = new JFrame("Cyberpunk 207");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.cyan);
    }

    public static void main(String[] args) {new GamePage().init();}
}