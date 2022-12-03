package entity.Card;

import entity.Card.Card;

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
