package entity;

import manager.Gameboard;

public class police_raid extends strategy_card{
    public void use(){
        for (Player p : Gameboard.get_players()) {
            if (p != getSource() && p.request_shoot == null) {   //TODO: 怎么要求其他人出牌
                p.hurted(1);
            }
        }
    }
}
