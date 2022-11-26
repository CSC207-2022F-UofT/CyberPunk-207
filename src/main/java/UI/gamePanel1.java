package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class gamePanel1 {

    public void init() throws IOException {
        JFrame frame = new JFrame(" 207");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.black);

        JPanel pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBounds(0,600,1080,480);
        frame.setContentPane(pnl1);

        BufferedImage hp1 = ImageIO.read(new File("src/main/resource/health.png"));
        JLabel hp = new JLabel(new ImageIcon(hp1));
        hp.setBounds(50,610,70,70);

        BufferedImage p1 = ImageIO.read(new File("src/main/resource/default.png"));
        JLabel player = new JLabel(new ImageIcon(p1));
        player.setBounds(50,690,150,150);

        BufferedImage ch = ImageIO.read(new File("src/main/resource/health.png"));
        JLabel chief = new JLabel(new ImageIcon(ch));
        chief.setBounds(230,690,70,70);

        JLabel health = new JLabel("4");
        health.setForeground(Color.black);
        health.setFont(new Font("Calibri", Font.BOLD, 30));
        health.setBounds(130, 630, 150, 40);

        JLabel side = new JLabel("Criminal");
        side.setForeground(Color.black);
        side.setFont(new Font("Calibri", Font.BOLD, 20));
        side.setBounds(230, 770, 150, 40);

        JLabel name = new JLabel("Player1");
        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setBounds(50, 850, 150, 40);

        pnl1.add(hp);
        pnl1.add(player);
        pnl1.add(chief);
        pnl1.add(health);
        pnl1.add(side);
        pnl1.add(name);

        JButton use = new JButton("use");
        use.setBounds(380,960,80,40);

        JButton discard = new JButton("discard");
        discard.setBounds(580,960,80,40);

        JButton end = new JButton("end");
        end.setBounds(780,960,80,40);

        BufferedImage car1 = ImageIO.read(new File("src/main/resource/car1.png"));
        JLabel car = new JLabel(new ImageIcon(car1));
        car.setBounds(880,690,70,100);

        BufferedImage mg1 = ImageIO.read(new File("src/main/resource/mg.png"));
        JLabel mg = new JLabel(new ImageIcon(mg1));
        mg.setBounds(960,690,70,100);

        pnl1.add(use);
        pnl1.add(discard);
        pnl1.add(end);
        pnl1.add(mg);
        pnl1.add(car);

        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {new gamePanel1().init();}
}
