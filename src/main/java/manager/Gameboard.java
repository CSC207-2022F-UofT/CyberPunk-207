package manager;

import entity.Card;
import entity.Player;
import entity.Shoot;
import gateway.CardsHeap;

import java.util.*;

import static gateway.CardsHeap.draw;
import static java.util.Collections.checkedSet;
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


    public void Game_Main(){
        startGame();
        while (!checkEnd()) {  // can use game status
            output("Round " + round++);
            for (Player p : players) {
                output("Your round begins");
                System.out.println(p.gethp());
                runPhase(p);
                System.out.println(p.gethp());
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

    public void runPhase(Player player) {
        if(!player.isAlive()){
            output("I'm dead");
            return;
        }
        drawPhase(player);
        System.out.println(player.get_pocketcards());
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
        while(player.isAlive()){
            output("num for cards, 0 for end turn");
            int order = input();
            if(order == 0){
                return;
            } else{
                order = order - 1;
            }
            useCard(player, order);
        }
    }

    public void useCard(Player player, int num) {
        Card card = player.get_pocketcards().get(num);
        card.setSource(player);
        if(card.needTarget()){
            output("choose your target");
            int target = input() - 1;
            card.setTarget(players.get(target));
            if (calDis(card.getSource(), card.getTarget()) > 1) {
                output("out of range, try again");
                return;
            }
        }
        if(card instanceof Shoot){
            if(player.isUseShoot() && player.getEquipment().get("Weapon") == null){
                output("shoot used, try another card");
                return;
            } else{
                player.setUseShoot(true);
            }
        }
        System.out.println(player.get_pocketcards());
        card.use();
        player.loosCard(num);
        System.out.println(player.get_pocketcards());
        output(card.toString());
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

    public void endPhase() {
        System.out.println("This turn ends.");
    }

    public int calDis(Player player1, Player player2){
        int pos1 = players.indexOf(player1);
        int pos2 = players.indexOf(player2);
        int dis = Math.max(pos1 - pos2, pos2 - pos1);
        dis = Math.min(dis, 5 - dis);
        if (player1.getEquipment().get("Minus") != null){
            dis -= 1;
        }
        if (player2.getEquipment().get("Plus") != null){
            dis += 1;
        }
        return dis;
    }


    public static List<Player> getPlayers(){
        return players;
    }


}
