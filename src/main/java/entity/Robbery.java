package entity;

public class Robbery extends StrategyCard {
    @Override
    public boolean needTarget() {
        return true;
    }

    public void use() {
        if (getTarget().getPocketcards().size() > 0){
            Card card = getTarget().getPocketcards().get(0);
            getSource().addToHand(card);
            getTarget().removeCard(card);
        }
    }

    @Override
    public String toString() {
        return "Robbery";
    }
}
    
