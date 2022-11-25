package entity;

public abstract class Card {
    private PlayerModel target;
    private PlayerModel source;

    public abstract boolean needTarget();


    public PlayerModel getTarget() {
        return target;
    }

    public void setTarget(PlayerModel target) {
        this.target = target;
    }

    public PlayerModel getSource() {
        return source;
    }

    public void setSource(PlayerModel source) {
        this.source = source;
    }

    public abstract void use();

}
