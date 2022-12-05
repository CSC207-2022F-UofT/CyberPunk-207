package entity.Card;

import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

public class Shootout extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (Player p : getPlayers()) {
            if (p != getSource() && p.whetherHasDodge()){
                p.hurt(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Shootout";
    }
}
