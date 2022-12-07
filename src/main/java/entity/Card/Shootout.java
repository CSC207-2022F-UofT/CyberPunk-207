package entity.Card;

import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

/**
 * Implementation of card Shootout that requires all player on the Gameboard to play dodge or lose one health
 */
public class Shootout extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    /**
     * For all players in game, if the player is not source player and the player has no dodge, the player lose one hp.
     */
    @Override
    public void use(){
        for (Player p : getPlayers()) {
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
