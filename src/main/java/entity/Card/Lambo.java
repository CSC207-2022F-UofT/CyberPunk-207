package entity.Card;

import entity.Card.Card;

/**
 * Implementation of equipment card Car that when equipped by the source player
 * adds one distance when calculating target player's playing distance with the source player
 */
public class Lambo extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    @Override
    public void use() {
        getSource().putOnEquipment("Plus", this.toString());
    }

    @Override
    public String toString(){
        return "Lambo";
    }
}
