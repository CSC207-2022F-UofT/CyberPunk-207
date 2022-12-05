package UseCase.ThrowCard;

import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThrowCardTest {

    private ThrowCard throwCardUnderTest;

    @BeforeEach
    void setUp() {
        throwCardUnderTest = new ThrowCard();
    }

    @Test
    void testThrowCard() {
        // Setup
        final ThrowCardRequestModel throwCardRequestModel = new ThrowCardRequestModel(0, new Player(0));

        // Run the test
        throwCardUnderTest.throwCard(throwCardRequestModel);

        // Verify the results
    }
}
