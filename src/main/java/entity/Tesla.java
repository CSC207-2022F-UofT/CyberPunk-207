package entity;

public class Tesla extends equipment_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    @Override
    public void use() {
        getSource().putOnEquipment("Minus", this);
    }

    @Override
    public String toString(){
        return "Tesla";
    }
}

