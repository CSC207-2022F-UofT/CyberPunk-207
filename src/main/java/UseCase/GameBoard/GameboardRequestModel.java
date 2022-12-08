package UseCase.GameBoard;

import entity.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

/**
 * A request model of game board, containing player and role map attribute
 * Serve as input for start game and change turn methods of input boundary
 **/
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
