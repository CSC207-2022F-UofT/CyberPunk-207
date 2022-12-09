package UseCase.GameBoard;

import UseCase.Identity;
import entity.Player;
import entity.CardsHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Gameboard use case implement input boundary.
 * Manage the operation of gameboard including starting game and changing turns.
 **/
public class GameboardInteractor implements GameboardInputBoundary{

    private static List<Player> players = new ArrayList<>();
    /** A hashmap attribute records the information of player's role **/
    private HashMap<Identity, List<Player>> roleMap = new HashMap<>();
    private final GameboardOutputBoundary gameboardOutputBoundary;
    private Player currentPlayer;

    public GameboardInteractor(GameboardOutputBoundary gameboardOutputBoundary) {
        this.gameboardOutputBoundary = gameboardOutputBoundary;
    }

    /**
     * Change turn method. Reset current player to the next player. Make the new current player draw two cards.
     * Call display method in output boundary to display the current gameboard information
     **/
    public void turnChange(){
        int current = (players.indexOf(currentPlayer) + 1) % players.size();
        currentPlayer = players.get(current);
        currentPlayer.drawCards(2);
        GameboardResponseModel responseModel = new GameboardResponseModel(getTargetList(currentPlayer), checkEnd(),
                checkDeath(currentPlayer), roleExist(), currentPlayer);
        gameboardOutputBoundary.displayTurnChange(responseModel);
    }

    /**
     * Initialize game. Initialize card heap and allocate cards to players
     * Start turn of first player.
     * Call display method in output boundary to display the current gameboard information
     * @param gameboardRequestModel A request model containing player and role information
     **/
    public void startGame(GameboardRequestModel gameboardRequestModel){
        CardsHeap.init();
        players = gameboardRequestModel.getPlayers();
        roleMap = gameboardRequestModel.getRoleMap();
        for(Player player: players){ player.drawCards(4); }
        // Give captain 4 hp
        roleMap.get(Identity.CAPTAIN).get(0).setHp(4);
        // Start 1st turn. First player draw 2 cards
        currentPlayer = players.get(0);
        currentPlayer.drawCards(2);
        GameboardResponseModel responseModel = new GameboardResponseModel(getTargetList(currentPlayer), checkEnd(),
                checkDeath(currentPlayer), roleExist(), currentPlayer);
        gameboardOutputBoundary.displayTurnChange(responseModel);
    }

    /**
     * A helper function returning the winner.
     * @return A string indicating the winner
     **/
    public String checkEnd() {
        if (isExtinct(Identity.CAPTAIN) && isExtinct(Identity.CRIMINAL)){
            return "Corpo Win!";
        } else if(isExtinct(Identity.CAPTAIN) && !isExtinct(Identity.CRIMINAL)){
            return "Criminal Win!";
        }else if(!isExtinct(Identity.CAPTAIN) && isExtinct(Identity.CRIMINAL) && isExtinct(Identity.CORPO)) {
            return "Police Win!";
        }
        return "";
    }

    /**
     * A helper function checking whether a role is filled, which means whether the corresponding player is still alive
     * @param role One of four roles of players
     * @return A boolean indicating whether the role extinct.
     **/
    public boolean isExtinct(Identity role){
        return roleMap.get(role).isEmpty();
    }

    /**
     * A helper function which output the hashmap of each role's currently alive players
     * @return A haspmap from role to number of player still alive
     **/
    public HashMap<String, Integer> roleExist(){
        HashMap<String, Integer> roleExist = new HashMap<>();
        for(Identity role: roleMap.keySet()){
            roleExist.put(role.toString(), roleMap.get(role).size());
        }
        return roleExist;
    }

    /**
     * A helper function checking whether a certain player is still alive
     * If the player has zero hp, change the alive attribute of player, and remove the player from role map and players attribute
     * @param player The player being checked
     * @return A boolean indicating whether the player is dead
     **/
    public boolean checkDeath(Player player){
        if(player.getHp() == 0 && player.isAlive()){
            player.isDead();
            Identity role = player.getRole();
            roleMap.get(role).remove(player);
            players.remove(player);
            return true;
        } else return !player.isAlive();
    }

    /**
     * A helper function identifying whether the distance between two players is not greater than 1 (i.e. within attacking distance).
     * The distance is calculated based on a round table sitting.
     * @param player1 The first player
     * @param player2 The second player
     * @return A boolean indicating whether the distance is smaller or equal to 1.
     **/
    public boolean calDis(Player player1, Player player2){
        int pos1 = players.indexOf(player1);
        int pos2 = players.indexOf(player2);
        //Calculate the absolute distance within the array
        int dis = Math.max(pos1 - pos2, pos2 - pos1);
        // Calculate the actual distance within the round table
        dis = Math.min(dis, players.size() - dis);
        if (player1.getEquipment().get("Minus").equals("")) {dis -= 1;}
        if (player2.getEquipment().get("Plus").equals("")) {dis += 1;}
        return dis <= 1;
    }

    /**
     * A helper function which outputs a list of all potential target players of current player
     * A potential target needs to be different from current player, alive and within attack distance
     * @param currentPlayer the current player
     * @return A list of string indicating potential target players
     **/
    public List<String> getTargetList(Player currentPlayer){
        List<String> targetList = new ArrayList<>();
        for(Player player: players){
            if (!player.equals(currentPlayer)){
                if (calDis(currentPlayer, player)){
                    targetList.add(player.toString());
                }
            }
        }
        return targetList;
    }

    /**
     * Return list of players of current gameboard
     * @return A list of players
     **/
    public static List<Player> getPlayers(){
        return players;
    }
}
