package entity.Card;


/**
 * Implementation of card Medkit that restore one health to the source player
 */
public class Medkit extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

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
