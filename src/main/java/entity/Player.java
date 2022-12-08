package entity;


import UseCase.GlobalStatus.Status;
import entity.Card.Card;
import entity.Card.Dodge;
import entity.Card.Shoot;
import UseCase.Identity;

import java.util.ArrayList;
import java.util.HashMap;

import static entity.CardsHeap.draw;

public class Player {
    private int hp;
    private int maxHp;
    private ArrayList<Card> pocketCards;
    private Identity role;
    private boolean alive;
    private boolean useShoot = false;
    private HashMap<String, String> equipment = new HashMap<>();
    private Status status;
    private String strategy;
    private int playerNO;



    public Player(int playerNO) {
        this.hp = 3;
        this.maxHp = 3;
        this.playerNO = playerNO;
        this.pocketCards = new ArrayList<>();
        this.role = null;
        this.alive = true;
        equipmentInit();
    }

    private void equipmentInit(){
        this.equipment.put("Minus", "");
        this.equipment.put("Plus", "");
        this.equipment.put("Weapon", "");
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPocketCards(ArrayList<Card> pocketCards) {
        this.pocketCards = pocketCards;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Identity getRole() {
        return role;
    }


    public void setRole(Identity role) {
        this.role = role;
    }

    public int getHp(){
        return this.hp;
    }

    public boolean isUseShoot() {
        return useShoot;
    }

    public void setUseShoot(boolean useShoot) {
        this.useShoot = useShoot;
    }

    public boolean isAlive() {
        return alive;
    }

    public void isDead() {
        this.alive = false;
    }

    public void setHp(int hp){
         this.hp = hp;
        notifyHp(getHp());
    }

    public void hurt(int num){
        this.hp -= num;
        notifyHp(getHp());
    }

    public void heal() {
        this.hp += 1;
        notifyHp(getHp());
    }

    public ArrayList<Card> getPocketCards(){
        return this.pocketCards;
    }

    public int needThrow() {
        return pocketCards.size() - hp;
    }


    public void addToHand(ArrayList<Card> cards){
        this.pocketCards.addAll(cards);
        notifyHand();
        notifyHandSize();
    }
    public void addToHand(Card c){
        this.pocketCards.add(c);
        notifyHand();
        notifyHandSize();
    }

    public void drawCards( int num) {
        addToHand(draw(num));
        notifyHand();
        notifyHandSize();
    }

    public void looseCard(int card) {
        pocketCards.remove(card);
        notifyHand();
        notifyHandSize();
    }
    public void looseCard(Card c){
        pocketCards.remove(c);
        notifyHand();
        notifyHandSize();
    }

    public void putOnEquipment(String type, String card){
        equipment.put(type, card);
        notifyEquipment(type, card);
    }

    public int getMaxHp(){ //change name to getMaxHp
        return this.maxHp;
    }

    public HashMap<String, String> getEquipment() {
        return equipment;
    }

    public int getPlayerNO() {
        return playerNO;
    }

    public String getPocketCardNames(){
        StringBuilder handCard = new StringBuilder();
        for (Card card: pocketCards) {
            handCard.append(card.toString());
            handCard.append(",");
        }
        return handCard.toString();
    }

    public boolean whetherHasDodge(){
        for (Card card : pocketCards) {
            if (card instanceof Dodge) {
                looseCard(card);
                return true;
            }
        }
        return false;
    }

    public boolean whetherHasShoot(){
        for (Card card : pocketCards) {
            if (card instanceof Shoot) {
                looseCard(card);
                return true;
            }
        }
        return false;
    }

    public void notifyHp(int hp){
        status.updateHp(hp, playerNO);
    }

    public void notifyHand(){
        status.updateHand(getPocketCardNames(), playerNO);
    }

    public void notifyHandSize(){
        status.updateHandSize(pocketCards.size(), playerNO);
    }

    public void notifyEquipment(String type, String card){
        status.updateEquipment(type, card, playerNO);
    }

    @Override
    public String toString(){
        return "Player" + playerNO;
    }
}
