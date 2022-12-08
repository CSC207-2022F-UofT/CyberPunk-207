package UI;

import UseCase.GameBoard.GameboardController;
import UseCase.GameBoard.GameboardUpdatable;
import UseCase.GameBoard.GameboardViewModel;
import UseCase.GlobalStatus.*;
import UseCase.PlayerJoin.PlayerJoinViewModel;
import UseCase.UseCard.UseCardViewModel;
import entity.Identity;
import UseCase.PlayerJoin.PlayerJoinUpdatable;
import UseCase.UseCard.UseCardUpdatable;
import entity.Player;

import javax.swing.*;
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

    private StatusController statusController;

    private GameboardController gameboardController;

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



    public void setGameboardController(GameboardController gameboardController) {
        this.gameboardController = gameboardController;
        current.setGameboardController(gameboardController);

    }

    public void setStatusController(StatusController statusController) {
        this.statusController = statusController;
        current.setStatusController(statusController);
    }



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
        if(gameboardViewModel.isDead()){
            gameboardController.turnChange();
            statusController.turnChange();
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
    }

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


    @Override
    public void viewCard(UseCardViewModel useCardViewModel) {
        String msg = useCardViewModel.getMessage();
        current.displayIns(msg);
    }

    @Override
    public void viewPlayers(PlayerJoinViewModel playerjoinViewModel) {
        captain = playerjoinViewModel.getRoleMap().get(Identity.CAPTAIN).toString();
        statusController.init(playerjoinViewModel.getPlayersJoin());
        gameboardController.startGame(playerjoinViewModel.getPlayersJoin(), playerjoinViewModel.getRoleMap());
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