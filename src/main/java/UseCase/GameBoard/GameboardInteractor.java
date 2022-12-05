package UseCase.GameBoard;

import UseCase.Identity;
import entity.Player;
import entity.CardsHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameboardInteractor implements GameboardInputBoundary{

    private static List<Player> players = new ArrayList<>();
    private HashMap<Identity, List<Player>> roleMap = new HashMap<>();
    private final GameboardOutputBoundary gameboardOutputBoundary;
    private Player currentPlayer;

    public GameboardInteractor(GameboardOutputBoundary gameboardOutputBoundary) {
        this.gameboardOutputBoundary = gameboardOutputBoundary;
    }

//可以考虑使用state design pattern
    public void turnChange(){
        int current = (players.indexOf(currentPlayer) + 1) % players.size();
        currentPlayer = players.get(current);
        GameboardResponseModel responseModel = new GameboardResponseModel(getTargetList(currentPlayer), checkEnd(),
                checkDeath(currentPlayer), roleExist());
        gameboardOutputBoundary.displayTurnChange(responseModel);
    }

    public void startGame(GameboardRequestModel gameboardRequestModel){
        CardsHeap.init();
        players = gameboardRequestModel.getPlayers();
        roleMap = gameboardRequestModel.getRoleMap();
        roleMap.get(Identity.CAPTAIN).get(0).setHp(4);
        currentPlayer = players.get(0);
        GameboardResponseModel responseModel = new GameboardResponseModel(getTargetList(currentPlayer), checkEnd(),
                checkDeath(currentPlayer), roleExist());
        gameboardOutputBoundary.displayTurnChange(responseModel);
    }



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

    public boolean isExtinct(Identity role){
        return roleMap.get(role).isEmpty();
    }


    public boolean calDis(Player player1, Player player2){
        int pos1 = players.indexOf(player1);
        int pos2 = players.indexOf(player2);
        int dis = Math.max(pos1 - pos2, pos2 - pos1);
        dis = Math.min(dis, players.size() - dis);
        if (player1.getEquipment().get("Minus").equals("")){
            dis -= 1;
        }
        if (player2.getEquipment().get("Plus").equals("")){
            dis += 1;
        }
        return dis <= 1;
    }

    public boolean checkDeath(Player player){
        if(player.getHp() == 0 && player.isAlive()){
            player.isDead();
            Identity role = player.getRole();
            roleMap.get(role).remove(player);
            players.remove(player);
            return true;
        } else return !player.isAlive();
    }

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

    public HashMap<String, Integer> roleExist(){
        HashMap<String, Integer> roleExist = new HashMap<>();
        for(Identity role: roleMap.keySet()){
            roleExist.put(role.toString(), roleMap.get(role).size());
        }
        return roleExist;
    }

    public static List<Player> getPlayers(){
        return players;
    }


}
