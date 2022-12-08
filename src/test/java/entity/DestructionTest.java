package entity;

import entity.Card.Destruction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class DestructionTest {
    Destruction card = new Destruction();
    Player noOne = new Player(1);
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
        noOne.setPocketCards(cards);
        card.setTarget(noOne);
        card.use();
        int b = card.getTarget().getPocketCards().size();
        Assertions.assertEquals(1,b);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Destruction",card.toString());}
}
