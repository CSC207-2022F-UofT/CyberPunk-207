package entity.Card;

/**
 * Implementation of equipment card Car that when equipped by the source player
 * Add one distance when calculating target player's playing distance with the source player
 */
public class Lambo extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    /**
     * Put on equipment "Plus" for source player.
     * The program will automatically consider this equipment in the future movements.
     */
    @Override
    public void use() {
        getSource().putOnEquipment("Plus", this.toString());
    }

    @Override
    public String toString(){
        return "Lambo";
    }
}
