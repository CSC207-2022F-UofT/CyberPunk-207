package entity;

public class Shoot extends BasicCard {

    @Override
    public boolean needTarget() {
        return true;
    }

    public void use(){
        if (getTarget().whetherHasDodge()){
                getTarget().hurt(1);
            }
    }

    @Override
    public String toString(){
        return "Shoot";
    }
}
