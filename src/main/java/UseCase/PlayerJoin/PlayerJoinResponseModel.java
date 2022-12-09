package UseCase.PlayerJoin;

import entity.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

/**
 * A response model of player join, containing results of role and type assignment
 * Including playersJoin (list attribute of all players) and roleMap (hashmap attribute of role assignment)
 * To be handled by UI
 **/
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
