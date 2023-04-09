import java.util.ArrayList;
import java.util.Random;

public class generatePosition {
    private int start;
    private int end;
    private String name;
    private Board board;
    private ArrayList<Heros> realhero = new ArrayList<Heros>();
    private ArrayList<Monsters> realMonster = new ArrayList<Monsters>();


    public generatePosition(int start, int end, String name, Board board, ArrayList<Heros> realhero, ArrayList<Monsters> realMonster){
        this.start = start;
        this.end = end;
        this.name = name;
        this.realhero = realhero;
        this.board = board;
        this.realMonster = realMonster;
        if(name.charAt(0) == 'H'){
            generateHero();
        }
        else {
            generateMonster();
        }
    }

    public void generateHero(){
        Random random = new Random();
        int hpo = random.nextInt(start,end);
        board.getStatus()[hpo][0].setCurrentInfo(name+"   ");
        if(realhero.size() == 1){
            realhero.get(0).sethHeroRow(0);
            realhero.get(0).setHeroCol(hpo);
            realhero.get(0).setIndex(0);
        }
        else if(realhero.size() == 2){
            realhero.get(1).setHeroCol(hpo);
            realhero.get(1).sethHeroRow(0);
            realhero.get(1).setIndex(1);
        }
        else {
            realhero.get(2).sethHeroRow(0);
            realhero.get(2).setHeroCol(hpo);
            realhero.get(2).setIndex(2);
        }
    }

    public void generateMonster(){
        Random random = new Random();
        int hpo = random.nextInt(start,end);
        board.getStatus()[hpo][7].setCurrentInfo("   "+name);
        if (realMonster.size() > 0){
            if (realMonster.size() == 1){
                realMonster.get(0).setMonsterCol(hpo);
                realMonster.get(0).setMonsterRow(7);
                realhero.get(0).setIndex(0);
            } else if (realMonster.size() == 2) {
                realMonster.get(1).setMonsterRow(7);
                realMonster.get(1).setMonsterCol(hpo);
                realMonster.get(1).setIndex(1);
            }
            else {
                realMonster.get(2).setMonsterCol(hpo);
                realMonster.get(2).setMonsterRow(7);
                realMonster.get(2).setIndex(2);
            }
        }
    }
}
