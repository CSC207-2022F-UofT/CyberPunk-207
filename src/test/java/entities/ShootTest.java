package entities;

import entity.Card.Shoot;
import entity.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class ShootTest {
    Shoot card = new Shoot();
    Player noOne = new Player(1);
    Player noTwo = new Player(2);


    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertTrue(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        card.setSource(noOne);
        card.setTarget(noTwo);
        card.use();
        int b = noTwo.getHp();
        Assertions.assertEquals(2,b);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Shoot",card.toString());}
}
