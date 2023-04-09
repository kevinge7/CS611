public class Spells extends item{

    private int damage;
    private int mana_cost;
//initiate spell information
    public Spells(String name,int cost,int level,int damage, int mana_cost){
        super(name,cost,level);

        this.damage = damage;
        this.mana_cost = mana_cost;
    }


    public int getMana_cost() {
        return mana_cost;
    }

    public int getDamage() {
        return damage;
    }
}
