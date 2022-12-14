package entity;

import entity.Card.*;
    /**
     * Class CardFactory is able to produce all kinds of cards.
     */
    public class CardFactory {
        /**
         * Construct cards with certain card type
         *
         * @param cardName: A string representing type of card.
         * @return corresponding card attributes
         */
        public Card getCard(String cardName){
            if(cardName.equals("Shoot")) {
                return new Shoot();
            }
            else if(cardName.equals("Dodge")){
                return new Dodge();
            }
            else if(cardName.equals("Medkit")){
                return new Medkit();
            }
            else if(cardName.equals("Destruction")){
                return new Destruction();
            }
            else if(cardName.equals("Robbery")){
                return new Robbery();
            }
            else if(cardName.equals("Lottery")){
                return new Lottery();
            }
            else if(cardName.equals("Policeraid")){
                return new PoliceRaid();
            }
            else if(cardName.equals("Shootout")){
                return new Shootout();
            }
            else if(cardName.equals("Traumateam")){
                return new Traumateam();
            }
            else if(cardName.equals("R99MachineGun")){
                return new R99MachineGun();
            }
            else if(cardName.equals("Tesla")){
                return new Tesla();
            }
            else if(cardName.equals("Lambo")){
                return new Lambo();
            }
            return null;
    }
}
