package UseCase.GameBoard;

import entity.Identity;
import entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class GameboardControllerTest {

    @Mock
    private GameboardInputBoundary mockGameboardInputBoundary;

    private GameboardController gameboardControllerUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        gameboardControllerUnderTest = new GameboardController(mockGameboardInputBoundary);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testTurnChange() {
        // Setup
        // Run the test
        gameboardControllerUnderTest.turnChange();

        // Verify the results
        verify(mockGameboardInputBoundary).turnChange();
    }

    @Test
    void testStartGame() {
        // Setup
        final List<Player> players = List.of(new Player(0));
        final HashMap<Identity, List<Player>> roleMap = new HashMap<>(
                Map.ofEntries(Map.entry(Identity.CAPTAIN, List.of(new Player(0)))));

        // Run the test
        gameboardControllerUnderTest.startGame(players, roleMap);

        // Verify the results
        verify(mockGameboardInputBoundary).startGame(any(GameboardRequestModel.class));
    }
}
