package UseCase.GlobalStatus;

import entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class StatusTest {

    @Mock
    private StatusOutputBoundary mockStatusOutputBoundary;

    private Status statusUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        statusUnderTest = new Status(mockStatusOutputBoundary);
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
        assertEquals(0, statusUnderTest.getIndex(0));
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
        assertEquals(new ArrayList<>(List.of("value")), result);
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
