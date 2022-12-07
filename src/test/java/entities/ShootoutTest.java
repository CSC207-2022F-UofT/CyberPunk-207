package entities;

import entity.Card.Shootout;
import entity.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class ShootoutTest {
    Shootout card = new Shootout();
    Player noOne = new Player(1);
    Player noTwo = new Player(2);

    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertFalse(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        card.setSource(noOne);
        card.use();
        int b = noTwo.getHp();
        Assertions.assertEquals(2,b);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Shootout",card.toString());}
}
