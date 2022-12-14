package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class that sets up the other players' panel on the GameFrame
 */
public class OtherPlayersPanel extends JPanel{

    private final JLabel name = new JLabel();
    private final JLabel health = new JLabel();

    private JLabel mg = new JLabel();

    private JLabel carPlus = new JLabel();

    private JLabel carMinus = new JLabel();

    /**
     * method to add an image on the panel
     * @param src file path of the image
     * @param x image position on x-axis of the panel in pixels
     * @param y image position on y-axis of the panel in pixels
     * @param width width of the image in pixels
     * @param height length of the image in pixels
     */
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

    /**
     * Main method that sets up all the gui elements for the other players' panel
     */
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
        assert car1 != null;
        Image car2 = car1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        carPlus = new JLabel(new ImageIcon(car2));
        carPlus.setBounds(160,120,50,50);
        this.add(carPlus);

        BufferedImage car4 = null;
        try {
            car4 = ImageIO.read(new File("src/main/resource/car502.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert car4 != null;
        Image car5 = car4.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        carMinus = new JLabel(new ImageIcon(car5));
        carMinus.setBounds(160,60,50,50);
        this.add(carMinus);

        BufferedImage mg1 = null;
        try {
            mg1 = ImageIO.read(new File("src/main/resource/mg50.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert mg1 != null;
        Image mg2 = mg1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        mg = new JLabel(new ImageIcon(mg2));
        mg.setBounds(220,120,50,50);
        this.add(mg);

        health.setForeground(Color.black);
        health.setFont(new Font("Calibri", Font.BOLD, 20));
        health.setBounds(35, 50, 150, 40);
        this.add(health);

        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setBounds(40, 150, 150, 40);
        this.add(name);

        setVisible(true);
    }

    /**
     * method used in GameFrame to display players' name
     * @param name players' name
     */
    public void displayName(String name) {this.name.setText(name);}

    /**
     * method used in GameFrame to display players' health
     * @param hp players' health
     */
    public void displayHealth(String hp) {this.health.setText(hp);}

    /**
     * method used in GameFrame to display players' +1 car equipment
     * @param check boolean value showing whether the player is equipped with the equipment
     */
    public void displayCarPlus(boolean check) {this.carPlus.setVisible(check);}

    /**
     * method used in GameFrame to display players' -1 car equipment
     * @param check boolean value showing whether the player is equipped with the equipment
     */
    public void displayCarMinus(boolean check) {this.carMinus.setVisible(check);}

    /**
     * method used in GameFrame to display players' machine gun equipment
     * @param check boolean value showing whether the player is equipped with the equipment
     */
    public void displayMG(boolean check) {this.mg.setVisible(check);}
}

