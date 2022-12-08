package entity.Card;


/**
 * Implementation of card shoot that requires the target player to play dodge or lose one health
 */
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
