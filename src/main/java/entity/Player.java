package entity;

import UseCase.GlobalStatus.Status;
import entity.Card.Card;
import entity.Card.Dodge;
import entity.Card.Shoot;

import java.util.ArrayList;
import java.util.HashMap;

import static entity.CardsHeap.draw;

/**
 * Player class contains all basic functions of a player
 */
public class Player {
    private int hp;
    private int maxHp;
    /** ArrayList of Card attribute representing the player's current cards on hand */
    private ArrayList<Card> pocketCards;
    /** Player's one of four possible roles */
    private Identity role;
    private boolean alive;
    private boolean useShoot = false;
    /** Hashmap attribute representing the player's current equipment */
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

    /**
     * Initiate equipment attribute. Map each equipment to empty string.
     */
    private void equipmentInit(){
        this.equipment.put("Minus", "");
        this.equipment.put("Plus", "");
        this.equipment.put("Weapon", "");
    }

    /**
     * Set status attribute
     * @param status: A string representing status of player.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Set strategy attribute
     * @param strategy: A string representing strategy of player
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    /**
     * Set useShoot attribute
     * @param useShoot: A boolean representing whether the player use Shoot.
     */
    public void setUseShoot(boolean useShoot) {
        this.useShoot = useShoot;
    }

    /**
     * Set role attribute
     * @param role: A Identity representing the player's role.
     */
    public void setRole(Identity role) {
        this.role = role;
    }

    /**
     * Set hp attribute, and pass this information to status use case through notifyHp()
     * @param hp: An Integer representing the player's hp.
     */
    public void setHp(int hp){
        this.hp = hp;
        notifyHp(getHp());
    }

    /**
     * Get role of player
     * @return: An identity which is player's role
     */
    public Identity getRole() {
        return role;
    }

    /**
     * Get hp of player
     * @return: An integer which is player's hp
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * Get maximum hp of player
     * @return: An integer instance which is player's maximum hp
     */
    public int getMaxHp(){ //change name to getMaxHp
        return this.maxHp;
    }

    /**
     * Get equipment of player
     * @return: A hashmap instance which is player's equipment
     */
    public HashMap<String, String> getEquipment() {
        return equipment;
    }

    /**
     * Get number of player
     * @return: An integer instance which is player's number
     */
    public int getPlayerNO() {
        return playerNO;
    }

    public String getStrategy() {
        return strategy;
    }

    /**
     * Get whether the player uses shoot.
     * @return: A boolean which is player's useShoot
     */
    public boolean isUseShoot() {
        return useShoot;
    }

    /**
     * Get whether the player is alive.
     * @return: A boolean representing whether the player is alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Set the player to be dead, change its alive attribute to false
     */
    public void isDead() {
        this.alive = false;
    }

    /**
     * Hurt the player with certain number of hp, and notify use case through notifyHp()
     * @param num An integer representing the num of hp the player lost
     */
    public void hurt(int num){
        this.hp -= num;
        notifyHp(getHp());
    }

    /**
     * Heal the player, and notify use case through notifyHp()
     */
    public void heal() {
        this.hp += 1;
        notifyHp(getHp());
    }

    /**
     * Get the list of player's cards on hand
     * @return: An Arraylist of card
     */
    public ArrayList<Card> getPocketCards(){
        return this.pocketCards;
    }

    /**
     * Get the number of card that the player needs to throw, which equals to hand size minus hp.
     * @return: An integer representing the number of card to throw.
     */
    public int needThrow() {
        return pocketCards.size() - hp;
    }

    /**
     * Add multiple cards to player's pocket, and send updated hand and handsize information to usecase
     * @param cards An ArrayList of cards instance representing multiple cards to add
     */
    public void addToHand(ArrayList<Card> cards){
        this.pocketCards.addAll(cards);
        notifyHand();
        notifyHandSize();
    }

    /**
     * Add one card to player's pocket, and send updated hand and handsize information to usecase
     * @param card A card instance representing multiple cards to add
     */
    public void addToHand(Card card){
        this.pocketCards.add(card);
        notifyHand();
        notifyHandSize();
    }

    /**
     * Draw certain number of cards from player's pocket.
     * Send updated hand and handsize information to usecase
     * @param num An integer instance representing number of cards to draw
     */
    public void drawCards(int num){
        addToHand(draw(num));
        notifyHand();
        notifyHandSize();
    }

    /**
     * Throw away certain number card from player's pocket.
     * Send updated hand and handsize information to usecase
     * @param num An integer instance representing number of card to throw
     */
    public void looseCard(int num) {
        pocketCards.remove(num);
        notifyHand();
        notifyHandSize();
    }

    /**
     * Throw away certain card from player's pocket.
     * Send updated hand and handsize information to usecase
     * @param card A card instance representing the card to throw
     */
    public void looseCard(Card card){
        pocketCards.remove(card);
        notifyHand();
        notifyHandSize();
    }

    /**
     * Put on equipment by mapping type to card within equipment attribute
     * Send updated equipment information to usecase
     * @param type A string instance representing the type of equipment
     * @param card A card instance representing the equipment card
     */
    public void putOnEquipment(String type, String card){
        equipment.put(type, card);
        notifyEquipment(type, card);
    }

    /**
     * Get name of all cards on player's hand
     * @return A string instance containing all the cards on player's hand, seperating with comma
     */
    public String getPocketCardNames(){
        StringBuilder handCard = new StringBuilder();
        for (Card card: pocketCards) {
            handCard.append(card.toString());
            handCard.append(",");
        }
        return handCard.toString();
    }

    /**
     * Get whether the player has card Dodge. If so, remove that card.
     * This function is called when some other player is playing Shoot or Shootout towards this player.
     * @return A boolean instance representing whether the player has Dodge
     */
    public boolean whetherHasDodge(){
        for (Card card : pocketCards) {
            if (card instanceof Dodge) {
                looseCard(card);
                return true;
            }
        }
        return false;
    }

    /**
     * Get whether the player has card Shoot. If so, remove that card.
     * This function is called when some other player is playing PoliceRaid towards this player.
     * @return A boolean instance representing whether the player has Shoot
     */
    public boolean whetherHasShoot(){
        for (Card card : pocketCards) {
            if (card instanceof Shoot) {
                looseCard(card);
                return true;
            }
        }
        return false;
    }

    /** Update status use case the information of player's hp. */
    public void notifyHp(int hp){
        status.updateHp(hp, playerNO);
    }

    /** Update status use case the information of player's cards in hand. */
    public void notifyHand(){
        status.updateHand(getPocketCardNames(), playerNO);
    }

    /** Update status use case the information of player's size of card in hand. */
    public void notifyHandSize(){
        status.updateHandSize(pocketCards.size(), playerNO);
    }

    /** Update status use case the information of player's equipment. */
    public void notifyEquipment(String type, String card){
        status.updateEquipment(type, card, playerNO);
    }

    @Override
    public String toString(){
        return "Player" + playerNO;
    }
}
