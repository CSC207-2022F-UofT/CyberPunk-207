package entity;

import entity.Card.Card;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Collections.shuffle;
import static java.util.Collections.swap;

public class CardsHeap {

    private static final ArrayList<Card> cardHeap = new ArrayList<>(); //All cards

    // Add certain number of cards to drawCards and allCards
    public static void addCard(String card, int num) {
        int count = 0;
        CardFactory factory = new CardFactory();
        while (count < num) {
            cardHeap.add(factory.getCard(card));
            count += 1;
        }
    }


    public static void addBasicCards() {
        addCard("Shoot", 15);
        addCard("Dodge", 15);
        addCard("Medkit", 8);
    }

    public static void addStrategyCards() {
        addCard("Destruction", 6);
        addCard("Robbery", 6);
        addCard("Lottery", 6);
        addCard("Policeraid", 6);
        addCard("Shootout", 6);
        addCard("Traumateam", 6);
    }

    public static void addEquipmentCards() {
        addCard("R99MachineGun", 2);
        addCard("Tesla", 2);
        addCard("Lambo", 2);
    }

    //Initialize the cards heap.
    public static void init() {
        addBasicCards();
        addStrategyCards();
        addEquipmentCards();
        shuffle();
    }

    //Draw one card from card heap
    public static Card draw() {
        //If no cards left in drawCards, add all used cards to drawCards
        if (cardHeap.isEmpty()) {
           init();
        }
        Card c = cardHeap.get(0);
        cardHeap.remove(0);
        return c;
    }

    //Draw multiple cards from card heap
    public static ArrayList<Card> draw(int num) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(draw());
        }
        return cards;
    }

    private static void shuffle() {
        Random r = new Random();
        for (int i = 79; i >= 1; i--){
            swap(cardHeap, i, r.nextInt(i));
        }
    }

}
