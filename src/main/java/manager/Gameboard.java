package manager;

import entity.Player;
import gateway.CardsHeap;

import java.util.*;

import static gateway.CardsHeap.draw;
import static java.util.Collections.swap;
import static manager.IO.input;
import static manager.IO.output;

public class Gameboard {
    private static Player player;
    private static List<Player> players = new ArrayList<>();
    private static int round = 1;
    private static Player Captin;
    private HashMap<String, List<Player>> roles = new HashMap<>();
    private List<String> rolemap = new ArrayList<>();


    public static void setCaptin(Player captin) {
        Captin = captin;
    }
    //setroles 随机分配角色

    public void Game_Main(){
        startGame();
        while (!checkEnd()) {  // can use game status
            output("Round " + round++);
            for (Player p : players) {
                output("Your round begins");
                runPhase(p);
                if (checkEnd()) {
                    endGame();
                }
            }
        }
        endGame();
    }

    public void startGame(){
        CardsHeap.init();
        shuffleRoles();
        int numPlayers = 5;
        roles.put("Captain", new ArrayList<>());
        roles.put("Criminal", new ArrayList<>());
        roles.put("Police", new ArrayList<>());
        roles.put("Corpo", new ArrayList<>());
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player());
            players.get(i).setRole(rolemap.get(i));
            roles.get(rolemap.get(i)).add(players.get(i));
            drawCards(players.get(i), 4);
        }
        roles.get("Captain").get(0).sethp(4);
    }

    public void shuffleRoles(){
        rolemap.addAll(List.of("Captain","Police", "Criminal", "Criminal", "Corpo"));
        Random r = new Random();
        for(int i = 4; i >= 1 ; i--){
            swap(rolemap, i, r.nextInt(i));
        }
    }

    public void endGame(){
        System.exit(0);
    }

    public boolean checkEnd() {
        if (isExtinct("Captain") && isExtinct("Criminal") && isExtinct("Police")){
            output("Corpo Win!");
            return true;
        } else if(isExtinct("Captain") && !isExtinct("Criminal")){
            output("Criminal Win!");
            return true;
        }else if(!isExtinct("Captain") && isExtinct("Criminal") && isExtinct("Corpo")) {
            output("Police Win!");
            return true;
        }
        return false;
    }

    public boolean isExtinct(String role){
        return roles.get(role).isEmpty();
    }

    //添加判断人员死亡
    public void runPhase(Player player) {
        if(!player.isAlive()){
            return;
        }
        drawPhase(player);
        playPhase(player);
        if(player.gethp() < player.get_pocketcards().size()){
            throwPhase(player);
        }
        endPhase();
    }

    public void drawPhase(Player player){
        output("Draws 2 cards from cards heap");
        drawCards(player, 2);
    }

    public void drawCards(Player player, int num) {
        player.addToHand(draw(num));
    }

    public void playPhase(Player player){

    }

    private void useCard(int num) {
    }

    public void throwPhase(Player player){
        int num = player.get_pocketcards().size() - player.gethp();
        output("You need to throw " + num + " cards" );
        for(int i = 0; i < num; i++){
            output("choose a number");
            int card =  input() -1;
            player.loosCard(card);
        }
    }

    private void endPhase() {
        System.out.println("This turn ends.");
    }

    public static List<Player> getPlayers(){
        return players;
    }


}
