package entity.Card;

import entity.Card.Card;
import manager.Gameboard;
import manager.PlayerManager;

/**
 * Implementation of card Traumateam that adds one health to all the players on the Gameboard
 */
public class Traumateam extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (PlayerManager p : Gameboard.getPlayers()) {
            if (p.getHp() < p.getMaxHp()){
                p.heal(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Traumateam";
    }
}
