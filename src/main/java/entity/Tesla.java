package entity;

public class Tesla extends EquipmentCard {
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

