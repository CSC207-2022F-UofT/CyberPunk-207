package UI;

import javax.swing.*;

public class RulePage {
    private JFrame frame;


    public void init(){
        ImageIcon bg = new ImageIcon(this.getClass().getResource("/rulesbg.jpg"));
        JLabel myLabel = new JLabel(bg);
        myLabel.setSize(1920,1080);

        ImageIcon bg1 = new ImageIcon(this.getClass().getResource("/2.jpg"));
        JLabel myLabel1 = new JLabel(bg1);
        myLabel1.setBounds(450,200,616,353);

        JButton cont = new JButton("continue");
        cont.setBounds(700,700,100,50);
        myLabel.add(myLabel1);
        myLabel.add(cont);

        JFrame frame = new JFrame("Rule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(myLabel);
    }
    public static void main(String[] args) {
        new RulePage().init();
    }
}