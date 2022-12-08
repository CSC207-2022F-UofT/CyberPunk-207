package UseCase.PlayerJoin;

import entity.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

public class PlayerJoinViewModel {
    public  static PlayerJoinViewModel instance;

    private List<Player> playersJoin;
    private HashMap<Identity, List<Player>> roleMap;

    public static PlayerJoinViewModel getInstance(){
        if(instance == null){
            instance = new PlayerJoinViewModel();
        }
        return instance;
    }

    public void updateView(List<Player> playersJoin, HashMap<Identity, List<Player>> roleMap) {
        this.playersJoin = playersJoin;
        this.roleMap = roleMap;
    }

    public List<Player> getPlayersJoin() {
        return playersJoin;
    }

    public HashMap<Identity, List<Player>> getRoleMap() {
        return roleMap;
    }
}
