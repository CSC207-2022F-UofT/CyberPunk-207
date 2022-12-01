package entity;

import manager.Gameboard;
import manager.PlayerManager;

public class Traumateam extends strategy_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (PlayerManager p : Gameboard.getPlayers()) {
            if (p.getHp() < p.getmaxhp()){
                p.heal(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Traumateam";
    }
}
