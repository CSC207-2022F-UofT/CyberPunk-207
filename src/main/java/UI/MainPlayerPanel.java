package UI;

import UseCase.EndTurn.EndTurnController;
import UseCase.EndTurn.EndTurnResponseModel;
import UseCase.EndTurn.EndTurnUpdatable;
import UseCase.EndTurn.EndTurnViewModel;
import UseCase.GameBoard.GameboardController;
import UseCase.GlobalStatus.StatusController;
import UseCase.ThrowCard.ThrowCardController;
import UseCase.UseCard.UseCardController;
import entity.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class MainPlayerPanel extends JPanel implements EndTurnUpdatable {


    private List<String> pcards = new ArrayList<>();
    private final JComboBox<String> cards = new JComboBox<>();
    JComboBox<String> players = new JComboBox<>();

    private final JLabel roleInfo = new JLabel();

    private final JLabel message = new JLabel();

    private final JLabel name = new JLabel();

    private final JLabel health = new JLabel();

    private final JLabel side = new JLabel();

    private JLabel carPlus;

    private JLabel mg;

    private JLabel carMinus;

    private GameboardController gameboardController;

    private UseCardController useCardController;

    private ThrowCardController throwCardController;

    private EndTurnController endTurnController;

    private StatusController statusController;

    private Player player;

    private final JLabel carddis2 = new JLabel();

    private final JButton use = new JButton("use");

    private final JButton discard = new JButton("discard");

    private final JButton end;

    private final JButton show;

    public MainPlayerPanel(){

        this.setLayout(null);

        this.setBackground(new Color(173,216,230));

        BufferedImage hp1 = null;
        try {
            hp1 = ImageIO.read(new File("src/main/resource/health.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert hp1 != null;
        Image hp2 = hp1.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JLabel hp = new JLabel(new ImageIcon(hp2));
        hp.setBounds(50,460,70,70);

        BufferedImage p1 = null;
        try {
            p1 = ImageIO.read(new File("src/main/resource/default.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert p1 != null;
        Image p2 = p1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel player = new JLabel(new ImageIcon(p2));
        player.setBounds(50,540,150,150);

        health.setForeground(Color.black);
        health.setFont(new Font("Calibri", Font.BOLD, 30));
        health.setBounds(130, 480, 150, 40);

        side.setForeground(Color.black);
        side.setFont(new Font("Calibri", Font.BOLD, 20));
        side.setBounds(230, 620, 150, 40);

        name.setForeground(Color.black);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setBounds(80, 700, 150, 40);

        roleInfo.setForeground(Color.black);
        roleInfo.setFont(new Font("Calibri", Font.BOLD, 15));
        roleInfo.setBounds(1150, 0, 200, 200);

        this.add(roleInfo);
        this.add(hp);
        this.add(player);
        this.add(health);
        this.add(side);
        this.add(name);

        use.setBounds(380,710,80,40);


        discard.setBounds(530,710,80,40);

        end = new JButton("end");
        end.setBounds(680,710,80,40);

        show = new JButton("show card");
        show.setBounds(830,710,80,40);

        BufferedImage car1 = null;
        try {
            car1 = ImageIO.read(new File("src/main/resource/car50.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert car1 != null;
        Image car2 = car1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        carPlus = new JLabel(new ImageIcon(car2));
        carPlus.setBounds(1150,580,150,150);

        BufferedImage car3 = null;
        try {
            car3 = ImageIO.read(new File("src/main/resource/car502.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert car3 != null;
        Image car4 = car3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        carMinus = new JLabel(new ImageIcon(car4));
        carMinus.setBounds(1150,450,150,150);


        BufferedImage mg1 = null;
        try {
            mg1 = ImageIO.read(new File("src/main/resource/mg50.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert mg1 != null;
        Image mg2 = mg1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        mg = new JLabel(new ImageIcon(mg2));
        mg.setBounds(1280,550,150,150);

        this.add(use);
        this.add(discard);
        this.add(end);
        this.add(mg);
        this.add(carPlus);
        this.add(show);
        this.add(carMinus);

        players.setBounds(620, 500,200,200);
        cards.setBounds(400, 500,200,200);

        use.addActionListener(e -> {
            String selected = (String) cards.getSelectedItem();
            String target = (String) players.getSelectedItem();
            assert target != null;
            target = target.replaceAll("[^0-9]", "");
            int index = pcards.indexOf(selected);
            useCardController.useCard(this.player, index, Integer.parseInt(target));
        });

        discard.addActionListener(e -> {
            String selected = (String) cards.getSelectedItem();
            int card = pcards.indexOf(selected);
            throwCardController.throwCard(this.player, card);
        });

        end.addActionListener(e -> endTurnController.endTurn(this.player));

        show.addActionListener(e -> {
            String cn = (String) cards.getSelectedItem();
            displayCard(cn);
        });


        JLabel yours = new JLabel("Your Deck:");
        yours.setForeground(Color.white);
        yours.setFont(new Font("Calibri", Font.BOLD, 20));
        yours.setBounds(400, 540, 200, 40);

        JLabel choose = new JLabel("Play on:");
        choose.setForeground(Color.white);
        choose.setFont(new Font("Calibri", Font.BOLD, 20));
        choose.setBounds(620, 540, 200, 40);


        BufferedImage logo = null;
        try {
            logo = ImageIO.read(new File("src/main/resource/logo.png"));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert logo != null;
        Image logo1 = logo.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
        JLabel logof = new JLabel(new ImageIcon(logo1));
        logof.setBounds(0,0,300,150);

        message.setBackground(Color.YELLOW);
        message.setFont(new Font("Calibri", Font.BOLD, 20));
        message.setBounds(420, 550, 600, 200);

        JLabel round = new JLabel();
        round.setBounds(700, 800, 100, 100);

        this.add(message);
        this.add(logof);
        this.add(cards);
        this.add(players);
        this.add(yours);
        this.add(choose);
        this.add(carddis2);
        this.add(round);

        this.setVisible(true);
        discard.setVisible(false);
    }


    public void displayIns(String instruction) {
        message.setText(instruction);
    }


    public void displayHP(String hp) {
        health.setText(hp);
    }


    public void displayName(String name) {
        this.name.setText(name);
    }

    public void displaySide(String name) {this.side.setText(name);}

    public void displayCarPlus(boolean check) {this.carPlus.setVisible(check);}

    public void displayCarMinus(boolean check) {this.carMinus.setVisible(check);}

    public void displayMG(boolean check) {this.mg.setVisible(check);}


    public void displayRole(String captain, HashMap<String, Integer> roleExist){
        String sb = "<html>Captain: " + captain + "<br/>Police: " + roleExist.get("POLICE") + "<br/>Criminal: " +
                roleExist.get("CRIMINAL") + "<br/>Corpo: " + roleExist.get("CORPO");
        roleInfo.setText(sb);
    }

    @Override
    public void throwView(EndTurnViewModel endTurnViewModel) {
        if(endTurnViewModel.getNextTurn()){
            use.setVisible(true);
            discard.setVisible(false);
            gameboardController.turnChange();
            statusController.turnChange();
        }else {
            String msg = endTurnViewModel.getMessage();
            displayIns(msg);
            use.setVisible(false);
            discard.setVisible(true);
            if(player.getStrategy().equals("AI")){
                ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
                executor.schedule((Runnable) discard::doClick, 1, TimeUnit.SECONDS);
                executor.schedule((Runnable) end::doClick, 2, TimeUnit.SECONDS);
            }
        }

    }

    public void AIPlayStrategy(){


        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule((Runnable) show::doClick, 1, TimeUnit.SECONDS);
        executor.schedule((Runnable) use::doClick, 2, TimeUnit.SECONDS);
        executor.schedule((Runnable) end::doClick, 3, TimeUnit.SECONDS);

    }


    public void setGameboardController(GameboardController gameboardController) {
        this.gameboardController = gameboardController;
    }

    public void setUseCardController(UseCardController useCardController) {
        this.useCardController = useCardController;
    }

    public void setThrowCardController(ThrowCardController throwCardController) {
        this.throwCardController = throwCardController;
    }

    public void setEndTurnController(EndTurnController endTurnController) {
        this.endTurnController = endTurnController;
    }

    public void setStatusController(StatusController statusController) {
        this.statusController = statusController;
    }

    public void setPcards(List<String> pcards) {
        this.pcards = pcards;
        cards.removeAllItems();
        for (String pcard : pcards) {
            cards.addItem(pcard);
        }
    }

    public void setPlist(List<String> plist) {
        players.removeAllItems();
        for (String s : plist) {
            players.addItem(s);}
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void displayCard(String cardName) {
        String fileSource;
        fileSource = null;
        switch (Objects.requireNonNull(cardName)) {
            case "Destruction":
                fileSource = "src/main/resource/destruction.png";
                break;
            case "Dodge":
                fileSource = "src/main/resource/dodge.png";
                break;
            case "Lambo":
                fileSource = "src/main/resource/car1.png";
                break;
            case "Lottery":
                fileSource = "src/main/resource/lottery.png";
                break;
            case "Medkit":
                fileSource = "src/main/resource/medkit.png";
                break;
            case "Policeraid":
                fileSource = "src/main/resource/policeraid.png";
                break;
            case "R99 Machine Gun":
                fileSource = "src/main/resource/mg.png";
                break;
            case "Robbery":
                fileSource = "src/main/resource/robbery.png";
                break;
            case "Shoot":
                fileSource = "src/main/resource/shoot.png";
                break;
            case "Shootout":
                fileSource = "src/main/resource/shootout.png";
                break;
            case "Tesla":
                fileSource = "src/main/resource/car2.png";
                break;
            case "Traumateam":
                fileSource = "src/main/resource/trauma team.png";
                break;
        }
        assert fileSource != null;
        BufferedImage carddis = null;
        try {
            carddis = ImageIO.read(new File(fileSource));
        } catch (IOException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
        assert carddis != null;
        Image carddis1 = carddis.getScaledInstance(200, 270, Image.SCALE_SMOOTH);
        carddis2.setIcon(new ImageIcon(carddis1));
        carddis2.setBounds(850,400,200,270);
    }

}
