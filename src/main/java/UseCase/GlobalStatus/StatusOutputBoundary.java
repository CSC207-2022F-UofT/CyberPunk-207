package UseCase.GlobalStatus;

/**
 *An output boundary interface contains display status method being implemented by presenter.
 **/
public interface StatusOutputBoundary {
    /**
     * Transmit all information of current status (represented by status response model).
     * @param statusResponseModel a response model
     **/
    void displayStatus(StatusResponseModel statusResponseModel);
}
