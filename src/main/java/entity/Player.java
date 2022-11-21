package entity;


import java.util.ArrayList;

import static gateway.CardsHeap.draw;

public class Player {
    private int hp;
    private ArrayList<Card> pocketcards;
    private String role;
    private boolean status;

    private boolean alive;

    private boolean shoot = false;

    private boolean dodge = false;

    public boolean Status() {
        return status;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }



    public Player() {
        this.hp = 3;
        this.pocketcards = new ArrayList<>();
        this.role = "";
        this.alive = true;
        this.status = true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int gethp(){
        return this.hp;
    }

    public void sethp(int hp){
         this.hp = hp;
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
    public void loosCard(int card) {
        pocketcards.remove(card);
    }

    public void addToHand(ArrayList<Card> cards){
        this.pocketcards.addAll(cards);
    }





    public boolean isAlive() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
