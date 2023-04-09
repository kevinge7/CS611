import java.util.ArrayList;
//initiate potion information
public class Potions extends item{

    private  int attributeIncrease;
    private ArrayList<String> attributeAffect;

    public Potions(String name,int cost, int level, int attributeIncrease,ArrayList<String> attributeAffect){
        super(name,cost,level);
        this.attributeIncrease = attributeIncrease;
        this.attributeAffect = attributeAffect;
    }


    public int getAttributeIncrease() {
        return attributeIncrease;
    }

    public ArrayList<String> getAttributeAffect() {
        return attributeAffect;
    }
}
