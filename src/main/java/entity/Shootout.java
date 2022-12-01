package entity;

import manager.Gameboard;
import manager.PlayerManager;

public class Shootout extends strategy_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (PlayerManager p : Gameboard.getPlayers()) {
            if (p != getSource() && p.whether_has_dodge()){
                p.hurt(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Shootout";
    }
}
