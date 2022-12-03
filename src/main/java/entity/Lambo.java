package entity;

public class Lambo extends EquipmentCard {
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
