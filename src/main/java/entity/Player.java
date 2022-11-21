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
        this.pocketcards = new ArrayList<>();
        this.role = null;
        this.status = true;
    }

    public void drawCards(int num) {
    }

    public void playCards() {

    }

    public int gethp() {
        return this.hp;
    }

    public int getmaxhp() {
        return this.max_hp;
    }

    public void recover(int num) {
        this.hp += num;
    }

    public void hurted(int num) {
        this.hp -= num;
    }

    public void activate_dodge() {
        this.dodge = true;
    }

    public boolean check_dodge() {
        return this.dodge;
    }

    public ArrayList<Card> get_pocketcards() {
        return this.pocketcards;
    }

    public void addCard(Card c) {
        this.pocketcards.add(c);
    }

    public void removeCard(Card c) {
        this.pocketcards.remove(c);
    }

    public boolean whether_has_dodge() {
        for (int i = 0; i < this.get_pocketcards().size(); i++) {
            if (!(this.get_pocketcards().get(i) instanceof Dodge)) {
                return false;
            }
        }
        return true;
    }



}

