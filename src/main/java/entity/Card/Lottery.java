package entity.Card;
import static entity.CardsHeap.draw;

/**
 * Implementation of card lottery that adds two cards to the source player's hand
 */
public class Lottery extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    /**
     * Draw 2 card from card heap and add them to the source player's hand
     */
    public void use(){
        getSource().addToHand(draw(2));
    }

    @Override
    public String toString() {
        return "Lottery";
    }
}
