package entity.Card;



import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

/**
 * Implementation of card PoliceRaid that forces all players on the Gameboard to play Shoot or lose one health
 */
public class PoliceRaid extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (Player p : getPlayers()) {
            if (p != getSource() && !p.whetherHasShoot() ) {
                p.hurt(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Policeraid";
    }

}
