package entity;

public class Medkit extends basic_card{
    public void use(int num){
        if (getTarget().gethp() < getTarget().getmaxhp()){
            getTarget().recover(1);
        }
    }

    @Override
    public String toString() {
        return "Medkit";
    }
}
