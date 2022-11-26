package UI.GamePageCompo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OtherPlayers extends JPanel{


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




    }

}

