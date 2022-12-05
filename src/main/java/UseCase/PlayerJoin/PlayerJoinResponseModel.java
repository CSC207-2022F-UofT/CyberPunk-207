package UseCase.PlayerJoin;

import UseCase.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

public class PlayerJoinResponseModel {
    private List<Player> playersJoin;
    private HashMap<Identity, List<Player>> roleMap;


    public PlayerJoinResponseModel(List<Player> playersJoin, HashMap<Identity, List<Player>> roleMap) {
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
