package entity;

public class R99MachineGun extends EquipmentCard {

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
