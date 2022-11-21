package entity;

import manager.Gameboard;

public class Shootout extends strategy_card{
    public void use(){
        for (Player p : Gameboard.get_players()) {
            if (p != getSource() && !p.whether_has_dodge()){
                p.hurted(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Shootout";
    }
}
