import java.util.*;

public class launch {
    private static Board board = new Board();
    private HeroList heroList = new HeroList();
    private MonsterList monsterList = new MonsterList();
    public static Map map;
    private InputValidator inputValidator = new InputValidator();
    private static ArrayList<Heros> realHeroes = new ArrayList<Heros>();
    private generatePosition generate;
    private Move move;
    private static ArrayList<Monsters> realMonsters = new ArrayList<Monsters>();
    private static Set<Integer> Heroinputs = new HashSet<>();
    private static Set<Integer> MonsterInputs = new HashSet<>();
    Random random = new Random();

    private static int select;


    public void generateAll(){
        System.out.println("Welcome to Legends of Valor!");
        generateH1();
        generateH2();
        generateH3();
        generateM1();
        generateM2();
        generateM3();
        System.out.println("Here is the board!");

        board.display();
        move = new Move(board,realHeroes,realMonsters);
    }
    public void generateH1(){
        System.out.println("Please select your first hero:(Answer by number)");
        heroList.print();
        select = inputValidator.getInt(heroList.getHeroList().size());
        Heroinputs.add(select);
        realHeroes.add(heroList.getHeroList().get(select-1));
        generate = new generatePosition(0,2,"H1",board,realHeroes,realMonsters);
    }

    public void generateH2(){
        System.out.println("Please select your Second hero:(Answer by number)");
        heroList.print();
        select = inputValidator.getInt(heroList.getHeroList().size());
        if(Heroinputs.contains(select)){
            System.out.println("You already select this hero.");
            System.out.println("Please make another selection");
            generateH2();
        }
        else{
            Heroinputs.add(select);
            realHeroes.add(heroList.getHeroList().get(select-1));
            generate = new generatePosition(3,5,"H2",board,realHeroes,realMonsters);
        }
    }

    public void generateH3(){
        System.out.println("Please select your third hero:(Answer by number)");
        heroList.print();
        select = inputValidator.getInt(heroList.getHeroList().size());
        if (Heroinputs.contains(select)){
            System.out.println("You already select this hero.");
            System.out.println("Please make another selection");
            generateH2();
        }
        else {
            realHeroes.add(heroList.getHeroList().get(select-1));
            Heroinputs.add(select);
            generate = new generatePosition(6,8,"H3",board,realHeroes,realMonsters);
        }
    }

    public void generateM1(){

        int a = random.nextInt(monsterList.getMonsterList().size());
        MonsterInputs.add(a);
        realMonsters.add(monsterList.getMonsterList().get(a));
        generate = new generatePosition(0,2,"M1",board,realHeroes,realMonsters);
    }

    public void generateM2(){
        int d = random.nextInt(monsterList.getMonsterList().size());
        if(MonsterInputs.contains(d)){
            generateM2();
        }
        else {
            MonsterInputs.add(d);
            realMonsters.add(monsterList.getMonsterList().get(d));
            generate = new generatePosition(3,5,"M2",board,realHeroes,realMonsters);
        }
    }
    public void generateM3(){

        int e = random.nextInt(monsterList.getMonsterList().size());
        if (MonsterInputs.contains(e)){
            generateM3();
        }
        else {
            realMonsters.add(monsterList.getMonsterList().get(e));
            generate = new generatePosition(6,8,"M3",board,realHeroes,realMonsters);
        }
    }
}
