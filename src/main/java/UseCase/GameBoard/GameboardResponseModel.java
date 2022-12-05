package UseCase.GameBoard;

import entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameboardResponseModel {
    private List<String> targetList;
    HashMap<String, Integer> roleExist;
    private String isEnd;
    private boolean isDead;


    public GameboardResponseModel(List<String> targetList, String isEnd, boolean isDead, HashMap<String, Integer> roleExist) {
        this.targetList = targetList;
        this.isEnd = isEnd;
        this.isDead = isDead;
        this.roleExist = roleExist;
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
}
