package manager;

import entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static gateway.CardsHeap.draw;

public class PlayerManager {
    protected PlayerModel playerModel;
    protected int playerNO;
    protected Gameboard gameboard;
    protected Identity role;
    protected Status status;
    private playStrategy playStrategy;

    public PlayerManager(int playerNO, Gameboard gameboard, Status status) {
        this.playerModel = new PlayerModel();
        this.playerNO = playerNO;
        this.gameboard = gameboard;
        this.status = status;
    }

    public void setStrategy(String strategy) {
        if(strategy.equals("Human")){
            this.playStrategy = new HumanStrategy(gameboard, this);
        }else if (strategy.equals("AI")){
            this.playStrategy = new AIStrategy(gameboard, this);
        }

    }

    public void playCard(){
        try{playStrategy.playCard();
        } catch (NullPointerException e) {
            gameboard.displayInstruction("No strategy set");
        }
    }

    public void throwCard(){
        try{playStrategy.throwCard();
        } catch (NullPointerException e) {
            gameboard.displayInstruction("No strategy set");
        }
    }

    public void drawCards( int num) {
        addToHand(draw(num));
        notifyHand();
        notifyHandSize();
    }

    public void loosCard(int card) {
        playerModel.loosCard(card);
        notifyHand();
        notifyHandSize();
    }

    public int getHp(){
        return playerModel.getHp();
    }

    public void setHp(int i) {
        playerModel.setHp(i);
        notifyHp(getHp());
    }

    public void hurt(int i){
        playerModel.hurt(i);
        notifyHp(getHp());
    }

    public void heal(int i){
        playerModel.heal(i);
        notifyHp(getHp());
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

    public int getPlayerNO() {
        return playerNO;
    }

    public PlayerModel getPlayer() {
        return playerModel;
    }

    public void notifyHp(int hp){
        status.updateHp(hp, playerNO);
    }

    public void notifyHand(){
        status.updateHand(getPocketcardnames(), playerNO);
    }

    public void notifyHandSize(){
        status.updateHandSize(getPocketcards().size(), playerNO);
    }
    public void notifyEquipment(String type, String card){
        status.updateEquipment(type, card, playerNO);
    }
    public ArrayList<Card> getPocketcards(){
        return playerModel.getPocketcards();
    }

    public String getPocketcardnames(){
        ArrayList<Card> hand = getPocketcards();
        StringBuilder handCard = new StringBuilder(hand.get(0).toString());
        for (int i = 1; i < hand.size(); i++) {
            handCard.append(",");
            handCard.append(hand.get(i).toString());
        }
        return handCard.toString();
    }

    public void addToHand(Card c){
        playerModel.addToHand(c);
        notifyHand();
        notifyHandSize();
    }

    public void addToHand(ArrayList<Card> cards){
        playerModel.addToHand(cards);
        notifyHand();
        notifyHandSize();
    }

    public void removeCard(Card c){
        playerModel.removeCard(c);
        notifyHand();
        notifyHandSize();
    }

    public void putOnEquipment(String type, String card){
        playerModel.putOnEquipment(type, card);
        notifyEquipment(type, card);
    }

    public boolean whether_has_dodge(){
        for (Card card : getPocketcards()) {
            if (card instanceof Dodge) {
                removeCard(card);
                return true;
            }
        }
        return false;
    }

    public boolean whether_has_shoot(){
        for (Card card : getPocketcards()) {
            if (card instanceof Shoot) {
                removeCard(card);
                return true;
            }
        }
        return false;
    }

    public int getmaxhp(){
        return playerModel.getmaxhp();
    }

    public HashMap<String, String> getEquipment() {
        return playerModel.getEquipment();
    }


}
