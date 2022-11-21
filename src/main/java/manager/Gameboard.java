package manager;

import entity.Card;
import entity.Player;
import gateway.Cardsheap;

import java.io.PrintStream;
import java.util.ArrayList;

public class Gameboard {
    private ArrayList<Player> players = new ArrayList<>();
    private static int round = 1;
    private int numPlayers = 5;
    private static Player Captin = new Player();
    //setroles 随机分配角色

    public void Game_Main(){
        startGame();
        while (!checkEnd()) {
            System.out.println("round " + round++);
            for (Player p : players) {
                System.out.println("Your round begins");
                p.runPhase();
                if (checkEnd()) {
                    endGame();
                }
            }
        }
        endGame();
    }

    public void startGame(){
        Cardsheap.init();
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player());
        }
        for(Player player: players) {;
            player.drawCards(4);
        }
    }

    public void endGame(){
        System.exit(0);
    }

    public static boolean checkEnd() {
        if (!Captin.isAlive()){
            System.out.println("Criminal Win!");
            return true;
        }
        return false;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

}
