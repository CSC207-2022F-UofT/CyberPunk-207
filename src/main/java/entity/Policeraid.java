package entity;

import manager.Gameboard;

public class Policeraid extends strategy_card{

    @Override
    public void use(){
        for (Player p : Gameboard.get_players()) {
            if (p != getSource() && p.request_shoot == null) {   //TODO: 怎么要求其他人出牌
                p.hurted(1);
            }
        }
    }

}
