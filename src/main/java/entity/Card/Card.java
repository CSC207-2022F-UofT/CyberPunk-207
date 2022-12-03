package entity.Card;

import manager.PlayerManager;

public abstract class Card {
    private PlayerManager target;
    private PlayerManager source;

    public abstract boolean needTarget();


    public PlayerManager getTarget() {
        return target;
    }

    public void setTarget(PlayerManager target) {
        this.target = target;
    }

    public PlayerManager getSource() {
        return source;
    }

    public void setSource(PlayerManager source) {
        this.source = source;
    }

    public abstract void use();

}