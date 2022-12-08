package UseCase.UseCard;

import UseCase.GlobalStatus.Status;
import UseCase.GlobalStatus.StatusOutputBoundary;
import entity.Card.Dodge;
import entity.Card.Shoot;
import entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class UseCardTest {

    @Mock
    private UseCardOutputBoundary mockUseCardOutputBoundary;
    @Mock
    private StatusOutputBoundary mockStatusOutputBoundary;

    private UseCard useCardUnderTest;

    private AutoCloseable mockitoCloseable;
    private Shoot shoot = new Shoot();
    private Dodge dodge = new Dodge();
    private List<Player> players = new ArrayList<>();
    private Player p1 = new Player(1);
    private Player p2 = new Player(2);
    private Player p3 = new Player(3);
    private Player p4 = new Player(4);
    private Status status;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        status = new Status(mockStatusOutputBoundary);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        status.init(players);
        p1.addToHand(shoot);
        p1.addToHand(dodge);
        p1.addToHand(shoot);
        p1.addToHand(dodge);
        useCardUnderTest = new UseCard(mockUseCardOutputBoundary);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testUseCard() {
        // Setup
        final UseCardRequestModel useCardRequestModel = new UseCardRequestModel(p1, 1, 2);

        // Run the test
        useCardUnderTest.useCard(useCardRequestModel);
    }

    @Test
    void testFindTarget() {
        // Setup
        // Run the test
        final Player result = useCardUnderTest.findTarget(0);

        // Verify the results
    }
}
