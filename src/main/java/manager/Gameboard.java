package manager;

import entity.Card;
import entity.Player;
import gateway.Cardsheap;

import java.io.PrintStream;
import java.util.*;

import static gateway.Cardsheap.draw;
import static java.util.Collections.swap;

public class Gameboard {
    private static Player player;
    private static List<Player> players = new ArrayList<>();
    private static int round = 1;
    private static Player Captin;
    private HashMap<String, Player> roles;
    private List<String> rolemap = new ArrayList<>();


    public static void setCaptin(Player captin) {
        Captin = captin;
    }
    //setroles 随机分配角色

    public void Game_Main(){
        startGame();
        while (!checkEnd()) {
            System.out.println("round " + round++);
            for (Player p : players) {
                System.out.println("Your round begins");
                runPhase();
                if (checkEnd()) {
                    endGame();
                }
            }
        }
        endGame();
    }

    public void startGame(){
        Cardsheap.init();
        shuffleRoles();
        int numPlayers = 5;
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player());
            players.get(i).setRole(rolemap.get(i));
            roles.put(rolemap.get(i), players.get(i));
        }
        for(Player player: players) {;
            drawCards(4);
        }
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
        if (!Captin.isAlive()){
            System.out.println("Criminal Win!");
            return true;
        }
        return false;
    }

    public void runPhase() {
        if(!this.isAlive()){
            return;
        }
        drawPhase();
        playPhase();
        if(hp < pocketcards.size()){
            throwPhase();
        }
        endPhase();
    }


    public void drawPhase(){
        System.out.println("Draws 2 cards from cards heap");
        drawCards(2);
    }

    public void drawCards(Player player, int num) {
        player.addCard(draw(2));
    }


    public void playPhase(){
        String order = "";
        while (order != "skip"){
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose a number or skip");
            order = scanner.next();
            useCard(Integer.parseInt(order));
            scanner.close();

        }

    }

    private void useCard(int num) {
    }


    public void throwPhase(){
        int num = pocketcards.size() - this.hp;
        System.out.println("You need to throw " + num + " cards" );
        for(int i = 0; i < num; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose a number");
            String card = scanner.next();
            loosCard(Integer.parseInt(card));
            scanner.close();
        }

    }

    private void loosCard(int card) {
        pocketcards.remove(card);
    }

    private void endPhase() {
        System.out.println("This round ends.");
    }



}
