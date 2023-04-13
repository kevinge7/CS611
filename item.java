//define all the item in this class. All other items are inheritance from this class.
public abstract class item {
    private String Name;
    private int cost;
    private int requiredLevel;

    public item(String name, int cost, int requiredLevel){
        this.Name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
    }
    public String getName(){
        return Name;
    }
    public int getCost(){
        return cost;
    }
    public int getRequiredLevel(){
        return requiredLevel;
    }
}
