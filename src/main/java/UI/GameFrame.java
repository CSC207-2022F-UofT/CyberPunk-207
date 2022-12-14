package UI;

import Gateway.StatusUpdatable;
import UseCase.GameBoard.GameboardController;
import Gateway.GameboardUpdatable;
import UseCase.GameBoard.GameboardViewModel;
import UseCase.GlobalStatus.*;
import UseCase.PlayerJoin.PlayerJoinViewModel;
import UseCase.UseCard.UseCardViewModel;
import entity.Identity;
import Gateway.PlayerJoinUpdatable;
import Gateway.UseCardUpdatable;
import entity.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Class that initiates the frame and game page for the game
 */
public class GameFrame extends JFrame implements StatusUpdatable, GameboardUpdatable, UseCardUpdatable, PlayerJoinUpdatable {

    OtherPlayersPanel position1 = new OtherPlayersPanel();
    OtherPlayersPanel position2 = new OtherPlayersPanel();
    OtherPlayersPanel position3 = new OtherPlayersPanel();
    OtherPlayersPanel position4 = new OtherPlayersPanel();

    MainPlayerPanel current = new MainPlayerPanel();

    private StatusController statusController;

    private GameboardController gameboardController;

    private RulePanel rulePanel = new RulePanel();
    private String captain;

    private JPanel gamePanel = new GamePanel();

    /**
     * Main method that adds all the panels for the GameFrame
     */
    public GameFrame() {
        this.setTitle("Cyberpunk 207");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        gamePanel.add(position1);
        position1.setBounds(30,250,300, 200);

        gamePanel.add(position2);
        position2.setBounds(360,20,300, 200);

        gamePanel.add(position3);
        position3.setBounds(800,20,300, 200);

        gamePanel.add(position4);
        position4.setBounds(1120,250,300, 200);

        gamePanel.add(current);
        current.setBounds(0,0,1920,1080);

        gamePanel.setVisible(true);
        setContentPane(rulePanel);
        rulePanel.setVisible(true);
    }

    /**
     * Method used to display other players' name on GameFrame
     * @param names List of strings representing other players' name
     */
    public void displayOtherNames(List<String> names) {
        position1.displayName(names.get(3));
        position2.displayName(names.get(2));
        position3.displayName(names.get(1));
        position4.displayName(names.get(0));
    }

    /**
     * Method used to display other players' health on GameFrame
     * @param hps List of strings representing other players' health
     */
    public void displayHP(List<String> hps) {
        position1.displayHealth(hps.get(3));
        position2.displayHealth(hps.get(2));
        position3.displayHealth(hps.get(1));
        position4.displayHealth(hps.get(0));
    }

    /**
     * Method used to display other players' +1 distance car equipment on GameFrame
     * @param carP List of booleans representing other players' +1 distance car equipment
     */
    public void displayCarPlus(List<Boolean> carP) {
        position1.displayCarPlus(carP.get(3));
        position2.displayCarPlus(carP.get(2));
        position3.displayCarPlus(carP.get(1));
        position4.displayCarPlus(carP.get(0));
    }

    /**
     * Method used to display other players' -1 distance car equipment on GameFrame
     * @param carM List of booleans representing other players' -1 distance car equipment
     */
    public void displayCarMinus(List<Boolean> carM) {
        position1.displayCarMinus(carM.get(3));
        position2.displayCarMinus(carM.get(2));
        position3.displayCarMinus(carM.get(1));
        position4.displayCarMinus(carM.get(0));
    }

    /**
     * Method used to display other players' machinegun equipment on GameFrame
     * @param MG List of booleans representing other players' machinegun equipment
     */
    public void displayMG(List<Boolean> MG) {
        position1.displayMG(MG.get(3));
        position2.displayMG(MG.get(2));
        position3.displayMG(MG.get(1));
        position4.displayMG(MG.get(0));
    }


    /**
     * Setter method to set gameboardController for the GameFrame
     * @param gameboardController input Gameboard controller
     */
    public void setGameboardController(GameboardController gameboardController) {
        this.gameboardController = gameboardController;
        current.setGameboardController(gameboardController);

    }

    /**
     * Setter method to set setStatusController for the GameFrame
     * @param statusController input setStatus controller
     */
    public void setStatusController(StatusController statusController) {
        this.statusController = statusController;
        current.setStatusController(statusController);
    }


    /**
     * Implement viewGameboard method for the GameFrame
     * @param gameboardViewModel A view model containing all information of current game board
     */
    @Override
    public void viewGameboard(GameboardViewModel gameboardViewModel) {
        Player currentPlayer = gameboardViewModel.getCurrentPlayer();
        String isEnd = gameboardViewModel.getIsEnd();
        if(!isEnd.equals("")){
            JOptionPane.showMessageDialog(null, isEnd);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("An exception occurred: " + e.getMessage());
            }
            setContentPane(rulePanel);
            gamePanel.setVisible(false);
            rulePanel.setVisible(true);
        }

        current.setPlayer(currentPlayer);
        current.setPlist(gameboardViewModel.getTargetList());
        HashMap<String, Integer> roleExist = gameboardViewModel.getRoleExist();
        current.displayRole(captain, roleExist);
        current.displaySide(gameboardViewModel.getPlayerRole());
        if(gameboardViewModel.getStrategy().equals("AI")){
            current.setStrategy("AI");
            current.AIPlayStrategy();
        }
        if(gameboardViewModel.isDead()){
            gameboardController.turnChange();
            statusController.turnChange();
        }
    }

    /**
     * Method to update all players' status such as health and name
     * @param globalStatusViewModel view model containing all information for the current and other players' status
     */
    @Override
    public void viewStatus(GlobalStatusViewModel globalStatusViewModel) {
        current.setPcards(globalStatusViewModel.getHands());
        current.displayHP(globalStatusViewModel.getGlobalStatus().get(0).get(2));
        current.displayName(globalStatusViewModel.getGlobalStatus().get(0).get(0));
        current.displayMG(!Objects.equals(globalStatusViewModel.getGlobalStatus().get(0).get(3), ""));
        current.displayCarPlus(!Objects.equals(globalStatusViewModel.getGlobalStatus().get(0).get(4), ""));
        current.displayCarMinus(!Objects.equals(globalStatusViewModel.getGlobalStatus().get(0).get(5), ""));

        List<String> othersHP = new ArrayList<>();
        for(int i = 1; i < 5;i++){othersHP.add(globalStatusViewModel.getGlobalStatus().get(i).get(2));}
        this.displayHP(othersHP);

        List<String> othersName = new ArrayList<>();
        for(int i = 1; i < 5;i++){othersName.add(globalStatusViewModel.getGlobalStatus().get(i).get(0));}
        this.displayOtherNames(othersName);

        List<Boolean> carPlus = new ArrayList<>();
        for(int i = 1; i < 5;i++){carPlus.add(!Objects.equals(globalStatusViewModel.getGlobalStatus().get(i).get(4)
                , ""));}
        this.displayCarPlus(carPlus);

        List<Boolean> carMinus = new ArrayList<>();
        for(int i = 1; i < 5;i++){carMinus.add(!Objects.equals(globalStatusViewModel.getGlobalStatus().get(i).get(5)
                , ""));}
        this.displayCarMinus(carMinus);

        List<Boolean> mg = new ArrayList<>();
        for(int i = 1; i < 5;i++){mg.add(!Objects.equals(globalStatusViewModel.getGlobalStatus().get(i).get(3)
                , ""));}
        this.displayMG(mg);

    }


    /**
     * method that allow users to see the card in their deck
     * @param useCardViewModel view model that allows player to check their cards
     */
    @Override
    public void viewCard(UseCardViewModel useCardViewModel) {
        String msg = useCardViewModel.getMessage();
        current.displayIns(msg);
    }

    /**
     * method that sets up the player and initiates the game
     * @param playerjoinViewModel view model that allows player to join the game
     */
    @Override
    public void viewPlayers(PlayerJoinViewModel playerjoinViewModel) {
        captain = playerjoinViewModel.getRoleMap().get(Identity.CAPTAIN).toString();
        statusController.init(playerjoinViewModel.getPlayersJoin());
        gameboardController.startGame(playerjoinViewModel.getPlayersJoin(), playerjoinViewModel.getRoleMap());
        rulePanel.setVisible(false);
        gamePanel.setVisible(true);
        setContentPane(gamePanel);
    }

    /**
     * getter method for rule panel
     * @return rule panel of GameFrame
     */
    public RulePanel getRulePanel() {
        return rulePanel;
    }

    /**
     * getter method for current main player panel
     * @return main player panel
     */
    public MainPlayerPanel getCurrentPanel() {
        return current;
    }
}