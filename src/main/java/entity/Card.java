package entity;

public abstract class Card {
    private Player target;
    private Player source;

    public abstract boolean needTarget();


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

    public abstract void use();

}
