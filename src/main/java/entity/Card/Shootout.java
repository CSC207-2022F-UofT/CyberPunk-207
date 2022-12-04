package entity.Card;

import entity.Card.Card;
import manager.Gameboard;
import manager.PlayerManager;

/**
 * Implementation of card Shootout that requires all player on the Gameboard to play dodge or lose one health
 */
public class Shootout extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (PlayerManager p : Gameboard.getPlayers()) {
            if (p != getSource() && p.whetherHasDodge()){
                p.hurt(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Shootout";
    }
}
