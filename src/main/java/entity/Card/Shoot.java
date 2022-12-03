package entity.Card;

import entity.Card.Card;

public class Shoot extends Card {

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
