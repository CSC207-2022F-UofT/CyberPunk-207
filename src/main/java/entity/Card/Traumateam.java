package entity.Card;

import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

/**
 * Implementation of card Traumateam that adds one health to all the players on the Gameboard
 */
public class Traumateam extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    /**
     * For all players in game, if the player's hp is smaller than maximum hp, add one hp.
     */
    @Override
    public void use(){
        for (Player p : getPlayers()) {
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
