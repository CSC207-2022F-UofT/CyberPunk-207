package manager;

import entity.Card;
import entity.Player;
import gateway.CardsHeap;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Gameboard {
    private static Player player;
    private static List<Player> players = new ArrayList<>();
    private static int round = 1;
    private static Player Captin;
    private CardsHeap cardsheap;

    public static void setCaptin(Player captin) {
        Captin = captin;
    }
    //setroles 随机分配角色

    public static void Game_Main(){
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

    public static void startGame(){
        CardsHeap cardsheap = new CardsHeap();
        int numPlayers = 5;
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(cardsheap));
        }
        for(Player player: players) {;
            player.drawCards(4);
        }
    }

    public static void endGame(){
        System.exit(0);
    }

    public static boolean checkEnd() {
        if (!Captin.isAlive()){
            System.out.println("Criminal Win!");
            return true;
        }
        return false;
    }




}
