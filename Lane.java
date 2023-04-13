import java.util.ArrayList;

public class Lane {
    private ArrayList<Heros> herosInLane = new ArrayList<>();

    private ArrayList<Monsters> monstersInLane;

    private int laneIndex;

    private Map map;

    private ArrayList<Heros> heroList;

    public Lane(Map map, int laneIndex, ArrayList<Heros> heroList){
        this.heroList = heroList;
        this.map = map;
        this.laneIndex = laneIndex;
        update();
    }
    public void update(){
        herosInLane = new ArrayList<>();
        for (int col = 3 * laneIndex; col <= 3 * laneIndex + 1;col++){
            for (int row = 0; row < 8; row++){
                String cellInfo = map.getStatus()[col][row].getCurrentInfo();
                if (cellInfo.contains("H")){
                    int heroIndex = cellInfo.charAt(1) - '0' - 1;
                    herosInLane.add(heroList.get(heroIndex));
                }
            }
        }
    }

    public int getLaneIndex() {
        return laneIndex;
    }

    public void setLaneIndex(int laneIndex) {
        this.laneIndex = laneIndex;
    }

    public int getHighestHeroRow() {
        if (herosInLane.isEmpty()) {
            return -1;
        }
        int highestRow = -1;
        for (Heros i : herosInLane) {
            highestRow = Math.max(highestRow, i.getHeroRow());
        }
        return highestRow;
    }


    public ArrayList<Heros> getHerosInLane() {
        return herosInLane;
    }

    public ArrayList<Monsters> getMonstersInLane() {
        return monstersInLane;
    }

    public void setHerosInLane(ArrayList<Heros> herosInLane) {
        this.herosInLane = herosInLane;
    }

    public void setMonstersInLane(ArrayList<Monsters> monstersInLane) {
        this.monstersInLane = monstersInLane;
    }
}
