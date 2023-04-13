import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
//process all the request to change the board.
public class Map {
    private static Board board;

    private
    ArrayList<Heros> herolist;
    generatePosition generateHero;

    private ArrayList<Lane> laneGroup = new ArrayList<>();






    public Map(Board board, ArrayList<Heros> herolist){
        this.herolist = herolist;
        this.board = board;
        for (int i = 0;i<3;i++){
            Lane lane = new Lane(this, i, herolist);
            laneGroup.add(lane);
        }
    }

    public void updateLane(){
        for (int i = 0;i<3;i++){
            laneGroup.get(i).update();
        }
    }

    public int getHighestRowLane(int laneIndex){
        return laneGroup.get(laneIndex).getHighestHeroRow();
    }

    public void print(){
        board.display();
    }



    //update board when hero move
    public void HeroMove(int heroIndex, ArrayList<Heros> heroList, int[] position, int[] origin){
        Cell currentCell = board.getStatus()[position[0]][position[1]];
        String monsterInfo = currentCell.getCurrentInfo().substring(2);
        int heroNum = heroIndex + 1;
        currentCell.setCurrentInfo("H" + heroNum + monsterInfo);

        Cell oldCell = board.getStatus()[origin[0]][origin[1]];
        String oldMonsterInfo = oldCell.getCurrentInfo().substring(2);
        oldCell.setCurrentInfo("  " + oldMonsterInfo);
        heroList.get(heroIndex).setHeroCol(position[0]);
        heroList.get(heroIndex).setHeroRow(position[1]);
        updateLane();
        System.out.println("Highest row lane");
        System.out.println("0" + getHighestRowLane(0));
        System.out.println("1"+getHighestRowLane(1));
        System.out.println("2" + getHighestRowLane(2));
    }

    //update board when monster move
    public void MonsterMove(int monsterIndex, int[] position, int[] origin){
        Cell currentCell = board.getStatus()[position[0]][position[1]];
        String heroInfo = currentCell.getCurrentInfo().substring(0,3);
        int monsterNum = monsterIndex + 1;
        currentCell.setCurrentInfo(heroInfo + "M" + monsterNum);

        Cell oldCell = board.getStatus()[origin[0]][origin[1]];
        String oldHeroInfo = oldCell.getCurrentInfo().substring(0,3);
        oldCell.setCurrentInfo(oldHeroInfo + "  ");
    }

    //erase monster from the board.
    public void MonsterLeave(int currentCol, int currentRow){
        Cell oldCell = board.getStatus()[currentCol][currentRow];
        String oldHeroInfo = oldCell.getCurrentInfo().substring(0,3);
        oldCell.setCurrentInfo(oldHeroInfo + "  ");

    }

    public void HeroLeave(int currentCol, int currentRow){
        Cell oldCell = board.getStatus()[currentCol][currentRow];
        String oldMonsterInfo = oldCell.getCurrentInfo().substring(2);
        oldCell.setCurrentInfo("  " + oldMonsterInfo);
        updateLane();

    }

    public Cell[][] getStatus(){
        return board.getStatus();
    }

    public void display(){
        board.display();
    }

}
