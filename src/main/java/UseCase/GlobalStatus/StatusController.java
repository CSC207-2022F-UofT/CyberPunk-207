package UseCase.GlobalStatus;

public class StatusController {
    private StatusInputBoundary statusInputBoundary;

    public StatusController(StatusInputBoundary statusInputBoundary) {
        this.statusInputBoundary = statusInputBoundary;
    }

    public void turnChange(){
        statusInputBoundary.turnChange();
    }
}
