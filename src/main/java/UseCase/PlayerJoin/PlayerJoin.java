package UseCase.PlayerJoin;

import entity.Player;
import UseCase.Identity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

/**
 * Playerjoin use case, assigning player's role and type (human or AI) based on how many players attend the game
 * After initialization, send role and player information to output boundary
 **/
public class PlayerJoin implements PlayerJoinInputBoundary {
    private List<Player> players;
    private List<Identity> roles;
    private HashMap<Identity, List<Player>> roleMap;
    private PlayerJoinOutputBoundary playerJoinOutputBoundary;

    public PlayerJoin(PlayerJoinOutputBoundary playerJoinOutputBoundary) {
        this.playerJoinOutputBoundary = playerJoinOutputBoundary;
        players = new ArrayList<>();
        roles = new ArrayList<>();
        roleMap = new HashMap<>();
    }

    /**
     * A helper function initializing five players and randomly assign roles for them
     **/
    public void init() {
        shuffleRoles();
        roleMap.put(Identity.CAPTAIN, new ArrayList<>());
        roleMap.put(Identity.POLICE, new ArrayList<>());
        roleMap.put(Identity.CRIMINAL, new ArrayList<>());
        roleMap.put(Identity.CORPO, new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            Player player = new Player(i + 1);
            players.add(player);
            player.setRole(roles.get(i));
            roleMap.get(roles.get(i)).add(player);
        }
    }

    /**
     * A helper function shuffling the role attribute (a list), to be assigned to players
     **/
    public void shuffleRoles(){
        roles.addAll(List.of(Identity.CAPTAIN, Identity.POLICE, Identity.CRIMINAL, Identity.CRIMINAL, Identity.CORPO));
        Random r = new Random();
        for(int i = 4; i >= 1 ; i--){
            swap(roles, i, r.nextInt(i));
        }
    }

    /**
     * Assign player's role randomly. Based on input of request model, if number of players is smaller than 5 then add AI players.
     * After initialization, create and send a new response model incorporating role and player information to output boundary.
     * @param playerJoinRequestModel A request model input
     **/
    public void playersJoin(PlayerJoinRequestModel playerJoinRequestModel){
        init();
        for (int i = 0; i < 5; i++) {
            if (i < playerJoinRequestModel.getNumOfHuman()) {
                players.get(i).setStrategy("Human");
            } else {
                players.get(i).setStrategy("AI");
            }
        }
        playerJoinOutputBoundary.playersJoin(new PlayerJoinResponseModel(players, roleMap));
    }
}
