package UseCase.GameBoard;

import UseCase.EndTurn.EndTurnViewModel;
import entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameboardViewModel {

    private static GameboardViewModel instance;
    private List<String> targetList;
    HashMap<String, Integer> roleExist;
    private String isEnd;
    private boolean isDead;
    private Player currentPlayer;


    private String playerRole;
    private String strategy;

    public static GameboardViewModel getInstance(){
        if(instance == null){
            instance = new GameboardViewModel();
        }
        return instance;
    }

    public void updateView(List<String> targetList, HashMap<String, Integer> roleExist, String isEnd, boolean isDead, Player currentPlayer, String playeRole, String strategy){
        this.targetList = targetList;
        this.isEnd = isEnd;
        this.isDead = isDead;
        this.roleExist = roleExist;
        this.currentPlayer = currentPlayer;
        this.playerRole = playeRole;
        this.strategy = strategy;
    }

    public List<String> getTargetList() {
        return targetList;
    }

    public HashMap<String, Integer> getRoleExist() {
        return roleExist;
    }

    public String getIsEnd() {
        return isEnd;
    }

    public boolean isDead() {
        return isDead;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public String getStrategy() {
        return strategy;
    }
}
