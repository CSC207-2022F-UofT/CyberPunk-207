package entity;

import entity.Card.Lottery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class LotteryTest {
    Lottery card = new Lottery();
    Player noOne = new Player(1);
    ArrayList cards = new ArrayList<>();

    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertFalse(card.needTarget());}


    @Test
    @DisplayName("Test use")
    public void testUse(){
        card.setSource(noOne);
        noOne.setPocketCards(cards);
        card.use();
        int b = card.getTarget().getPocketCards().size();
        Assertions.assertEquals(2,b);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Lottery",card.toString());}
}
