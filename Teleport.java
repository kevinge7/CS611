import java.util.ArrayList;

public class Teleport {
    /*
    Teleport function. Every time a hero need to teleport, a new instance of Teleport will be created.
    * */

    private ArrayList<Heros> heroList;

    private int actingHeroIndex;

    private Map map;

    private boolean movable;


    public Teleport(ArrayList<Heros> heroList, int actingHeroIndex, Map map){
        /* Every time when a hero wants to teleport, a new instance will be created with current map which has the record
        * of the position of all the heroes and monsters, name list of alive heroes and the acting hero index */
        this.heroList = heroList;
        this.actingHeroIndex = actingHeroIndex;
        this.map = map;
        this.movable = true;
    }

    public int requestTargetHeroIndex(){
        /*Prompt an inquiry about which hero to teleport. Then go through the list of alive heroes to print out the heroes
        * that are not in the same lane of the currently acting hero.*/
        System.out.println("Select a index of the hero whose adjacent cells you want to teleport to ");
        ArrayList<Integer> availableHeroIndex = new ArrayList<>();
        for (int i = 0;i< heroList.size();i++){
            if (i == actingHeroIndex){
                continue;
            }
            if (heroList.get(i).getCurrentLane() == heroList.get(actingHeroIndex).getCurrentLane()){
                /* if the hero is in the same lane then skip it.*/
                continue;
            }
            availableHeroIndex.add(i);
            System.out.print("   " + i + "   ");
            System.out.print(heroList.get(i).getName());
        }
        System.out.println(" ");
        if (availableHeroIndex.isEmpty()){
            movable = false;
            /*No place to teleport*/
            System.out.println("There is no hero can be targeted to teleport to.");
            throw new NegativeArraySizeException();
        }
        return PromptScan.scanWithinArray(availableHeroIndex);
    }

    public void requestTeleport(){
        /*Prompt an inquiry about which hero to teleport. Then go through the list of alive heroes to check if the heroes'
         * adjacent cells are good for teleporting to. Then only heroes with available adjacent cells will be printed out
         * and only inputs of the indices printed out are valid. */
        System.out.println("Select the index of the desired adjacent location of targeted hero");
        int targetHeroIndex = requestTargetHeroIndex();
        int targetedHeroCol = heroList.get(targetHeroIndex).getHeroCol();
        int targetedHeroRow = heroList.get(targetHeroIndex).getHeroRow();
        ArrayList<Integer> availableLocationIndex = new ArrayList<>();
        if (targetedHeroRow > 0 && !map.getStatus()[targetedHeroCol][targetedHeroRow - 1].isHeroOccupied()){
            System.out.println("Type 1 to teleport to the location behind targeted hero.");
            availableLocationIndex.add(1);
        }
        if (targetedHeroCol > 0 && !map.getStatus()[targetedHeroCol - 1][targetedHeroRow].isHeroOccupied() &&
                !(map.getStatus()[targetedHeroCol - 1][targetedHeroRow] instanceof Inaccessible)){
            System.out.println("Type 2 to teleport on the left of targeted  hero.");
            availableLocationIndex.add(2);
        }
        if (targetedHeroCol < 7 && !map.getStatus()[targetedHeroCol + 1][targetedHeroRow].isHeroOccupied() &&
                !(map.getStatus()[targetedHeroCol + 1][targetedHeroRow] instanceof Inaccessible)){
            System.out.println("Type 3 to teleport to the location to the right of targeted hero.");
            availableLocationIndex.add(3);
        }
        if (availableLocationIndex.isEmpty()){
            throw new NegativeArraySizeException();
        }
        int targetLocationIndex = PromptScan.scanWithinArray(availableLocationIndex);
        int targetLocationCol = targetedHeroCol;
        int targetLocationRow = targetedHeroRow;
        switch (targetLocationIndex) {
            case 1 -> targetLocationRow = targetedHeroRow - 1;
            case 2 -> targetLocationCol = targetedHeroCol - 1;
            case 3 -> targetLocationCol = targetedHeroCol + 1;
        }
        int[] newPosition = new int[2];
        int[] oldPosition = new int[2];
        oldPosition[0] = heroList.get(actingHeroIndex).getHeroCol();
        oldPosition[1] = heroList.get(actingHeroIndex).getHeroRow();
        newPosition[0] = targetLocationCol;
        newPosition[1] = targetLocationRow;
        map.HeroMove(actingHeroIndex,heroList,  newPosition, oldPosition);
        heroList.get(actingHeroIndex).setHeroCol(newPosition[0]);
        heroList.get(actingHeroIndex).setHeroRow(newPosition[1]);
    }







}
