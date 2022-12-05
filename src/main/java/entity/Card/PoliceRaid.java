package entity.Card;



import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

public class PoliceRaid extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        for (Player p : getPlayers()) {
            if (p != getSource() && !p.whetherHasShoot() ) {
                p.hurt(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Policeraid";
    }

}
