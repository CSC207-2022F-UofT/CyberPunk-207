package manager;

import entity.Card;
import entity.Shoot;


public class AIPlayer extends PlayerManager{
    public AIPlayer(int playerNO, Gameboard gameboard) {
        super(playerNO, gameboard);
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
            card.setTarget(Gameboard.getPlayers().get(playerNO));
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
