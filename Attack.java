import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Random;

//In this class, hero can attack monster and monster can attack hero.
public class Attack {
    private static ArrayList<Heros> heros;
    private static ArrayList<Monsters> monster;
    private static boolean monsterWin;
    private static boolean heroWin;
    private static int MonsterHP;
    private static int heroNumber;
    private static int damage;
    private int decimalPlaces = 0;
    private static int heroInt;
    private static int monsterInt;
    private static boolean temp = true;
    private static ArrayList<Heros> originalHero;
    private static InputValidator inputValidator = new InputValidator();


    public Attack(ArrayList<Heros> heros, ArrayList<Monsters> monsters, int heroIndex){
        this.heros = heros;
        this.monster = monsters;
        heroNumber = heros.size();
        HeroList h = new HeroList();
        originalHero = h.getHeroList();
        this.heroInt = heroIndex;
        this.monsterInt = heros.get(heroIndex).getCurrentLane();
        monsterWin = false;
        heroWin = false;
        startBattle();
    }

    public boolean getMonsterWin() {
        return monsterWin;
    }

    public boolean getHeroWin() {
        return heroWin;
    }

    //hero how to use weapon to attack
    public void heroAttack(int i, int j){
        int weapon_damage = 0;
        ArrayList<item> items = new ArrayList<item>();
        items = heros.get(heroInt).getItems();
        if (items != null){
            for(item ite:items){
                if(ite instanceof Weaponry){
                    weapon_damage += ((Weaponry) ite).getDamage();
                }
            }
        }
        double temp = (heros.get(heroInt).getStrength() + weapon_damage )* 0.05;
        BigDecimal bd1 = new BigDecimal(temp);
        bd1 = bd1.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        damage = bd1.intValue()*2;
        int monsterHP = monster.get(monsterInt).getHP()-damage;
        System.out.println("Hero "+heros.get(heroInt).getName() + " made " +
                "\u001B[31m"+damage + "\u001B[0m"+ " damage to Monster " + monster.get(monsterInt).getName());
        if (monsterHP > 0){
            monster.get(monsterInt).setHP(monsterHP);
        }
        else{
            System.out.println("Monster " + monster.get(monsterInt).getName() + " died!");
            heroWin = true;
        }
    }

    //hero can use spell to attack
    public void heroSpellAttack(int i, int j){
        heroInt = i;
        monsterInt = j;

        int spell_damage = 0;
        ArrayList<item> items = new ArrayList<item>();
        items = heros.get(heroInt).getItems();
        for(item ite:items){
            if(ite instanceof Spells){
                Spells sp = (Spells) ite;
                if (heros.get(heroInt).getMP() > sp.getMana_cost()){
                    spell_damage = sp.getDamage()*2;
                    heros.get(heroInt).setMP(heros.get(heroInt).getMP() - sp.getMana_cost());
                    //deleted used spell
                    ArrayList<item> updated = heros.get(heroInt).getItems();
                    updated.remove(sp);
                    heros.get(heroInt).setItems(updated);
                }
                else {
                    System.out.println("Your hero mana cannot afford using Spells");
                    return;
                }
            }
        }

        double temp = spell_damage + (heros.get(heroInt).getDexterity()/10000) * spell_damage;
        BigDecimal bd1 = new BigDecimal(temp);
        bd1 = bd1.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        damage = bd1.intValue();
        //monster dodge attack or not
        Random random = new Random();
        int a = random.nextInt(1000);
        if (a < monster.get(monsterInt).getDodge()){
            System.out.println("Attack Failed!");
            System.out.println("monster Dodge!");
        }
        else{
            int monsterHP = monster.get(monsterInt).getHP()-damage;
            System.out.println("Hero "+heros.get(heroInt).getName() + " made " +
                    "\u001B[31m"+damage + "\u001B[0m"+ " damage to Monster " + monster.get(monsterInt).getName());
            if (monsterHP > 0){
                monster.get(monsterInt).setHP(monsterHP);
            }
            else{
                System.out.println("Monster " + monster.get(monsterInt).getName() + "died!");
                monsterInt ++;
                if(monsterInt > heroNumber){
                    heroWin = true;
                }
            }
        }
    }

    //monster attack hero
    public void monsterAttack(int i, int j){
        heroInt = i;
        monsterInt = j;
        int reduce_damage = 0;
        ArrayList<item> items = new ArrayList<item>();
        items = heros.get(heroInt).getItems();
        if (items != null){
            for(item ite:items){
                if(ite instanceof Armory){
                    reduce_damage = ((Armory) ite).getDamage_reduce()/10;
                }
            }
        }

        double  temp = monster.get(monsterInt).getDamage() * 0.05;
        BigDecimal bd1 = new BigDecimal(temp);
        bd1 = bd1.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        damage = bd1.intValue()-reduce_damage;
        Random random = new Random();
        int a = random.nextInt(1000);


        if(a < heros.get(heroInt).getAgility() * 0.02){
            System.out.println("Attack Failed!");
            System.out.println("Hero Dodge!");
        }
        else{
            int heroHP = heros.get(heroInt).getHP()-damage;
            System.out.println("Monster "+monster.get(monsterInt).getName() + " made " +
                    "\u001B[31m"+damage + "\u001B[0m"+ " damage to Hero " + heros.get(heroInt).getName());
            if(heroHP > 0){
                heros.get(heroInt).setHP(heroHP);
            }
            else {
                System.out.println("Hero "+heros.get(heroInt).getName()+" died!");
                heroInt++;

                if(heroInt >= heroNumber){
                    monsterWin = true;
                }
            }
        }
    }

    //main method of this class to initial the battle.
    //it can also decide which turn to attack.
    public void startBattle(){
        while(monsterWin == false && heroWin == false){
            if (temp == true){
                System.out.println("What kind of attack you want to make?(Answer by number)");
                System.out.println("1. Weapon Attack\n2. Spell Attack\n3. Potion\n");
                int choice = inputValidator.getInt(3);
                if (choice == 1){
                    heroAttack(heroInt,monsterInt);
                    temp = false;
                }
                if(choice == 2){
                    temp = false;
                    heroSpellAttack(heroInt,monsterInt);
                }
                if(choice == 3){
                    //enter potionUsing class
                    potionUsing potionUsing = new potionUsing(heros, heros.get(heroInt).getItems(), heroInt);
                    Potions used = potionUsing.getUsedPotion();
                    ArrayList<item> newest = heros.get(heroInt).getItems();
                    newest.remove(used);
                    heros.get(heroInt).setItems(newest);
                }
            }
            else{
                monsterAttack(heroInt,monsterInt);
                temp = true;
            }
        }
        if(monsterWin == true){
            System.out.println("Monster Win!");
        }

        if (heroWin == true){
            System.out.println("Hero Win!");
            for (Heros h: heros){
                if(h.getHP() == 0){
                    h.setHP(h.getLevel()*50);
                }
                else{
                    double new_HP = h.getHP() * 1.1;
                    BigDecimal bd1 = new BigDecimal(new_HP);
                    bd1 = bd1.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
                    int newOne = bd1.intValue();
                    h.setHP(newOne);
                    double new_MP = h.getMP()*1.1;
                    BigDecimal bd2 = new BigDecimal(new_MP);
                    bd2 = bd2.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
                    int newMP = bd2.intValue();
                    h.setMP(newMP);
                    h.setMoney(h.getMoney()+150);
                    h.setMoney(h.getMoney()*2);
                }
            }
        }
        System.out.println();

    }


}
