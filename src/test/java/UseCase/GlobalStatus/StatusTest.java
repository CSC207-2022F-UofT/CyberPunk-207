package UseCase.GlobalStatus;

import entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class StatusTest {

    @Mock
    private StatusOutputBoundary mockStatusOutputBoundary;

    private Status statusUnderTest;

    private AutoCloseable mockitoCloseable;
    private List<Player> players = new ArrayList<>();
    private Player p1 = new Player(1);
    private Player p2 = new Player(2);
    private Player p3 = new Player(3);
    private Player p4 = new Player(4);

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        statusUnderTest = new Status(mockStatusOutputBoundary);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        statusUnderTest.init(players);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testUpdateHp() {
        // Setup
        // Run the test
        statusUnderTest.updateHp(0, 0);

        // Verify the results
        verify(mockStatusOutputBoundary).displayStatus(any(StatusResponseModel.class));
    }

    @Test
    void testUpdateHandSize() {
        // Setup
        // Run the test
        statusUnderTest.updateHandSize(0, 0);

        // Verify the results
        verify(mockStatusOutputBoundary).displayStatus(any(StatusResponseModel.class));
    }

    @Test
    void testUpdateEquipment() {
        // Setup
        // Run the test
        statusUnderTest.updateEquipment("type", "card", 0);

        // Verify the results
        verify(mockStatusOutputBoundary).displayStatus(any(StatusResponseModel.class));
    }

    @Test
    void testUpdateHand() {
        // Setup
        // Run the test
        statusUnderTest.updateHand("cards", 0);

        // Verify the results
        verify(mockStatusOutputBoundary).displayStatus(any(StatusResponseModel.class));
    }

    @Test
    void testGetIndex() {
        assertEquals(1, statusUnderTest.getIndex(0));
    }

    @Test
    void testTurnChange() {
        // Setup
        // Run the test
        statusUnderTest.turnChange();

        // Verify the results
        verify(mockStatusOutputBoundary).displayStatus(any(StatusResponseModel.class));
    }

    @Test
    void testGetHands() {
        // Setup
        // Run the test
        final ArrayList<String> result = statusUnderTest.getHands();

        // Verify the results
        assertNotEquals(new ArrayList<>(), result);
    }

    @Test
    void testInit() {
        // Setup
        final List<Player> players = List.of(new Player(0));

        // Run the test
        statusUnderTest.init(players);

        // Verify the results
    }
}
