import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

public class Recall {

    private int actingHeroIndex;

    private ArrayList<Heros> heroList;
    private Map map;

    public Recall(int actingHeroIndex, ArrayList<Heros> heroList, Map map){
        this.actingHeroIndex = actingHeroIndex;
        this.map = map;
        this.heroList = heroList;
    }

    public void back() throws OccupiedLocationException {
        Heros actingHero = heroList.get(actingHeroIndex);
        int[] oldLocation = new int[2];
        oldLocation[0] = actingHero.getHeroCol();
        oldLocation[1] = actingHero.getHeroRow();
        int[] newLocation = actingHero.getHomeLocation();
        if (map.getStatus()[newLocation[0]][newLocation[1]].isHeroOccupied()){
            throw new OccupiedLocationException("Home is occupied by other heroes!");
        }
        map.HeroMove(actingHeroIndex, heroList, actingHero.getHomeLocation(), oldLocation);
        heroList.get(actingHeroIndex).setHeroCol(newLocation[0]);
        heroList.get(actingHeroIndex).setHeroRow(newLocation[1]);
    }

}
