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

    public void use(){
        for (Player p : getPlayers()) {
            if (p.getHp() < p.getMaxHp()){
                p.heal();
            }
        }
    }

    @Override
    public String toString() {
        return "Traumateam";
    }
}
