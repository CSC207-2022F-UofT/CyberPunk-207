package entity;

import UseCase.GlobalStatus.Status;
import UseCase.GlobalStatus.StatusOutputBoundary;
import entity.Card.Dodge;
import entity.Card.Shoot;
import entity.Card.Shootout;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.openMocks;

public class ShootoutTest {
    Shootout card = new Shootout();
    private AutoCloseable mockitoCloseable;
    private Shoot shoot = new Shoot();
    private Dodge dodge = new Dodge();
    private List<Player> players = new ArrayList<>();
    private Player p1 = new Player(1);
    private Player p2 = new Player(2);
    private Player p3 = new Player(3);
    private Player p4 = new Player(4);


    @Mock
    private StatusOutputBoundary mockStatusOutputBoundary;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        Status status = new Status(mockStatusOutputBoundary);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        status.init(players);
        p1.addToHand(shoot);
        p1.addToHand(dodge);
        p1.addToHand(shoot);
        p1.addToHand(dodge);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    @DisplayName("Test needTarget")
    public void testNeedTarget(){
        Assertions.assertFalse(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        card.setSource(p1);
        card.use();
        int hp = p2.getHp();
        Assertions.assertEquals(2,hp);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Shootout",card.toString());}
}
