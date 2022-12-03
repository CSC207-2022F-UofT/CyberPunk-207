package entity;

public class Dodge extends BasicCard {
    @Override
    public boolean needTarget() {
        return false;
    }

    @Override
    public void use(){}
    @Override
    public String toString(){
        return "Dodge";
    }
}
