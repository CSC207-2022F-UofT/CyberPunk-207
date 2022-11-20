package entity;

public class dodge extends basic_card{
    public void use(){
        getSource().activate_dodge();
    }
}
