package UseCase.EndTurn;

import entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class EndTurnTest {

    @Mock
    private EndTurnOutputBoundary mockEndTurnOutputBoundarye;

    private EndTurn endTurnUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        endTurnUnderTest = new EndTurn(mockEndTurnOutputBoundarye);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testEndTurn() {
        // Setup
        final EndTurnRequestModel endTurnRequestModel = new EndTurnRequestModel(new Player(0));

        // Run the test
        endTurnUnderTest.endTurn(endTurnRequestModel);

        // Verify the results
        verify(mockEndTurnOutputBoundarye).displayInstruction(any(EndTurnResponseModel.class));
    }
}
