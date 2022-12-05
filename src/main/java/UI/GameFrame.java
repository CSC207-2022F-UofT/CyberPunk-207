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
import java.util.HashMap;
import java.util.List;
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
        current.setBounds(0,400,1080,480);

        gamePanel.setVisible(true);
        setContentPane(rulePanel);
        rulePanel.setVisible(true);
    }


    public void displayOtherNames(List<String> names) {
        position1.displayName(names.get(0));
        position2.displayName(names.get(1));
        position3.displayName(names.get(2));
        position4.displayName(names.get(3));
    }

    public void displayHP(List<String> hps) {
        position1.displayHealth(hps.get(0));
        position2.displayHealth(hps.get(1));
        position3.displayHealth(hps.get(2));
        position4.displayHealth(hps.get(3));
    }

    public void setPosition1(OtherPlayersPanel position1) {
        this.position1 = position1;
    }

    public void setEndTurnController(EndTurnController endTurnController) {
        this.endTurnController = endTurnController;
    }

    public void setGameboardController(GameboardController gameboardController) {
        this.gameboardController = gameboardController;

    }

    public void setStatusController(StatusController statusController) {
        this.statusController = statusController;
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
        //根据global status设置
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