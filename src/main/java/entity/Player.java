package entity;

import gateway.CardsHeap;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int hp;
    private ArrayList<Card> pocketcards;
    private String role;
    private boolean status;
    public CardsHeap cardsheap;

    private boolean shoot = false;

    private boolean dodge = false;

    private int location;

    private int max_hp;

    public Player(CardsHeap cardsheap) {
        this.hp = 3;
        this.pocketcards = new ArrayList<>();
        this.role = null;
        this.status = true;
        this.cardsheap = cardsheap;
    }

    public void runPhase() {
        if(!this.isAlive()){
            return;
        }
        drawPhase();
        playPhase();
        if(hp < pocketcards.size()){
            throwPhase();
        }
        endPhase();
    }


    public void drawPhase(){
        System.out.println("Draws 2 cards from cards heap");
        drawCards(2);
    }

    public void drawCards(int num) {
        this.pocketcards.add(cardsheap.draw(2));
    }


    public void playPhase(){

    }

    public void throwPhase(){
        int num = pocketcards.size() - this.hp;
        System.out.println("You need to throw " + num + " cards" );
        for(int i = 0; i < num; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose a number");
            String card = scanner.next();
            loosCard(Integer.parseInt(card));
            scanner.close();
        }

    }

    private void loosCard(int card) {
        pocketcards.remove(card);
    }

    private void endPhase() {
        System.out.println("This round ends.");
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

    public void removeCard(Card c){
        this.pocketcards.remove(c);
    }




    public boolean isAlive() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
