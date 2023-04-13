import java.util.ArrayList;
import java.util.Random;

public class ReBorn {
    private HeroList heroList = new HeroList();
    private MonsterList monsterList = new MonsterList();
    private int index;
    private ArrayList<Heros> realHero;
    private static ArrayList<Monsters> realMonster;
    private static Board board;

    public ReBorn(ArrayList<Heros> realHero, ArrayList<Monsters> realMonster, int index, Board board){
        this.realHero = realHero;
        this.realMonster = realMonster;
        this.index = index;
        this.board = board;
        if (realMonster.size() == 2){
            rebornMonster();
        }
        if (realHero.size() == 2){
            rebornHero();
        }
    }
    public void rebornMonster(){
        Random random = new Random();
        int a = random.nextInt(monsterList.getMonsterList().size());
        realMonster.add(index,monsterList.getMonsterList().get(a));
        if(index == 0){
            int hpo = random.nextInt(0,2);
            if(!board.getStatus()[0][7].getCurrentInfo().contains("M") &&
                    !board.getStatus()[1][7].getCurrentInfo().contains("M")){
                board.getStatus()[hpo][7].setCurrentInfo("   M1");
                realMonster.get(index).setMonsterCol(hpo);
                realMonster.get(index).setMonsterRow(7);
                realMonster.get(index).setIndex(0);
            }

        } else if (index == 1) {
            if (!board.getStatus()[3][7].getCurrentInfo().contains("M") &&
                    !board.getStatus()[4][7].getCurrentInfo().contains("M")){
            int hpo = random.nextInt(3,5);
            board.getStatus()[hpo][7].setCurrentInfo("   M2");
                realMonster.get(index).setMonsterCol(hpo);
                realMonster.get(index).setMonsterRow(7);
                realMonster.get(index).setIndex(1);
            }
        }
        else {
            if (!board.getStatus()[6][7].getCurrentInfo().contains("M") &&
                    !board.getStatus()[7][7].getCurrentInfo().contains("M")){
            int hpo = random.nextInt(6,8);
            board.getStatus()[hpo][7].setCurrentInfo("   M3");
                realMonster.get(index).setMonsterCol(hpo);
                realMonster.get(index).setMonsterRow(7);
                realMonster.get(index).setIndex(2);
            }
        }
    }

    public void rebornHero(){
        Random random = new Random();
        int a = random.nextInt(monsterList.getMonsterList().size());
        realHero.add(index, heroList.getHeroList().get(a));
        if(index == 0){
            int hpo = random.nextInt(0,2);
            if(!board.getStatus()[0][7].getCurrentInfo().contains("H") &&
                    !board.getStatus()[1][7].getCurrentInfo().contains("H")) {
                board.getStatus()[hpo][7].setCurrentInfo("H1   ");
                realHero.get(index).setHeroCol(hpo);
                realHero.get(index).setHeroRow(0);
            }
        } else if (index == 1) {
            if (!board.getStatus()[3][7].getCurrentInfo().contains("H") &&
                    !board.getStatus()[4][7].getCurrentInfo().contains("H")){
                int hpo = random.nextInt(3,5);
                board.getStatus()[hpo][7].setCurrentInfo("H2   ");
                realHero.get(index).setHeroCol(hpo);
                realHero.get(index).setHeroRow(0);
            }
        }
        else {
            if (!board.getStatus()[6][7].getCurrentInfo().contains("H") &&
                    !board.getStatus()[7][7].getCurrentInfo().contains("H")){
                int hpo = random.nextInt(6,8);
                board.getStatus()[hpo][7].setCurrentInfo("H3   ");
                realHero.get(index).setHeroCol(hpo);
                realHero.get(index).setHeroRow(0);
            }
        }
    }
    public ArrayList<Monsters> getRealMonster(){
        return realMonster;
    }
    public ArrayList<Heros> getRealHero(){
        return realHero;
    }
}
