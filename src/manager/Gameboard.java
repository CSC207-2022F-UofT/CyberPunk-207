package manager;

import entity.Card;
import entity.Player;
import gateway.CardsHeap;

import java.util.ArrayList;

public class Gameboard {
    private ArrayList<Player> players = new ArrayList<>();
    private static int round = 1;
    private int numPlayers = 5;
    //setroles 随机分配角色

    public void Game_Main(){
        try {
            startGame();
            while (!gameIsEnd()) {
                IO.println("round " + round++);
                for (Person p : players) {
                    currentPerson = p;
                    p.run();
                    if (gameIsEnd()) {
                        endGame();
                        return;
                    }
                    Utils.checkCardsNum();
                    currentIOrequest = "";
                }
            }
            endGame();

        } catch (NoSuchElementException e) {
            panic("\nno line found");
        }
    }

    public void startGame(){
        CardsHeap.init();
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player();
        }
        for(Player player: players) {
            player.drawCards(4);
        }
    }



}
