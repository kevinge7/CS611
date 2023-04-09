import java.util.ArrayList;
import java.util.Random;

public class Map {
    private static Board board;
    ArrayList<Heros> herolist;
    generatePosition generateHero;

    public Map(Board board){
        this.board = board;

    }

    public void print(){
        board.display();
    }

    public void HeroMove(int heroIndex, int[] position, int[] origin){
        Cell currentCell = board.getStatus()[position[0]][position[1]];
        String monsterInfo = currentCell.getCurrentInfo().substring(2);
        int heroNum = heroIndex + 1;
        currentCell.setCurrentInfo("H" + heroNum + monsterInfo);

        Cell oldCell = board.getStatus()[origin[0]][origin[1]];
        String oldMonsterInfo = oldCell.getCurrentInfo().substring(2);
//        System.out.println(oldMonsterInfo);
        oldCell.setCurrentInfo("  " + oldMonsterInfo);
    }

    public void MonsterMove(int monsterIndex, int[] position, int[] origin){
        Cell currentCell = board.getStatus()[position[0]][position[1]];
        String heroInfo = currentCell.getCurrentInfo().substring(0,3);
        int monsterNum = monsterIndex + 1;
        currentCell.setCurrentInfo(heroInfo + "M" + monsterNum);

        Cell oldCell = board.getStatus()[origin[0]][origin[1]];
        String oldHeroInfo = oldCell.getCurrentInfo().substring(0,3);
        oldCell.setCurrentInfo(oldHeroInfo + "  ");
    }
    public void MonsterLeave(int currentCol, int currentRow){
        Cell oldCell = board.getStatus()[currentCol][currentRow];
        String oldHeroInfo = oldCell.getCurrentInfo().substring(0,3);
        oldCell.setCurrentInfo(oldHeroInfo + "  ");
    }

}
