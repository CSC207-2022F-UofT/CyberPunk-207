package manager;

import entity.Card.Card;


public class AIStrategy implements playStrategy{
    Gameboard gameboard;
    PlayerManager player;

    public AIStrategy(Gameboard gameboard, PlayerManager player) {
        this.gameboard = gameboard;
        this.player = player;
    }

    @Override
    public void playCard() {
        if (player.isAlive()){
            useCard(0);
            }
    }

    @Override
    public void useCard(int num) {
        Card card = player.getPocketcards().get(num);
        card.setSource(player);
        if(card.needTarget()){
            useCard(num + 1);
            return;
        }
        card.use();
        player.loosCard(num);
    }

    @Override
    public void throwCard() {
        player.loosCard(0);
    }
}
