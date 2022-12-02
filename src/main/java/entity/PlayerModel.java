package entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static gateway.CardsHeap.draw;

public class PlayerModel {
    private int hp;
    private int maxhp;
    private ArrayList<Card> pocketcards;
    private String role;
    private boolean status;
    private boolean alive;
    private boolean useShoot = false;
    private HashMap<String, String> equipment = new HashMap<>();

    public boolean Status() {
        return status;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public PlayerModel() {
        this.hp = 3;
        this.maxhp = 3;
        this.pocketcards = new ArrayList<>();
        this.role = "";
        this.alive = true;
        this.status = true;
        equipmentInit();
    }

    private void equipmentInit(){
        this.equipment.put("Minus", "");
        this.equipment.put("Plus", "");
        this.equipment.put("Weapon", "");
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public void setHp(int hp){
         this.hp = hp;
    }

    public void hurt(int num){
        this.hp -= num;
    }

    public ArrayList<Card> getPocketcards(){
        return this.pocketcards;
    }
    public void loosCard(int card) {
        pocketcards.remove(card);
    }

    public void addToHand(ArrayList<Card> cards){
        this.pocketcards.addAll(cards);
    }
    public void addToHand(Card c){
        this.pocketcards.add(c);
    }

    public boolean isAlive() {
        return alive;
    }

    public void heal(int i) {
        this.hp += 1;
    }


    public void putOnEquipment(String type, String card){
        equipment.put(type, card);
    }

    public int getmaxhp(){ //change name to getMaxHp
        return this.maxhp;
    }

    public HashMap<String, String> getEquipment() {
        return equipment;
    }

    public void removeCard(Card c){
        this.pocketcards.remove(c);
    }


}
