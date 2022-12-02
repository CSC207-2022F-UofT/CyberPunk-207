package UI.GamePageCompo;

import presenter.Presenter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OtherPlayers extends JPanel{

    private Presenter presenter;

    public OtherPlayers(Presenter pr) {
        presenter = pr;
    }

    private void addImageAt(String src, int x, int y, int width, int height) throws IOException {
        BufferedImage img = ImageIO.read(new File(src));
        Image scaleImage = img.getScaledInstance(width, height,Image.SCALE_DEFAULT);
        JLabel pic = new JLabel(new ImageIcon(scaleImage));
        pic.setBounds(x,y, 100, 100);
        this.add(pic);

    }

    public OtherPlayers() throws IOException {
        super();
        this.setLayout(null);
        this.setBackground(new Color(119, 101, 227));
        addImageAt( "src/main/resource/default.png", 50, 60, 90, 90);
        addImageAt("src/main/resource/health.png", -10, 60, 50,40);

        BufferedImage carddis = ImageIO.read(new File("src/main/resource/car50.png"));
        Image carddis1 = carddis.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel carddis2 = new JLabel(new ImageIcon(carddis1));
        carddis2.setBounds(160,120,50,50);
        this.add(carddis2);

        BufferedImage ch = ImageIO.read(new File("src/main/resource/chief.png"));
        Image ch1 = ch.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel chief = new JLabel(new ImageIcon(ch1));
        chief.setBounds(160,60,50,50);
        this.add(chief);

        BufferedImage mg1 = ImageIO.read(new File("src/main/resource/mg50.png"));
        Image mg2 = mg1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel mg = new JLabel(new ImageIcon(mg2));
        mg.setBounds(220,120,50,50);
        this.add(mg);

        JLabel health = new JLabel("4");
        health.setForeground(Color.black);
        health.setFont(new Font("Calibri", Font.BOLD, 20));
        health.setBounds(35, 50, 150, 40);
        this.add(health);

        JLabel name = new JLabel("Player");
        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setBounds(70, 150, 150, 40);
        this.add(name);

    }

}

