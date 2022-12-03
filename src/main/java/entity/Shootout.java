package entity;

import manager.Gameboard;
import manager.PlayerManager;

public class Shootout extends StrategyCard {
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
