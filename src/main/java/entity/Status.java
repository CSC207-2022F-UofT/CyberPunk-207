package entity;

import manager.PlayerManager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Status implements Listener{
    private int hp;
    private ArrayList<Card> pocketcards;
    private int round;
    private int handSize;
    private List<PlayerManager> players;
    private int alivePeopleSize;
    private int cardHeapSize;
    private HashMap<String, equipment_card> equipment;

    public Status() {
        this.hp = 3;
        this.pocketcards = new ArrayList<>();
        this.round = 0;
        this.handSize = 0;
        this.players = new ArrayList<>();
        this.alivePeopleSize = 0;
        this.equipment = new HashMap<>();
    }

    @Override
    public void update() {}
    @Override
    public void updateHp(int hp) {
        this.hp = hp;
    }
    @Override
    public void updateHand(ArrayList<Card> cards) {
        this.pocketcards = cards;
    }

    @Override
    public void updateHandSize(int size) {
        this.handSize = size;
    }

    @Override
    public void updateAlivePeople(List<PlayerManager> players) {
        this.players = players;
    }

    @Override
    public void updateAlivePeopleSize(int size) {
        this.alivePeopleSize = size;
    }

    @Override
    public void updateCardHeap(int size) {
        this.cardHeapSize = size;
    }

    @Override
    public void updateEquipment(String type, equipment_card card) {
        this.equipment.put(type, card);
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Card> getPocketcards() {
        return pocketcards;
    }

    public int getRound() {
        return round;
    }

    public int getHandSize() {
        return handSize;
    }

    public List<PlayerManager> getPlayers() {
        return players;
    }

    public int getAlivePeopleSize() {
        return alivePeopleSize;
    }

    public int getCardHeapSize() {
        return cardHeapSize;
    }
}
