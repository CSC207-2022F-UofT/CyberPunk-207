package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OtherPlayersPanel extends JPanel{

    private final JLabel name = new JLabel();
    private final JLabel health = new JLabel();

    private void addImageAt(String src, int x, int y, int width, int height){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(src));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        Image scaleImage = img.getScaledInstance(width, height,Image.SCALE_DEFAULT);
        JLabel pic = new JLabel(new ImageIcon(scaleImage));
        pic.setBounds(x,y, 100, 100);
        this.add(pic);

    }

    public OtherPlayersPanel(){
        super();
        this.setLayout(null);
        this.setBackground(new Color(119, 101, 227));
        addImageAt( "src/main/resource/default.png", 50, 60, 90, 90);
        addImageAt("src/main/resource/health.png", -10, 60, 50,40);

        BufferedImage car1 = null;
        try {
            car1 = ImageIO.read(new File("src/main/resource/car50.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        Image car2 = car1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel car3 = new JLabel(new ImageIcon(car2));
        car3.setBounds(160,120,50,50);
        this.add(car3);

        BufferedImage ch = null;
        try {
            ch = ImageIO.read(new File("src/main/resource/chief.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        Image ch1 = ch.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel chief = new JLabel(new ImageIcon(ch1));
        chief.setBounds(160,60,50,50);
        this.add(chief);

        BufferedImage mg1 = null;
        try {
            mg1 = ImageIO.read(new File("src/main/resource/mg50.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        Image mg2 = mg1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel mg = new JLabel(new ImageIcon(mg2));
        mg.setBounds(220,120,50,50);
        this.add(mg);

        health.setForeground(Color.black);
        health.setFont(new Font("Calibri", Font.BOLD, 20));
        health.setBounds(35, 50, 150, 40);
        this.add(health);

        JLabel name = new JLabel("PlayerJoin");
        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setBounds(70, 150, 150, 40);
        this.add(name);

        setVisible(true);
    }

    public void displayName(String name) {this.name.setText(name);}

    public void displayHealth(String hp) {this.health.setText(hp);}
}

