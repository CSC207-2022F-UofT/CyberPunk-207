package UseCase.UseCard;

/**
 * A response model of use card, containing message to be displayed if the source player already played shoot
 * To be handled by UI
 **/
public class UseCardResponseModel {
    private String message;

    public UseCardResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
