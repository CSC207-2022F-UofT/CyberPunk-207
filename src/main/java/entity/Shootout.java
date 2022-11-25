package entity;

import manager.Gameboard;

public class Shootout extends strategy_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (Player p : Gameboard.getPlayers()) {
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
