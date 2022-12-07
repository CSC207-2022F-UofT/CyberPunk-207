package entity.Card;

/**
 * Implementation of the card Dodge which allows the source player to dodge a shoot card
 * Currently the program automatically play dodge if the player is attacked by shoot
 */
public class Dodge extends Card {
    @Override
    public boolean needTarget() {
        return false;
    }

    @Override
    public void use(){}
    @Override
    public String toString(){
        return "Dodge";
    }
}
