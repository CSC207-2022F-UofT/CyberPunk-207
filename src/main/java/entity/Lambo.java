package entity;

public class Lambo extends equipment_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    @Override
    public void use() {
        getSource().putOnEquipment("Plus", this);
    }

    @Override
    public String toString(){
        return "Lambo";
    }
}
