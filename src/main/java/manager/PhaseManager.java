package manager;

import java.util.ArrayList;
import java.util.List;

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
        playPhase(player);
        if(player.needThrow() < 0){
            throwPhase(player);
        }
        endPhase();
    }

    public void drawPhase(PlayerManager player){
        outputBoundary.displayInstruction("Draws 2 cards from cards heap");
        player.drawCards(2);
        outputBoundary.displayHp(player.getHp());
        outputBoundary.displayPocket(player.getPocketcardnames());
    }



    public void playPhase(PlayerManager player){
        player.playCard();
    }


    public void throwPhase(PlayerManager player){
        int num = player.needThrow();
        //output("You need to throw " + num + " cards" );
        for(int i = 0; i < num; i++){
            //output("choose a number");
            player.throwCard();
        }
    }

    public void endPhase() {
        outputBoundary.displayInstruction("This turn ends.");
    }
}
