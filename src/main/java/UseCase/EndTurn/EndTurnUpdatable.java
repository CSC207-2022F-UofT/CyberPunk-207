package UseCase.EndTurn;

/**
 * An interface for UI to implement
 **/
public interface EndTurnUpdatable {

    /**
     * A viewer displaying all message and instructions related to end turn
     * @param endTurnResponseModel A response model containing end turn message and instructions
     **/
    void throwView(EndTurnResponseModel endTurnResponseModel);
}
