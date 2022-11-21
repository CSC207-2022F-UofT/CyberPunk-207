package entity;

import manager.Gameboard;

public class Traumateam extends strategy_card{
    public void use(){
        for (Player p : Gameboard.get_players()) {
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
