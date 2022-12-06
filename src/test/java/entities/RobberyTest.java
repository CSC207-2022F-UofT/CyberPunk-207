package entities;

import entity.Card.Robbery;
import entity.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class RobberyTest {
    Robbery card = new Robbery();
    Player noOne = new Player(1);
    Player noTwo = new Player(2);
    ArrayList cards = new ArrayList<>();

    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertTrue(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        cards.add(card);
        cards.add(card);
        noTwo.setPocketCards(cards);
        card.setSource(noOne);
        card.setTarget(noTwo);
        card.use();
        int a = noOne.getPocketCards().size();
        int b = noTwo.getPocketCards().size();
        Assertions.assertEquals(1,a);
        Assertions.assertEquals(1,b);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Robbery",card.toString());}
}
