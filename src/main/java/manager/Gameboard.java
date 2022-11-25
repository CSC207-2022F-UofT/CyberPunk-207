package manager;

import entity.Card;
import entity.PlayerModel;
import gateway.CardsHeap;

import java.util.*;

import static Controller.GameController.input;
import static java.util.Collections.swap;


public class Gameboard implements InputBoundary{
    private static List<PlayerManager> players = new ArrayList<>();
    private static int round = 1;
    private HashMap<Identity, List<PlayerManager>> roleMap = new HashMap<>();
    private List<Identity> roles = new ArrayList<>();
    private static List<PlayerModel> seatMap = new ArrayList<>();
    private final OutputBoundary outputBoundary;
    private boolean askTarget;
    private PhaseManager phaseManager;

    public Gameboard(OutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
    }

    public void startGame(){
        gameInit();
        while (!checkEnd()) {  // can use game status
            outputBoundary.output("Round " + round++);
            for (PlayerManager p : players) {
                //output("Your round begins");
                if(!checkDeath(p)){
                    phaseManager.runPhase(p);
                }
            }
        }
        //game over
    }



    public void gameInit(){
        CardsHeap.init();
        shuffleRoles();
        int numPlayers = 5;
        roleMap.put(Identity.CAPTAIN, new ArrayList<>());
        roleMap.put(Identity.POLICE, new ArrayList<>());
        roleMap.put(Identity.CRIMINAL, new ArrayList<>());
        roleMap.put(Identity.CORPO, new ArrayList<>());
        for(int i = 0; i < numPlayers; i++){
            PlayerManager player = new HumanPlayer(i + 1, this );// can choose the number of ai and human player
            players.add(player);
            player.setRole(roles.get(i)); //can use to add gameHistory to the account
            roleMap.get(roles.get(i)).add(player);
            seatMap.add(player.getPlayer());
            player.drawCards(4);
        }
        roleMap.get(Identity.CAPTAIN).get(0).setHp(4);
        phaseManager = new PhaseManager(this, outputBoundary);
        //can use strategy pattern to choose different phase logic afterwards
    }

    public void shuffleRoles(){
        roles.addAll(List.of(Identity.CAPTAIN, Identity.POLICE, Identity.CRIMINAL, Identity.CRIMINAL, Identity.CORPO));
        Random r = new Random();
        for(int i = 4; i >= 1 ; i--){
            swap(roles, i, r.nextInt(i));
        }
    }

    public void endGame(){
        System.exit(0);
    }


    public boolean checkEnd() {
        if (isExtinct(Identity.CAPTAIN) && isExtinct(Identity.CRIMINAL)){
            //output("Corpo Win!");
            return true;
        } else if(isExtinct(Identity.CAPTAIN) && !isExtinct(Identity.CRIMINAL)){
            //output("Criminal Win!");
            return true;
        }else if(!isExtinct(Identity.CAPTAIN) && isExtinct(Identity.CRIMINAL) && isExtinct(Identity.CORPO)) {
            //output("Police Win!");
            return true;
        }
        return false;
    }

    public boolean isExtinct(Identity role){
        return roleMap.get(role).isEmpty();
    }



    public void askTarget(Card card){
        if(card.needTarget()){
            //output("choose your target");
            int target = input() - 1;
            card.setTarget(seatMap.get(target));
            if (calDis(card.getSource(), card.getTarget()) > 1) {
                //output("out of range, try again");
                outputBoundary.output("");// display out of range
            }
        }
    }

    public int askOrder(){
        int order = input() - 1;
        return order;
    }

    public int calDis(PlayerModel playerModel1, PlayerModel playerModel2){
        int pos1 = seatMap.indexOf(playerModel1);
        int pos2 = seatMap.indexOf(playerModel2);
        int dis = Math.max(pos1 - pos2, pos2 - pos1);
        dis = Math.min(dis, 5 - dis);
        if (playerModel1.getEquipment().get("Minus") != null){
            dis -= 1;
        }
        if (playerModel2.getEquipment().get("Plus") != null){
            dis += 1;
        }
        return dis;
    }

    public boolean checkDeath(PlayerManager player){
        if(player.getHp() == 0 && player.isAlive()){
            player.isDead();
            Identity role = player.getRole();
            roleMap.get(role).remove(player);
            return true;
        } else return !player.isAlive();
    }


    public static List<PlayerModel> getPlayers(){
        return seatMap;
    }


}
