package UseCase.GameBoard;

import entity.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameboardRequestModel {
    private List<Player> players;
    private HashMap<Identity, List<Player>> roleMap;

    public GameboardRequestModel(List<Player> players, HashMap<Identity, List<Player>> roleMap) {
        this.players = players;
        this.roleMap = roleMap;
    }

    public HashMap<Identity, List<Player>> getRoleMap() {
        return roleMap;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
