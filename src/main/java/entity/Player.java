package entity;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int handlimit;
    private ArrayList<Card> pocketcards;
    private String role;
    private boolean status;

    private boolean shoot = false;

    private boolean dodge = false;

    private int location;

    private int max_hp;

    public Player() {
        this.hp = 3;
        this.handlimit = hp;
        this.pocketcards = new ArrayList<Card>();
        this.role = null;
        this.status = true;
    }

    public void drawCards(int num) {
    }

    public void playCards(){

    }
    public int gethp(){
        return this.hp;
    }

    public int getmaxhp(){
        return this.max_hp;
    }

    public void recover(int num){
        this.hp += num;
    }

    public void hurted(int num){
        this.hp -= num;
    }

    public void activate_dodge(){
        this.dodge = true;
    }

    public boolean check_dodge(){
        return this.dodge;
    }

    public ArrayList<Card> get_pocketcards(){
        return this.pocketcards;
    }

    public void addCard(Card c){
        this.pocketcards.add(c);
    }
    public void addCard(ArrayList<Card> cards){
        this.pocketcards.addAll(cards);
    }

    public void removeCard(Card c){
        this.pocketcards.remove(c);
    }

    public void removeCard(int cardIndex){
        this.pocketcards.remove(cardIndex);
    }

    public void removeCard(ArrayList<Integer> cardIndex){
        for(int i=0; i<cardIndex.size(); i++){
            this.pocketcards.remove(i);
        }
    }

    public void playCard(int cardIndex, Player target){
        Card cardtoplay = get_pocketcards().get(cardIndex);
        cardtoplay.setTarget(target);
        cardtoplay.use();
        removeCard(cardtoplay);
    }

    public void playCard(int cardIndex){
        Card cardtoplay = get_pocketcards().get(cardIndex);
        cardtoplay.use();
        removeCard(cardtoplay);
    }

    public boolean isAlive(){
        return hp > 0;
    }


    public void runPhase() {
    }
}
