package entity.Card;

/**
 * Implementation of the card Destruction which forces the target player to throw one card.
 */
public class Destruction extends Card {
    @Override
    public boolean needTarget() {
        return true;
    }

    /**
     * First identify whether the target player has cards in hand.
     * If so, force the player to throw one card.
     */
    @Override
    public void use() {
        if (getTarget().getPocketCards().size() > 0) {
            getTarget().looseCard(0);
        }
    }

    @Override
    public String toString() {
        return "Destruction";
    }
}
