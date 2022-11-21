package entity;

public class Destruction extends strategy_card{
    @Override
    public void use(int pick_num){

        getTarget().loosCard(pick_num);
    }

    @Override
    public String toString() {
        return null;
    }
}
