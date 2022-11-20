package entity;

public class CarBomb extends equipment_card{
    @Override
    public Object use(){
        return true;
    }

    @Override
    public String toString(){
        return "Car Bomb";
    }
}