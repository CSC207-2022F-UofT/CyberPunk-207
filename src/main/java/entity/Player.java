package entity;

import gateway.CardsHeap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static gateway.Cardsheap.draw;

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

    private int location;

    private int max_hp;


    public Player() {
        this.hp = 3;
        this.pocketcards = new ArrayList<>();
        this.role = null;
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

    public void addCard(ArrayList<Card> cards){
        this.pocketcards.addAll(cards);
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
