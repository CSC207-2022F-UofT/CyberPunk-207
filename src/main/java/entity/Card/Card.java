package entity.Card;

import manager.PlayerManager;

/**
 * Abstract class of all the cards in our game
 */

public abstract class Card {

    private PlayerManager target;
    private PlayerManager source;


    /**
     * @return whether the card needs a target
     */
    public abstract boolean needTarget();

    /**
     * Returns the targeted player as a PlayerManager class
     * @return target of the card
     */
    public PlayerManager getTarget() {
        return target;
    }

    /**
     * Set the card's targeted player as the parameter
     * @param target PlayerManager class that sets the card's target
     */
    public void setTarget(PlayerManager target) {
        this.target = target;
    }

    /**
     * Returns the source player that played this card as a PlayerManager Class
     * @return source of the card
     */
    public PlayerManager getSource() {
        return source;
    }

    /**
     * Set the card's source player as the parameter
     * @param source PlayerManager class that sets the card's source
     */
    public void setSource(PlayerManager source) {
        this.source = source;
    }


    /**
     * Abstract method that will be overridden based on each card's function
     */
    public abstract void use();

}
