package UseCase.PlayerJoin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class PlayerJoinTest {

    @Mock
    private PlayerJoinOutputBoundary mockPlayerJoinOutputBoundary;

    private PlayerJoin playerJoinUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        playerJoinUnderTest = new PlayerJoin(mockPlayerJoinOutputBoundary);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testInit() {
        // Setup
        // Run the test
        playerJoinUnderTest.init();

        // Verify the results
    }

    @Test
    void testShuffleRoles() {
        // Setup
        // Run the test
        playerJoinUnderTest.shuffleRoles();

        // Verify the results
    }

    @Test
    void testPlayersJoin() {
        // Setup
        final PlayerJoinRequestModel playerJoinRequestModel = new PlayerJoinRequestModel(0);

        // Run the test
        playerJoinUnderTest.playersJoin(playerJoinRequestModel);

        // Verify the results
        verify(mockPlayerJoinOutputBoundary).playersJoin(any(PlayerJoinResponseModel.class));
    }
}
