package manager;

import entity.Card;
import entity.PlayerModel;
import entity.Shoot;

import static gateway.CardsHeap.draw;

public abstract class PlayerManager {
    protected PlayerModel playerModel;
    protected int playerNO;
    protected Gameboard gameboard;
    protected Identity role;

    public PlayerManager(int playerNO, Gameboard gameboard) {
        this.playerModel = new PlayerModel();
        this.playerNO = playerNO;
        this.gameboard = gameboard;
    }

    public abstract void playCard();

    public abstract void useCard(int num);

    public abstract void throwCard();

    public void drawCards( int num) {
        playerModel.addToHand(draw(num));
    }

    public void loosCard(int card) {
        playerModel.loosCard(card);
    }

    public void setHp(int i) {
        playerModel.setHp(i);
    }

    public int getHp(){
        return playerModel.getHp();
    }

    public boolean isAlive() {
        return playerModel.isAlive();
    }

    public void isDead(){
        playerModel.setAlive(false);
    }

    public Identity getRole() {
        return role;
    }

    public void setRole(Identity role) {
        this.role = role;
    }

    public int needThrow() {
        return playerModel.getPocketcards().size() - playerModel.getHp();
    }

    public String getPlayerNO() {
        return "Player" + playerNO;
    }

    public PlayerModel getPlayer() {
        return playerModel;
    }



}
