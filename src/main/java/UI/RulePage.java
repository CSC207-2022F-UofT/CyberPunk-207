package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RulePage {
    private JFrame frame;

    public void init() throws IOException {
        JFrame frame = new JFrame("Rule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);

        JPanel pan = new JPanel();
        pan.setLayout(null);
        frame.setContentPane(pan);

        BufferedImage bg = ImageIO.read(new File("src/main/resource/rulesbg.jpg"));
        JLabel myLabel = new JLabel(new ImageIcon(bg));
        myLabel.setSize(1920,1080);

        BufferedImage rules = ImageIO.read(new File("src/main/resource/rules.png"));
        JLabel myLabel1 = new JLabel(new ImageIcon(rules));
        myLabel1.setBounds(200,5,1000,700);
        myLabel.add(myLabel1);

        JButton cont = new JButton("continue");
        cont.setBounds(700,710,100,50);
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                try {
                    new GamePage();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        pan.add(cont);
        pan.add(myLabel);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        new RulePage().init();
    }
}
