import java.util.ArrayList;

public class potionUsing {
    private static ArrayList<Heros> heroes;
    private static ArrayList<item> items;
    private static int heroInt;
    private InputValidator inputValidator = new InputValidator();
    private static Potions used;

    public potionUsing(ArrayList<Heros> heroes, ArrayList<item> items, int i){
        this.heroes = heroes;
        this.items = items;
        this.heroInt = i;
        using();

    }
    //this will return potion used and remove in Attack class.
    //Attack class will catch this information and made modification
    public Potions getUsedPotion(){
        return used;
    }
    //select hero and from hero list
    public Heros heroSelected() {
        System.out.println("You want to buy for which hero:(Answer by number)");
        int i = 1;
        //get hero and pass the information to the method
        for (Heros character : heroes) {
            System.out.println(i);
            i++;
            if (character instanceof Warriors) {
                Warriors player = (Warriors) character;
                // print warriors information
                System.out.println("Warrior Name: " + player.getName());
                System.out.println("Warrior Mana: " + player.getMP());
                System.out.println("Warrior Strength: " + player.getStrength());
                System.out.println("Warrior Agility " + player.getAgility());
                System.out.println("Warrior dexterity " + player.getDexterity());
                System.out.println("Warrior money " + player.getMoney());
                System.out.println("Warrior exp " + player.getLevel());
            }
            if (character instanceof Sorcerers) {
                Sorcerers player = (Sorcerers) character;
                // print sorcerer information
                System.out.println("Sorcerer Name: " + player.getName());
                System.out.println("Sorcerer Mana: " + player.getMP());
                System.out.println("Sorcerer Strength: " + player.getStrength());
            }
            if (character instanceof Paladins) {
                Paladins player = (Paladins) character;
                // print paladin informatin
                System.out.println("Paladin Name: " + player.getName());
                System.out.println("Paladin Mana: " + player.getMP());
                System.out.println("Paladin Strength: " + player.getStrength());
            }
        }
        int heroSelected = inputValidator.getInt(4)-1;
        Heros selected = heroes.get(heroSelected);
        System.out.println("You selected "+ selected.getName()+ "\nMoney left: "+selected.getMoney());
        System.out.println("");
        return heroes.get(heroSelected);
    }
//when hero decide to use potion, program will use this method
    public void using(){
        int count = 0;
        for(item ite: items){
            if(ite instanceof Potions){
                count ++;
                used = (Potions) ite;
                ArrayList<String> potionAff = ((Potions) ite).getAttributeAffect();
                for(int i = 0; i < potionAff.size(); i++){
                    System.out.println(i + potionAff.get(i));
                }
                int affectedSelect = inputValidator.getInt(potionAff.size());
                Heros h = heroSelected();
                if(potionAff.get(affectedSelect).equals("Health")){
                    if(h.getLevel()*100 > h.getHP()+((Potions) ite).getAttributeIncrease()){
                        h.setHP(h.getHP()+((Potions) ite).getAttributeIncrease());
                    }
                    else {
                        h.setHP(h.getLevel()*100);
                    }
                } else if (potionAff.get(affectedSelect).equals("Mana")) {
                    h.setMP(h.getMP()+((Potions) ite).getAttributeIncrease());
                } else if (potionAff.get(affectedSelect).equals("Strength")) {
                    h.setStrength(h.getStrength()+((Potions) ite).getAttributeIncrease());
                } else if (potionAff.get(affectedSelect).equals("Dexterity")) {
                    h.setDexterity(h.getDexterity()+((Potions) ite).getAttributeIncrease());
                } else if (potionAff.get(affectedSelect).equals("Agility")) {
                    h.setAgility(h.getAgility()+((Potions) ite).getAttributeIncrease());
                }

            }
        }
        if(count == 0){
            System.out.println("There is no potions to use.");
            System.out.println("Hero waste one chance. ");
        }
    }


}
