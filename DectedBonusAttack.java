import java.util.ArrayList;

public class DectedBonusAttack {

    private static ArrayList<Heros> realHero;
    private static ArrayList<Monsters> realMonster;
    private static Board board;
    private int heroIndex;
    private int heroRow;
    private int heroCol;
    private Attack attack;
    private static Boolean heroWin;
    private static Boolean monsterWin;


    public DectedBonusAttack(ArrayList<Heros> realHero, ArrayList<Monsters> realMonster, int heroIndex, Board board){
        this.realHero = realHero;
        this.realMonster = realMonster;
        this.heroIndex = heroIndex;
        this.board = board;
        getCellTypeAndAttack();

    }

    public static Boolean getHeroWin() {
        return heroWin;
    }

    public static Boolean getMonsterWin() {
        return monsterWin;
    }

    public void getCellTypeAndAttack(){
        heroRow = realHero.get(heroIndex).getHeroRow();
        heroCol = realHero.get(heroIndex).getHeroCol();
        if(board.getStatus()[heroCol][heroRow] instanceof Bush){
            int temp = realHero.get(heroIndex).getDexterity();
            realHero.get(heroIndex).setDexterity(temp * 2);
            attack= new Attack(realHero,realMonster,heroIndex);
            heroWin = attack.getHeroWin();
            monsterWin = attack.getMonsterWin();
            realHero.get(heroIndex).setDexterity(temp);
        } else if (board.getStatus()[heroCol][heroRow] instanceof Cave) {
            int temp = realHero.get(heroIndex).getAgility();
            realHero.get(heroIndex).setAgility(temp*2);
            attack = new Attack(realHero,realMonster,heroIndex);
            heroWin = attack.getHeroWin();
            monsterWin = attack.getMonsterWin();
            realHero.get(heroIndex).setAgility(temp);
        } else if (board.getStatus()[heroCol][heroRow] instanceof Koulou) {
            int temp = realHero.get(heroIndex).getStrength();
            realHero.get(heroIndex).setStrength(temp * 2);
            attack= new Attack(realHero,realMonster,heroIndex);
            heroWin = attack.getHeroWin();
            monsterWin = attack.getMonsterWin();
            realHero.get(heroIndex).setStrength(temp);
        }
        else{
            attack = new Attack(realHero,realMonster,heroIndex);
        }
    }



}
