package entity.Card;

public class Destruction extends Card {
    @Override
    public boolean needTarget() {
        return true;
    }

    @Override
    public void use() {
        if (getTarget().getPocketCards().size() > 0) {
            getTarget().looseCard(0);
        }
    }

    @Override
    public String toString() {
        return "Destruction";
    }
}
