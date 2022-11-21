package entity;

import java.util.Random;

public class Robbery extends strategy_card {
    @Override
    public boolean needTarget() {
        return true;
    }

    public void use() {
        if (getTarget().get_pocketcards().size() > 0){
            getSource().addToHand(getTarget().get_pocketcards().get(0));
            getTarget().removeCard(getTarget().get_pocketcards().get(0));
        }
    }

    @Override
    public String toString() {
        return "Robbery";
    }
}
    
