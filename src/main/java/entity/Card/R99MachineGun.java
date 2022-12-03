package entity.Card;

import entity.Card.Card;

public class R99MachineGun extends Card {

    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        getSource().putOnEquipment("Weapon", this.toString());
    }

    @Override
    public String toString(){
        return "R99 Machine Gun";
    }
}
