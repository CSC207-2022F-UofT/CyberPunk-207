package manager;

public class PhaseManager {
    private PlayerManager player;
    private Gameboard gameboard;
    private OutputBoundary outputBoundary;

    public PhaseManager(Gameboard gameboard, OutputBoundary outputBoundary) {
        this.gameboard = gameboard;
        this.outputBoundary = outputBoundary;
    }

    public void runPhase(PlayerManager player) {
        drawPhase(player);
        outputBoundary.displayHand();
        playPhase(player);
        if(player.needThrow() < 0){
            throwPhase(player);
        }
        endPhase();
    }

    public void drawPhase(PlayerManager player){
        //output("Draws 2 cards from cards heap");
        player.drawCards(2);
    }



    public void playPhase(PlayerManager player){
        while(player.isAlive()){
            //output("num for cards, 0 for end turn");
            player.playCard();
        }
    }


    public void throwPhase(PlayerManager player){
        int num = player.needThrow();
        //output("You need to throw " + num + " cards" );
        for(int i = 0; i < num; i++){
            //output("choose a number");
            int card = gameboard.askOrder();
            player.loosCard(card);
        }
    }

    public void endPhase() {
        System.out.println("This turn ends.");//presenter
    }
}
