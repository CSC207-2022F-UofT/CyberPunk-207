package entity.Card;

import entity.Card.Card;

/**
 * Implementation of card Robbery that allows the source player to steal a card from the target player's deck
 */
public class Robbery extends Card {
    @Override
    public boolean needTarget() {
        return true;
    }

    public void use() {
        if (getTarget().getPocketcards().size() > 0){
            Card card = getTarget().getPocketcards().get(0);
            getSource().addToHand(card);
            getTarget().removeCard(card);
        }
    }

    @Override
    public String toString() {
        return "Robbery";
    }
}
    
