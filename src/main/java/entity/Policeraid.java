package entity;

import manager.Gameboard;

public class Policeraid extends strategy_card{
    public void use(){
        for (Player p : Gameboard.getPlayers()) {
            if (p != getSource() && !p.whether_has_dodge() ) {
                p.hurted(1);
            }
        }
    }

    @Override
    public String toString() {
        return null;
    }

}
