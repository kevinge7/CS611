//initiate weapon information
public class Weaponry extends item{

    private int damage;
    private int hands;
//initiate weapon information
    public Weaponry(String name, int cost,int level,int damage, int hands){
        super(name,cost,level);
        this.damage = damage;
        this.hands = hands;
    }

    public int getDamage() {
        return damage;
    }

    public int getHands() {
        return hands;
    }
}
