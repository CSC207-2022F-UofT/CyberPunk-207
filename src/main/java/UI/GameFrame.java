package UI;

import UseCase.EndTurn.EndTurnController;
import UseCase.EndTurn.EndTurnResponseModel;
import UseCase.EndTurn.EndTurnUpdatable;
import UseCase.GameBoard.GameboardController;
import UseCase.GameBoard.GameboardResponseModel;
import UseCase.GameBoard.GameboardUpdatable;
import UseCase.GlobalStatus.Status;
import UseCase.GlobalStatus.StatusController;
import UseCase.GlobalStatus.StatusResponseModel;
import UseCase.GlobalStatus.StatusUpdatable;
import UseCase.Identity;
import UseCase.PlayerJoin.PlayerJoinResponseModel;
import UseCase.PlayerJoin.PlayerJoinUpdatable;
import UseCase.UseCard.UseCardController;
import UseCase.UseCard.UseCardResponseModel;
import UseCase.UseCard.UseCardUpdatable;
import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class GameFrame extends JFrame implements StatusUpdatable, GameboardUpdatable, UseCardUpdatable, PlayerJoinUpdatable {

    OtherPlayersPanel position1 = new OtherPlayersPanel();
    OtherPlayersPanel position2 = new OtherPlayersPanel();
    OtherPlayersPanel position3 = new OtherPlayersPanel();
    OtherPlayersPanel position4 = new OtherPlayersPanel();

    MainPlayerPanel current = new MainPlayerPanel();

    private EndTurnController endTurnController;
    private StatusController statusController;

    private GameboardController gameboardController;

    private Player currentPlayer;

    private RulePanel rulePanel = new RulePanel();
    private String captain;

    private JPanel gamePanel = new GamePanel();

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


    public void displayOtherNames(List<String> names) {
        position1.displayName(names.get(3));
        position2.displayName(names.get(2));
        position3.displayName(names.get(1));
        position4.displayName(names.get(0));
    }

    public void displayHP(List<String> hps) {
        position1.displayHealth(hps.get(3));
        position2.displayHealth(hps.get(2));
        position3.displayHealth(hps.get(1));
        position4.displayHealth(hps.get(0));
    }

    public void displayCarPlus(List<Boolean> carP) {
        position1.displayCarPlus(carP.get(3));
        position2.displayCarPlus(carP.get(2));
        position3.displayCarPlus(carP.get(1));
        position4.displayCarPlus(carP.get(0));
    }

    public void displayCarMinus(List<Boolean> carM) {
        position1.displayCarMinus(carM.get(3));
        position2.displayCarMinus(carM.get(2));
        position3.displayCarMinus(carM.get(1));
        position4.displayCarMinus(carM.get(0));
    }

    public void displayMG(List<Boolean> MG) {
        position1.displayMG(MG.get(3));
        position2.displayMG(MG.get(2));
        position3.displayMG(MG.get(1));
        position4.displayMG(MG.get(0));
    }

    public void setPosition1(OtherPlayersPanel position1) {
        this.position1 = position1;
    }

    public void setEndTurnController(EndTurnController endTurnController) {
        this.endTurnController = endTurnController;
        current.setEndTurnController(endTurnController);
    }

    public void setGameboardController(GameboardController gameboardController) {
        this.gameboardController = gameboardController;
        current.setGameboardController(gameboardController);

    }

    public void setStatusController(StatusController statusController) {
        this.statusController = statusController;
        current.setStatusController(statusController);
    }



    @Override
    public void viewGameboard(GameboardResponseModel gameboardResponseModel) {
        currentPlayer = gameboardResponseModel.getCurrentPlayer();
        String isEnd = gameboardResponseModel.isEnd();
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
        if(gameboardResponseModel.isDead()){
            gameboardController.turnChange();
            statusController.turnChange();
        }
        //可在此设置ai
        current.setPlayer(currentPlayer);
        current.setPlist(gameboardResponseModel.getTargetList());
        HashMap<String, Integer> roleExist = gameboardResponseModel.getRoleExist();
        current.displayRole(captain, roleExist);
    }

    @Override
    public void viewStatus(StatusResponseModel statusResponseModel) {
        current.setPcards(statusResponseModel.getHands());
        current.displayHP(statusResponseModel.getGlobalStatus().get(0).get(2));
        current.displayName(statusResponseModel.getGlobalStatus().get(0).get(0));
        current.displaySide(statusResponseModel.getGlobalStatus().get(0).get(7));
        current.displayMG(Objects.equals(statusResponseModel.getGlobalStatus().get(0).get(3), "Weapon"));
        current.displayCarPlus(Objects.equals(statusResponseModel.getGlobalStatus().get(0).get(4), "Plus"));
        current.displayCarMinus(Objects.equals(statusResponseModel.getGlobalStatus().get(0).get(5), "Minus"));

        List<String> othersHP = new ArrayList<>();
        for(int i = 1; i < 5;i++){othersHP.add(statusResponseModel.getGlobalStatus().get(i).get(2));}
        this.displayHP(othersHP);

        List<String> othersName = new ArrayList<>();
        for(int i = 1; i < 5;i++){othersName.add(statusResponseModel.getGlobalStatus().get(i).get(0));}
        this.displayOtherNames(othersName);

        List<Boolean> carPlus = new ArrayList<>();
        for(int i = 1; i < 5;i++){carPlus.add(Objects.equals(statusResponseModel.getGlobalStatus().get(i).get(4)
                , "Plus"));}
        this.displayCarPlus(carPlus);

        List<Boolean> carMinus = new ArrayList<>();
        for(int i = 1; i < 5;i++){carMinus.add(Objects.equals(statusResponseModel.getGlobalStatus().get(i).get(5)
                , "Minus"));}
        this.displayCarMinus(carMinus);

        List<Boolean> mg = new ArrayList<>();
        for(int i = 1; i < 5;i++){mg.add(Objects.equals(statusResponseModel.getGlobalStatus().get(i).get(3)
                , "Weapon"));}
        this.displayMG(mg);



    }


    @Override
    public void viewCard(UseCardResponseModel useCardResponseModel) {
        String msg = useCardResponseModel.getMessage();
        //display这条信息
    }

    @Override
    public void viewPlayers(PlayerJoinResponseModel playerJoinResponseModel) {
        captain = playerJoinResponseModel.getRoleMap().get(Identity.CAPTAIN).toString();
        statusController.init(playerJoinResponseModel.getPlayersJoin());
        gameboardController.startGame(playerJoinResponseModel.getPlayersJoin(), playerJoinResponseModel.getRoleMap());
        rulePanel.setVisible(false);
        gamePanel.setVisible(true);
        setContentPane(gamePanel);
    }

    public RulePanel getRulePanel() {
        return rulePanel;
    }

    public MainPlayerPanel getCurrentPanel() {
        return current;
    }
}