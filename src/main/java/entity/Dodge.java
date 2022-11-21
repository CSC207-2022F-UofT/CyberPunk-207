package entity;

public class Dodge extends basic_card{
    @Override
    public void use(){
        getSource().activate_dodge();
    }
    @Override
    public String toString(){
        return "Dodge";
    }
}
