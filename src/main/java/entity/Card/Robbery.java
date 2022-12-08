package entity.Card;

/**
 * Implementation of strategy card Robbery, which steals one card from the target player.
 */
public class Robbery extends Card {
    @Override
    public boolean needTarget() {
        return true;
    }

    /**
     * If the target player has pocket cards, add the target player's first pocket card into source player's hand
     * Then let target player lose that card.
     */
    @Override
    public void use() {
        if (getTarget().getPocketCards().size() > 0){
            Card card = getTarget().getPocketCards().get(0);
            getSource().addToHand(card);
            getTarget().looseCard(card);
        }
    }

    @Override
    public String toString() {
        return "Robbery";
    }
}
    
