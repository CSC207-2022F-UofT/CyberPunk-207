package entity;

import entity.Card.Traumateam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class TraumateamTest {
    Traumateam card = new Traumateam();
    Player noOne = new Player(1);

    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertFalse(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        card.setSource(noOne);
        noOne.setHp(2);
        card.use();
        int b = noOne.getHp();
        Assertions.assertEquals(3,b);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Traumateam",card.toString());}
}
