import java.util.ArrayList;
//initial hero basic information
public abstract class Heros {
    private String name;
    private int level;
    private int MP;
    private int strength;
    private int dexterity;
    private int agility;
    private int gold;
    private ArrayList<item> items;
    private int HP;
    private int heroRow;
    private int heroCol;
    private int index;


    public Heros(String name, int mana, int strength, int agility, int dexterity, int money, int experience) {
        this.name = name;
        this.MP = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.gold = money;
        this.level = experience;
        this.HP = experience * 100;
        heroRow = 0;
        heroCol = 0;
        index = 0;
        items = new ArrayList<item>();
    }

    public int getHeroRow(){
        return heroRow;
    }

    public void sethHeroRow(int heroRow){
        this.heroRow = heroRow;

    }    public String getName(){
        return name;
    };

    public void setName(String name){
        this.name = name;
    };

    public  int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getMP(){
        return MP;
    }

    public void setMP(int MP){
        this.MP = MP;
    };

    public int getStrength(){
        return strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getDexterity(){
        return dexterity;
    }

    public void setDexterity(int dexterity){
        this.dexterity =dexterity;
    }

    public int getAgility(){
        return agility;
    }

    public void setAgility(int agility){
        this.agility = agility;
    }

    public int getMoney(){
        return gold;
    }

    public void setMoney(int money){
        this.gold = money;
    }

    public ArrayList<item> getItems(){
        return items;
    }

    public void setItems(item i) {
        items.add(i);
    }

    public void setItems(ArrayList<item> items) {
        this.items = items;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHeroCol() {
        return heroCol;
    }

    public void setHeroCol(int heroCol) {
        this.heroCol = heroCol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
