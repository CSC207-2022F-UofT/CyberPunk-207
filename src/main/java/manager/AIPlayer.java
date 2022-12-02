package manager;

import entity.Card;
import entity.Shoot;
import entity.Status;

import static manager.Gameboard.getPlayers;


public class AIPlayer extends PlayerManager{
    public AIPlayer(int playerNO, Gameboard gameboard, Status status) {
        super(playerNO, gameboard, status);
    }

    @Override
    public void playCard() {
        if (isAlive()){
            useCard(0);
            }
    }

    @Override
    public void useCard(int num) {
        Card card = getPocketcards().get(num);
        card.setSource(this);
        if(card.needTarget()){
            card.setTarget(getPlayers().get(playerNO));
        }
        //System.out.println(player.getPocketcards());
        card.use();
        loosCard(num);
        //System.out.println(player.getPocketcards());
        //output(card.toString());
    }

    @Override
    public void throwCard() {
        loosCard(0);
    }
}
