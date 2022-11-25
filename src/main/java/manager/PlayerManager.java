package manager;

import entity.Card;
import entity.Player;
import entity.Shoot;
import entity.equipment_card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static Controller.GameController.input;
import static gateway.CardsHeap.draw;

public class PlayerManager {
    private Player player;
    private int playerNO;
    private Gameboard gameboard;
    private Identity role;

    public PlayerManager(int playerNO, Gameboard gameboard) {
        this.player = new Player();
        this.playerNO = playerNO;
        this.gameboard = gameboard;
    }

    public void playCard(){
        int order = gameboard.askOrder();
        if(order == -1){
            return;
        } else{
            useCard(order);
        }

    }

    public void useCard(int num) {
        Card card = player.getPocketcards().get(num);
        card.setSource(player);
        gameboard.askTarget(card);
        if(card instanceof Shoot){
            if(player.isUseShoot() && player.getEquipment().get("Weapon") == null){
                //output("shoot used, try another card");
                return;
            } else{
                player.setUseShoot(true);
            }
        }
        //System.out.println(player.getPocketcards());
        card.use();
        player.loosCard(num);
        //System.out.println(player.getPocketcards());
        //output(card.toString());
    }


    public void drawCards( int num) {
        player.addToHand(draw(num));
    }

    public void loosCard(int card) {
        player.loosCard(card);
    }

    public void setHp(int i) {
        player.setHp(i);
    }

    public int getHp(){
        return player.getHp();
    }

    public boolean isAlive() {
        return player.isAlive();
    }

    public void isDead(){
        player.setAlive(false);
    }

    public Identity getRole() {
        return role;
    }

    public void setRole(Identity role) {
        this.role = role;
    }

    public int needThrow() {
        return player.getPocketcards().size() - player.getHp();
    }

    public String getPlayerNO() {
        return "Player" + playerNO;
    }

    public Player getPlayer() {
        return player;
    }



}
