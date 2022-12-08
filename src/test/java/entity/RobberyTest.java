package entity;

import UseCase.GlobalStatus.Status;
import UseCase.GlobalStatus.StatusOutputBoundary;
import entity.Card.Card;
import entity.Card.Dodge;
import entity.Card.Robbery;
import entity.Card.Shoot;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.openMocks;

public class RobberyTest {
    Robbery card = new Robbery();
    ArrayList<Card> cards = new ArrayList<>();
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
        Assertions.assertTrue(card.needTarget());}

    @Test
    @DisplayName("Test use")
    public void testUse(){
        cards.add(card);
        cards.add(card);
        p1.setPocketCards(cards);
        card.setSource(p1);
        card.setTarget(p2);
        card.use();
        int p1cardsize = p1.getPocketCards().size();
        int p2cardsize = p2.getPocketCards().size();
        Assertions.assertEquals(1,p1cardsize);
        Assertions.assertEquals(1,p2cardsize);
    }

    @Test
    @DisplayName("Test toString")
    public void testToString(){
        Assertions.assertEquals("Robbery",card.toString());}
}
