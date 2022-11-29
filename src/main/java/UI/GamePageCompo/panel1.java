package UI.GamePageCompo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class panel1 extends JPanel {
    public panel1() throws IOException{
        this.setLayout(null);

        BufferedImage hp1 = ImageIO.read(new File("src/main/resource/health.png"));
        Image hp2 = hp1.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JLabel hp = new JLabel(new ImageIcon(hp2));
        hp.setBounds(50,460,70,70);

        BufferedImage p1 = ImageIO.read(new File("src/main/resource/default.png"));
        Image p2 = p1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel player = new JLabel(new ImageIcon(p2));
        player.setBounds(50,540,150,150);

        BufferedImage ch = ImageIO.read(new File("src/main/resource/chief.png"));
        Image ch1 = ch.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JLabel chief = new JLabel(new ImageIcon(ch1));
        chief.setBounds(230,540,70,70);

        JLabel health = new JLabel("4");
        health.setForeground(Color.black);
        health.setFont(new Font("Calibri", Font.BOLD, 30));
        health.setBounds(130, 480, 150, 40);

        JLabel side = new JLabel("Criminal");
        side.setForeground(Color.black);
        side.setFont(new Font("Calibri", Font.BOLD, 20));
        side.setBounds(230, 620, 150, 40);

        JLabel name = new JLabel("Player1");
        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setBounds(80, 700, 150, 40);

        this.add(hp);
        this.add(player);
        this.add(chief);
        this.add(health);
        this.add(side);
        this.add(name);

        JButton use = new JButton("use");
        use.setBounds(380,710,80,40);

        JButton discard = new JButton("discard");
        discard.setBounds(530,710,80,40);

        JButton end = new JButton("end");
        end.setBounds(680,710,80,40);

        JButton show = new JButton("see card");
        show.setBounds(830,710,80,40);

        BufferedImage car1 = ImageIO.read(new File("src/main/resource/car50.png"));
        Image car2 = car1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel car = new JLabel(new ImageIcon(car2));
        car.setBounds(1170,550,150,150);


        BufferedImage mg1 = ImageIO.read(new File("src/main/resource/mg50.png"));
        Image mg2 = mg1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel mg = new JLabel(new ImageIcon(mg2));
        mg.setBounds(1300,550,150,150);

        this.add(use);
        this.add(discard);
        this.add(end);
        this.add(mg);
        this.add(car);
        this.add(show);

        use.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionHandlers.handleUse();
            }
        });

        discard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionHandlers.handleDiscard();
            }
        });

        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionHandlers.handleEnd();
            }
        });



        JComboBox<String> cards = new JComboBox<>();
        ArrayList<String> deck = new ArrayList<>();
        deck.add("Shoot");
        deck.add("Dodge");
        deck.add("PoliceRaid");
        for (String s : deck) {
            cards.addItem(s);}
        cards.setBounds(400, 500,200,200);

        JLabel yourd = new JLabel("Your Deck:");
        yourd.setForeground(Color.white);
        yourd.setFont(new Font("Calibri", Font.BOLD, 20));
        yourd.setBounds(400, 540, 200, 40);

        JComboBox<String> players = new JComboBox<>();
        ArrayList<String> plist = new ArrayList<>();
        plist.add("Player2");
        plist.add("Player3");
        plist.add("Player4");
        plist.add("Player5");
        for (String s : plist) {
            players.addItem(s);}
        players.setBounds(620, 500,200,200);

        JLabel choose = new JLabel("Play on:");
        choose.setForeground(Color.white);
        choose.setFont(new Font("Calibri", Font.BOLD, 20));
        choose.setBounds(620, 540, 200, 40);

        BufferedImage carddis = ImageIO.read(new File("src/main/resource/shoot.png"));
        Image carddis1 = carddis.getScaledInstance(200, 270, Image.SCALE_SMOOTH);
        JLabel carddis2 = new JLabel(new ImageIcon(carddis1));
        carddis2.setBounds(850,400,200,270);

        BufferedImage logo = ImageIO.read(new File("src/main/resource/logo.png"));
        Image logo1 = logo.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
        JLabel logof = new JLabel(new ImageIcon(logo1));
        logof.setBounds(0,0,300,150);
        this.add(logof);

        this.add(cards);
        this.add(players);
        this.add(yourd);
        this.add(choose);
        this.add(carddis2);

    }
}
