package entity;

import entity.Card.Card;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Collections.shuffle;
import static java.util.Collections.swap;
/**
 * Class CardsHeap stores all the cards within the deck.
 */
public class CardsHeap {

    private static final ArrayList<Card> cardHeap = new ArrayList<>();
    /**
     * Add certain number of cards to drawCards and allCards, using method in CardFactory
     *
     * @param card: A string representing type of card.
     * @param num: Number of the card of certain type being added.
     */
    public static void addCard(String card, int num) {
        int count = 0;
        CardFactory factory = new CardFactory();
        while (count < num) {
            cardHeap.add(factory.getCard(card));
            count += 1;
        }
    }

    /**
     * Add basic cards into card heap.
     */
    public static void addBasicCards() {
        addCard("Shoot", 15);
        addCard("Dodge", 15);
        addCard("Medkit", 8);
    }

    /**
     * Add strategy cards into card heap.
     */
    public static void addStrategyCards() {
        addCard("Destruction", 6);
        addCard("Robbery", 6);
        addCard("Lottery", 6);
        addCard("Policeraid", 6);
        addCard("Shootout", 6);
        addCard("Traumateam", 6);
    }

    /**
     * Add equipment cards into card heap.
     */
    public static void addEquipmentCards() {
        addCard("R99MachineGun", 2);
        addCard("Tesla", 2);
        addCard("Lambo", 2);
    }

    /**
     * @precondition length of heap is 80.
     * Shuffle the card heap.
     */
    private static void shuffle() {
        Random r = new Random();
        for (int i = 79; i >= 1; i--){
            swap(cardHeap, i, r.nextInt(i));
        }
    }

    /**
     * Initialize the cards heap, by adding basic,strategy and equipment cards and shuffling.
     */
    public static void init() {
        addBasicCards();
        addStrategyCards();
        addEquipmentCards();
        shuffle();
    }

    /**
     * Draw one card from card heap.
     * If no cards left in drawCards, add all used cards to drawCards.
     */
    public static Card draw() {
        if (cardHeap.isEmpty()) {
            init();
        }
        Card c = cardHeap.get(0);
        cardHeap.remove(0);
        return c;
    }

    /**
     * Draw multiple cards from card heap.
     * If no cards left in drawCards, add all used cards to drawCards.
     */
    public static ArrayList<Card> draw(int num) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(draw());
        }
        return cards;
    }

}
