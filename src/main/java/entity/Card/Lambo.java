package entity.Card;

import entity.Card.Card;

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
