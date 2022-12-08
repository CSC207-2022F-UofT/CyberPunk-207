package entity.Card;


/**
 * Implementation of card Medkit that restore one health to the source player
 */
public class Medkit extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }
    
    /**
     * First identify if current hp of source player is smaller than the maximum hp.
     * If so, add one hp to the source player.
     */

    public void use(){
        if (getSource().getHp() < getSource().getMaxHp()){
            getSource().heal();
        }
    }

    @Override
    public String toString() {
        return "Medkit";
    }


}
