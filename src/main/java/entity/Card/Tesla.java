package entity.Card;

import entity.Card.Card;

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

