package entity;

public class Robbery extends strategy_card {
    public void use() {
        if (getTarget().get_pocketcards().size() > 0){
            getSource().addCard(getTarget().get_pocketcards().get(0));
            getTarget().removeCard(getTarget().get_pocketcards().get(0));
        }
    }

    @Override
    public String toString() {
        return "Robbery";
    }
}
    
