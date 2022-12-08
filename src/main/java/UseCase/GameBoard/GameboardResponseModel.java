package UseCase.GameBoard;

import entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameboardResponseModel {
    private List<String> targetList;
    HashMap<String, Integer> roleExist;
    private String isEnd;
    private boolean isDead;
    private Player currentPlayer;

    private String playeRole;


    public GameboardResponseModel(List<String> targetList, String isEnd, boolean isDead, HashMap<String, Integer> roleExist, Player currentPlayer) {
        this.targetList = targetList;
        this.isEnd = isEnd;
        this.isDead = isDead;
        this.roleExist = roleExist;
        this.currentPlayer = currentPlayer;
        this.playeRole = currentPlayer.getRole().toString();
    }

    public List<String> getTargetList() {
        return targetList;
    }

    public String isEnd() {
        return isEnd;
    }

    public boolean isDead() {
        return isDead;
    }

    public HashMap<String, Integer> getRoleExist() {
        return roleExist;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getPlayerRole() {return playeRole;}
}
