package controller;

import entity.Card;
import entity.Player;
import manager.Gameboard;
import gateway.Cardsheap;

import java.util.ArrayList;
import java.util.List;

public class PlayCardsController {

    private final Gameboard gameboard;

    public PlayCardsController(Gameboard gameboard){
        this.gameboard = gameboard;
    }

    //player plays card towards target player
    public void PlayCard(int cardIndex, int sourcePlayerIndex, int targetPlayerIndex) {
        if (gameboard.getPlayers().size() >= targetPlayerIndex) {
            System.out.println("Target index out of range");
        } else {
            Player source_player = gameboard.getPlayers().get(sourcePlayerIndex);
            Player target_player = gameboard.getPlayers().get(targetPlayerIndex);
            source_player.playCard(cardIndex, target_player);
        }
    }

    //player plays non-target card
    public void PlayNonTargetCard(int cardIndex, int sourcePlayerIndex) {
        gameboard.getPlayers().get(sourcePlayerIndex).playCard(cardIndex);
    }

    //player draws one card
    public void DrawCard(int sourcePlayerIndex){
        Card c = Cardsheap.draw();
        gameboard.getPlayers().get(sourcePlayerIndex).addCard(c);
    }

    //player draws multiple cards
    public void DrawCard(int sourcePlayerIndex, int numCards){
        ArrayList<Card> cards = Cardsheap.draw(numCards);
        gameboard.getPlayers().get(sourcePlayerIndex).addCard(cards);
    }

    //player discards one card. Card's index is taken as input
    public void DiscardCard(int sourcePlayerIndex, int cardIndex){
        Player source_player = gameboard.getPlayers().get(sourcePlayerIndex);
        gameboard.getPlayers().get(sourcePlayerIndex).removeCard(cardIndex);
    }

    //player discards multiple cards. List of cards' indices is taken as input
    public void DiscardCard(int sourcePlayerIndex, ArrayList<Integer> cardIndices){
        Player source_player = gameboard.getPlayers().get(sourcePlayerIndex);
        gameboard.getPlayers().get(sourcePlayerIndex).removeCard(cardIndices);
    }
}
