package entity;

import java.util.ArrayList;

public abstract class Card {
    private Player target;
    private Player source;
    private boolean isTaken = false;//can use observer pattern
    private ArrayList<Card> thisCard = new ArrayList<>();// try to use entity gateway

    public void setThisCard(ArrayList<Card> thisCard) {
        this.thisCard = thisCard;
    }

    public void setThisCard(Card thisCard) {
        ArrayList<Card> cs = new ArrayList<>();
        cs.add(thisCard);
        this.thisCard = cs;
    }

    public ArrayList<Card> getThisCard() {
        return thisCard;
    }

    // Getter functions
    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public Player getSource() {
        return source;
    }

    public void setSource(Player source) {
        this.source = source;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    // Card usage functions:

    public abstract String toString();
    public Player selectTarget(Player player) {
        source = player;
        //target = player.selectPlayer(false);  //Need to call entity
        return target;
    }

}
