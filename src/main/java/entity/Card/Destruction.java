package entity.Card;

import entity.Card.Card;

public class Destruction extends Card {
    @Override
    public boolean needTarget() {
        return true;
    }

    @Override
    public void use() {
        if (getTarget().getPocketcards().size() > 0) {
            getTarget().loosCard(0);
        }
    }

    @Override
    public String toString() {
        return "Destruction";
    }
}
