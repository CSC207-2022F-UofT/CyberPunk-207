package entity.Card;


/**
 * Implementation of equipment card Car that when equipped by the source player
 * minus one distance when calculating the source player's playing distance against target players
 */
public class Tesla extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    @Override
    public void use() {
        getSource().putOnEquipment("Minus", this.toString());
    }

    @Override
    public String toString(){
        return "Tesla";
    }
}

