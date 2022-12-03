package entity;

import manager.Gameboard;
import manager.PlayerManager;

public class Traumateam extends StrategyCard {
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
