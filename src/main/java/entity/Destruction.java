package entity;

public class Destruction extends strategy_card{
    public void use(int pick_num){

        getTarget().removeCard(getTarget().get_pocketcards().get(pick_num));
    }

    @Override
    public String toString() {
        return null;
    }
}
