package entity;

public class R99MachineGun extends equipment_card{
    @Override
    public Object use(){
        return true;
    }

    @Override
    public String toString(){
        return "R99 Machine Gun";
    }
}
