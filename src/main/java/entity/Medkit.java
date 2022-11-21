package entity;

public class Medkit extends basic_card{
    @Override
    public boolean needTarget() {
        return false;
    }

    public void use(){
        if (getSource().gethp() < getSource().getmaxhp()){
            getSource().recover(1);
        }
    }

    @Override
    public String toString() {
        return "Medkit";
    }


}
