package entity;

import manager.Gameboard;

public class Traumateam extends strategy_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (Player p : Gameboard.getPlayers()) {
            if (p.gethp() < p.getmaxhp()){
                p.recover(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Traumateam";
    }
}
