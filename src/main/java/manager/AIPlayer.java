package manager;

import entity.Card;
import entity.Shoot;

import static manager.Gameboard.getPlayers;

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
        Card card = playerModel.getPocketcards().get(num);
        card.setSource(playerModel);
        if(card.needTarget()){
            card.setTarget(getPlayers().get(playerNO));
        }
        //System.out.println(player.getPocketcards());
        card.use();
        playerModel.loosCard(num);
        //System.out.println(player.getPocketcards());
        //output(card.toString());
    }

    @Override
    public void throwCard() {
        loosCard(0);
    }
}
