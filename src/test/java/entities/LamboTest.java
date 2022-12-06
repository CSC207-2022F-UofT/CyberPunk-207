package entities;

import entity.Card.Lambo;
import entity.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class LamboTest {
    Lambo card = new Lambo();
    Player noOne = new Player(1);

    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertFalse(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        card.setSource(noOne);
        card.use();
        Assertions.assertTrue(noOne.getEquipment().containsValue(card.toString()));
}

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Lambo",card.toString());}
}
