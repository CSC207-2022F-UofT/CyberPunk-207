package entity.Card;

import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

public class Traumateam extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (Player p : getPlayers()) {
            if (p.getHp() < p.getMaxHp()){
                p.heal(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Traumateam";
    }
}
