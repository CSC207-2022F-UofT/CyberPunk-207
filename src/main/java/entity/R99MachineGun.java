package entity;

public class R99MachineGun extends equipment_card{

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
