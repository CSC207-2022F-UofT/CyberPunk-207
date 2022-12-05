package entity.Card;

public class Robbery extends Card {
    @Override
    public boolean needTarget() {
        return true;
    }

    public void use() {
        if (getTarget().getPocketCards().size() > 0){
            Card card = getTarget().getPocketCards().get(0);
            getSource().addToHand(card);
            getTarget().looseCard(card);
        }
    }

    @Override
    public String toString() {
        return "Robbery";
    }
}
    
