package entity;

public class Medkit extends BasicCard {
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        if (getSource().getHp() < getSource().getMaxHp()){
            getSource().heal(1);
        }
    }

    @Override
    public String toString() {
        return "Medkit";
    }


}
