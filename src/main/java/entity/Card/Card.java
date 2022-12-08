package entity.Card;
import entity.Player;

/**
 * Abstract class card with card functions to be implemented.
 */
public abstract class Card {

    /** A Player attribute representing the target of the card */
    private Player target;
    /** A Player attribute representing the source of the card, or the player holding the card */
    private Player source;

    /**
     * Return a boolean indicating whether the card needs a target.
     * Abstract function, to be implemented by child classes
     */
    public abstract boolean needTarget();

    /**
     * Set the target player of this card
     * @param target: target Player that the card is used towards
     */
    public void setTarget(Player target) {
        this.target = target;
    }

    /**
     * Set the target player of this card
     * @param source: Source Player that the card is used from
     */
    public void setSource(Player source) {
        this.source = source;
    }

    /**
     * Return the target player of the card.
     */
    public Player getTarget() {
        return target;
    }

    /**
     * Return the source player of the card.
     */
    public Player getSource() {
        return source;
    }

    /**
     * Use function of a card
     * Abstract function, to be implemented by child classes
     */
    public abstract void use();

}
