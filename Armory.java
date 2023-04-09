
//Define he Armory item
public class Armory extends item{

    private int damage_reduce;


    public Armory(String name, int cost, int level, int damage_reduce){
        super(name,cost,level);
        this.damage_reduce = damage_reduce;

    }


    public int getDamage_reduce() {
        return damage_reduce;
    }

}
