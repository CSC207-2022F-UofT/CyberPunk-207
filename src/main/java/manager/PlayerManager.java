package manager;

import entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static gateway.CardsHeap.draw;

public abstract class PlayerManager {
    protected PlayerModel playerModel;
    protected int playerNO;
    protected Gameboard gameboard;
    protected Identity role;
    protected List<Listener> listeners = new ArrayList<>();

    public PlayerManager(int playerNO, Gameboard gameboard) {
        this.playerModel = new PlayerModel();
        this.playerNO = playerNO;
        this.gameboard = gameboard;
    }

    public abstract void playCard();

    public abstract void useCard(int num);

    public abstract void throwCard();

    public void drawCards( int num) {
        addToHand(draw(num));
        notifyHand(playerModel.getPocketcards());
        notifyHandSize(playerModel.getPocketcards());
    }

    public void loosCard(int card) {
        playerModel.loosCard(card);
        notifyHand(playerModel.getPocketcards());
        notifyHandSize(playerModel.getPocketcards());
    }

    public void setHp(int i) {
        playerModel.setHp(i);
        notifyHp(i);
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

    public void subscribe(Listener listener){
        this.listeners.add(listener);
    }

    public void unsubscribe(Listener listener){
        this.listeners.remove(listener);
    }

    public void notifyHp(int hp){
        for (Listener listener : listeners) {
            listener.updateHp(hp);
        }
    }
    public void notifyHand(ArrayList<Card> cards){
        for (Listener listener : listeners) {
            listener.updateHand(cards);
        }
    }

    public void notifyHandSize(ArrayList<Card> cards){
        for (Listener listener : listeners) {
            listener.updateHandSize(cards.size());
        }
    }
    public void notifyEquipment(String type, equipment_card card){
        for (Listener listener : listeners) {
            listener.updateEquipment(type, card);
        }
    }
    public ArrayList<Card> getPocketcards(){
        return playerModel.getPocketcards();
    }

    public void addToHand(Card c){
        playerModel.addToHand(c);
    }

    public void addToHand(ArrayList<Card> cards){
        playerModel.addToHand(cards);
    }

    public void hurt(int i){
        playerModel.hurt(i);
        notifyHp(getHp());
    }

    public void heal(int i){
        playerModel.heal(i);
        notifyHp(getHp());
    }

    public void putOnEquipment(String type, equipment_card card){
        playerModel.putOnEquipment(type, card);
        notifyEquipment(type, card);
    }

    public boolean whether_has_dodge(){
        return playerModel.whether_has_dodge();
    }
    public void removeCard(Card c){
        playerModel.removeCard(c);
    }

    public boolean whether_has_shoot(){
        return playerModel.whether_has_shoot();
    }

    public int getmaxhp(){
        return playerModel.getmaxhp();
    }

    public HashMap<String, equipment_card> getEquipment() {
        return playerModel.getEquipment();
    }
}
