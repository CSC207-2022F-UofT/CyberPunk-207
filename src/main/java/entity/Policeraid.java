package entity;

import manager.Gameboard;
import manager.PlayerManager;

public class Policeraid extends strategy_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (PlayerManager p : Gameboard.getPlayerManager()) {
            if (p != getSource() && !p.whether_has_shoot() ) {
                p.hurt(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Policeraid";
    }

}
