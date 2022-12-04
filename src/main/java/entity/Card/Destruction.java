package entity.Card;

import entity.Card.Card;

/**
 * Implementation of the card Destruction which forces the target player to lose a card from their deck
 */
public class Destruction extends Card {

    @Override
    public boolean needTarget() {
        return true;
    }

    @Override
    public void use() {
        if (getTarget().getPocketcards().size() > 0) {
            getTarget().loosCard(0);
        }
    }

    @Override
    public String toString() {
        return "Destruction";
    }
}
