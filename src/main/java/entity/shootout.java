package entity;

import manager.Gameboard;

public class shootout extends strategy_card{
    public void use(){
        for (Player p : Gameboard.get_players()) {
            if (p != getSource() && !p.check_dodge()){//TODO: 如何判定其他人是否出牌)
                p.hurted(1);
            }
        }
    }
}

