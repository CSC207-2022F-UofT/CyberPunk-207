package entity.Card;


/**
 * Implementation of equipment card R99MachineGun when equipped
 * allows the source player to use unlimited shoots in their round
 */
public class R99MachineGun extends Card {

    @Override
    public boolean needTarget() {
        return false;
    }
    
    /**
     * Put on equipment "Weapon" for source player.
     * The program will automatically consider this equipment in the future movements.
     */

    public void use(){
        getSource().putOnEquipment("Weapon", this.toString());
    }

    @Override
    public String toString(){
        return "R99 Machine Gun";
    }
}
