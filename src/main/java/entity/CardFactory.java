package entity;

import entity.Card.*;

public class CardFactory {
    public Card getCard(String cardName){
        switch (cardName) {
            case "Shoot":
                return new Shoot();
            case "Dodge":
                return new Dodge();
            case "Medkit":
                return new Medkit();
            case "Destruction":
                return new Destruction();
            case "Robbery":
                return new Robbery();
            case "Lottery":
                return new Lottery();
            case "Policeraid":
                return new PoliceRaid();
            case "Shootout":
                return new Shootout();
            case "Traumateam":
                return new Traumateam();
            case "R99MachineGun":
                return new R99MachineGun();
            case "Tesla":
                return new Tesla();
            case "Lambo":
                return new Lambo();
        }
        return null;
    }
}
