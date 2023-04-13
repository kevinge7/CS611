import java.util.ArrayList;

// this is marker
public class Market {
    PotionsList p = new PotionsList();
    SpellList s = new SpellList();
    ArmoryList a = new ArmoryList();
    WeaponList w = new WeaponList();
    ArrayList<Heros> heros;
    InputValidator inputValidator = new InputValidator();
    private int heroIndex;


    public Market(ArrayList<Heros> heros,int heroIndex){
        this.heros = heros;
        this.heroIndex = heroIndex;
        System.out.println("Welcome to Market!!!");
        run();
    }
    public ArrayList<Heros> getHeros(){
        return this.heros;
    }
//select hero to buy or sell item
    public Heros heroSelect(){
        Heros selected = heros.get(heroIndex);

        System.out.println("You selected "+ selected.getName()+ "\nMoney left: "+selected.getMoney());
        System.out.println("");
        return heros.get(heroIndex);
    }


//if user want to sell hero's item, program will go inside this method
    public void sellItem(){
        System.out.println("Select a hero you want to sell from:");
        Heros selected  = heroSelect();
        ArrayList<item> itemList;
        itemList = selected.getItems();
        if (itemList.size() == 0) {
            System.out.println("There is nothing to sell");
            run();
        }
        else {
            System.out.print("Here is " + selected.getName() + " item list: ");
            int j = 1;
            for (item i : itemList) {
                System.out.print(j + i.getName());
            }

            int itemSelected = inputValidator.getInt(j);
            selected.setMoney(selected.getMoney() + itemList.get(itemSelected).getCost() / 2);
            itemList.remove(itemList.get(itemSelected));
            selected.setItems(itemList);
        }
    }

//if user want to buy item to hero, program will go inside this method
    public  void buyItem(){
        System.out.println("Which one you want to buy? (Answer by number)");
        System.out.println("1. Spells");
        System.out.println("2. Potions");
        System.out.println("3. Weapons");
        System.out.println("4. Armory");
        int MarketSelection = inputValidator.getInt(4);
        if (MarketSelection == 1){
            Heros selected = heroSelect();
            boolean buyOrNot = true;
            while(buyOrNot == true) {
                System.out.println("Here is Spells list, make selection from below");
                s.print();
                int SpellSelected = inputValidator.getInt(s.getSpellList().size()) - 1;
                if(selected.getLevel() >= s.getSpellList().get(SpellSelected).getRequiredLevel()) {
                    if (s.getSpellList().get(SpellSelected).getCost() <= selected.getMoney() && s.getSpellList().get(SpellSelected).getRequiredLevel() <= selected.getLevel()) {
                        //test code
                        System.out.println(s.getSpellList().get(SpellSelected).getCost());

                        selected.setMoney(selected.getMoney() - s.getSpellList().get(SpellSelected).getCost());
                        selected.setItems(s.getSpellList().get(SpellSelected));
                        //test code
                        System.out.println("this is item size " + selected.getItems().size());

                        buyOrNot = false;
                    } else {
                        System.out.println(s.getSpellList().get(SpellSelected).getCost());
                        System.out.println("You cannot afford this item. Please reselect!");
                    }
                }
                else {
                    System.out.println("Your hero level cannot buy this item. ");
                }
            }
        }

        if (MarketSelection == 2){
            boolean buyOrNot = true;
            while (buyOrNot == true) {
                System.out.println("Here is Potions list, make selection from below");
                p.print();
                int PotionSelected = inputValidator.getInt(p.getPotionsList().size())-1;
                //pass hero information from here and return error if hero cannot buy the item
                Heros selected = heroSelect();
                if(selected.getLevel() >= p.getPotionsList().get(PotionSelected).getRequiredLevel()) {
                    if (selected.getMoney() >= p.getPotionsList().get(PotionSelected).getCost() && p.getPotionsList().get(PotionSelected).getRequiredLevel() <= selected.getLevel()) {
                        selected.setMoney(selected.getMoney() - p.getPotionsList().get(PotionSelected).getCost());
                        selected.setItems(p.getPotionsList().get(PotionSelected));
                        buyOrNot = false;
                    } else {
                        System.out.println("You cannot afford this item. Please re-select!");
                    }
                }
                else {
                    System.out.println("Your hero level cannot buy this item. ");
                }
            }
        }

        if (MarketSelection == 3){
            boolean buyOrNot = true;
            while(buyOrNot == true) {
                System.out.println("Here is Weapons list, make selection from below");
                w.print();
                //get hero information from here
                int WeaponSelected = inputValidator.getInt(w.getWeaponList().size());
                Heros selected = heroSelect();
                if(selected.getLevel() >= w.getWeaponList().get(WeaponSelected).getRequiredLevel()) {

                    if (selected.getMoney() >= w.getWeaponList().get(WeaponSelected).getCost() && w.getWeaponList().get(WeaponSelected).getRequiredLevel() <= selected.getLevel()) {
                        selected.setMoney(selected.getMoney() - w.getWeaponList().get(WeaponSelected).getCost());
                        selected.setItems(w.getWeaponList().get(WeaponSelected));
                        buyOrNot = false;
                    } else {
                        System.out.println("You cannot afford this item. Please re-select!");
                    }
                }
                else {

                }
            }
        }

        if (MarketSelection == 4){
            boolean buyOrNot = true;
            while(buyOrNot == true) {
                System.out.println("Here is Armory list, make selection from below");
                a.print();
                //get hero information from here
                int ArmorySelect = inputValidator.getInt(a.getArmoryList().size());
                Heros selected = heroSelect();
                if(selected.getLevel() >= a.getArmoryList().get(ArmorySelect).getRequiredLevel()) {
                    if (selected.getMoney() >= a.getArmoryList().get(ArmorySelect).getCost()) {
                        selected.setMoney(selected.getMoney() - a.getArmoryList().get(ArmorySelect).getCost());
                        selected.setItems(a.getArmoryList().get(ArmorySelect));
                        buyOrNot = false;
                    } else {
                        System.out.println("You cannot afford this item. Please re-select!");
                    }
                }
                else {
                    System.out.println("Your hero level cannot buy this item. ");
                }
            }
        }
        else {
            System.out.println();
        }
    }
//the interface will first show when hero first enter the market
    public void run(){
        System.out.println("Please enter one of the options(Answer by number)");
        System.out.println("1. BUY");
        System.out.println("2. SELL");
        int num1 = inputValidator.getInt(3);
        if (num1 == 1) {
            buyItem();
        }
        if (num1 ==2){
            sellItem();
        }
    }
}
