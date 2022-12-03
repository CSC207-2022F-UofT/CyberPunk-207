package entity.Card;

import entity.Card.Card;
import manager.Gameboard;
import manager.PlayerManager;

public class PoliceRaid extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (PlayerManager p : Gameboard.getPlayers()) {
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
