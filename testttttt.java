import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class testttttt {



    public static void main(String[] args) {
//        ArrayList<Heros> realHero = new ArrayList<Heros>();
//        ArrayList<Monsters> realMonster = new ArrayList<Monsters>();
//        HeroList heroList = new HeroList();
//        MonsterList monsterList = new MonsterList();
//
//        realHero.add(heroList.getHeroList().get(0));
//        realHero.add(heroList.getHeroList().get(1));
//        realHero.add(heroList.getHeroList().get(2));
//        realMonster.add(monsterList.getMonsterList().get(0));
//        realMonster.add(monsterList.getMonsterList().get(1));
//        realMonster.add(monsterList.getMonsterList().get(2));
//        Attack attack = new Attack(realHero,realMonster,1);
        ArrayList<Boolean> resultList = new ArrayList<>(Collections.nCopies(3, (Boolean) null));
        int i = 0;
        int check = 0;
        while(true){
            resultList.set(i,true);
            System.out.println(i);
            i++;
            for (Boolean obj: resultList){
                if(obj instanceof Boolean){
                    check++;
                }
                else {
                    check = 0;
                    break;
                }
            }
            if(check == 3){
                System.out.println("结束");
                break;
            }
        }

    }
}
