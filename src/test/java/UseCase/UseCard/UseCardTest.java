package UseCase.UseCard;

import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

class UseCardTest {

    @Mock
    private UseCardOutputBoundary mockUseCardOutputBoundary;

    private UseCard useCardUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        useCardUnderTest = new UseCard(mockUseCardOutputBoundary);
    }

    @Test
    void testUseCard() {
        // Setup
        final UseCardRequestModel useCardRequestModel = new UseCardRequestModel(new Player(0), 0, 0);

        // Run the test
        useCardUnderTest.useCard(useCardRequestModel);

        // Verify the results
        verify(mockUseCardOutputBoundary).displayInstruction(any(UseCardResponseModel.class));
    }

    @Test
    void testFindTarget() {
        // Setup
        // Run the test
        final Player result = useCardUnderTest.findTarget(0);

        // Verify the results
    }
}
