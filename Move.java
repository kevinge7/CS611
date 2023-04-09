import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Move {
    private static Board board;
    private static ArrayList<Heros> heroList;
    private static ArrayList<Monsters> monstersList;
    private InputValidator inputValidator = new InputValidator();
    private String sel;
    private static int heroRow;
    private static int heroCol;
    private static int monsterRow;
    private static int monsterCol;
    private static int heroIndex;
    private Market market;
    private Attack attack;
    private static boolean heroWin;
    private static boolean monsterWin;
    private static ArrayList<Boolean> resultList;
    private launch l = new launch();
    private static boolean moveable;


    /*用map来操作board*/
    private Map boardDecorator;

    public Move(Board board, ArrayList<Heros> heroList, ArrayList<Monsters> monstersList){
        this.board = board;
        this.heroList = heroList;
        this.monstersList = monstersList;
        heroWin = false;
        monsterWin = false;
        this.boardDecorator = new Map(board);
        resultList = new ArrayList<>(Collections.nCopies(3, (Boolean) null));
        moveable = false;
        sel = "";
        run();

    }
    public void run(){
        while(true) {
            for (int i = 0; i < resultList.size(); i++) {
                if(resultList.get(i) == null){
                    heroIndex = i;
                }
                else {
                    break;
                }

                if (heroList.get(i).getHP() > 0) {
                        int heroNum = i + 1;
                  System.out.println("Please select a movement for H" + heroNum);
                    System.out.println("• W/w: move up\n" +
                            "• A/a: move left\n" +
                            "• S/s: move down\n" +
                            "• D/d: move right\n" +
                            "• Q/q: quit game\n" +
                            "• I/i: show information");
                }

                //get hero and monster current location
                heroRow = heroList.get(heroIndex).getHeroRow();
                heroCol = heroList.get(heroIndex).getHeroCol();
                monsterRow = monstersList.get(heroIndex).getMonsterRow();
                monsterCol = monstersList.get(heroIndex).getMonsterCol();
//                System.out.println("this is hero row:" + heroRow);
//                System.out.println("this is hero col:" + heroCol);
//                System.out.println("this is Monster row:" + monsterRow);
//                System.out.println("this is monster col:" + monsterCol);

                Scanner input = new Scanner(System.in);

                sel = input.next();
                System.out.println(sel);
                if (sel.equals("W")| sel.equals("w")) {
                    moveUp();
                    monsterMove();
                } else if (sel.equals("A")|| sel.equals("a")) {
                    moveLeft();
                    monsterMove();
                } else if (sel.equals("S")|| sel.equals("s")) {
                    moveDown();
                    monsterMove();
                } else if (sel.equals("D")|| sel.equals("d")) {
                    moveRight();
                    monsterMove();
                }
                else if (sel.equals("Q") || sel.equals("q")){
                    break;
                } else if (sel.equals("i") || sel.equals("I")) {
                    for(Heros h: heroList){
                        System.out.println("Hero " + h.getName() + " left " + h.getHP());
                    }
                    System.out.println();
                }
                if (moveable == false){
                    i--;
                }
                if(heroWin == true){
                    afterBattle();
                }
            }
            if (sel.equals("Q") || sel.equals("q")){
                break;
            }

            int check = 0;
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
                break;
            }
        }
        System.out.println("Conclusion:");
        for(int jk = 0; jk<resultList.size();jk++){
            int Num = jk+1;
            if(resultList.get(jk) == true){
                System.out.println("Hero " + Num + " Wins!");
            }
            else {
                System.out.println("Monster " + Num + "Wins!");
            }

        }
        System.out.println("Game end!");
    }

    public void checkInMarketOrnot(){
        System.out.println("Hero current in the market spot!");
        System.out.println("Do you want hero enter the market?");
        System.out.println("1. Yes  2. No (Answer by number)");
        int a = inputValidator.getInt(3);
        if (a == 1){
            market = new Market(heroList,heroIndex);
        }
    }

    public boolean checkAttackOrNot(int heroRow,int heroCol){
        boolean canAttackOrNot;
        if (board.getStatus()[heroCol][heroRow].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.min(7,heroCol+1)][heroRow].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.max(0,heroCol-1)][heroRow].getCurrentInfo().contains("M") ||
                board.getStatus()[heroCol][Math.min(7,heroRow+1)].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.max(0, heroCol-1)][Math.min(7, heroRow+1)].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.min(7, heroCol+1)][Math.min(7, heroRow+1)].getCurrentInfo().contains("M")){
            canAttackOrNot = true;
        }
        else {
            canAttackOrNot = false;
        }
        return canAttackOrNot;
    }

    public void moveUp() {
        //向上移动不需要检测能够碰到不可访问区域的问题
        //先检测hero的移动是否合法
        if (heroRow + 1 > monsterRow|| board.getStatus()[heroCol][heroRow+1].getCurrentInfo().contains("H")) {
            System.out.println("Your hero cannot make that move. ");
            moveable = false;
        }
        //如果合法的话 先检测英雄走一步的话 英雄能不能赢
        else {
            moveable = true;
            heroRow ++;
            heroList.get(heroIndex).sethHeroRow(heroRow);
            if (heroRow== 7) {
                int heroNum = heroIndex + 1;
                System.out.println("Hero " + heroNum + " Win!");
                resultList.set(heroIndex,true);
            }
            //在检测英雄的这一步是不是会进market
            else if (board.getStatus()[heroCol][heroRow] instanceof Nexus) {
                checkInMarketOrnot();
            }
            //再检测英雄走这一步会不会有怪物在范围内，如果有的话 可以直接走过去开始攻击
            else if (checkAttackOrNot(heroRow,heroCol) == true) {
                System.out.println("Monster is in hero attack range. Do you want to attack? ");
                System.out.println("1. Yes\n 2. No (Answer by number)");
                int attackOrNot = inputValidator.getInt(3);
                if(attackOrNot == 1){
                    attack = new Attack(heroList, monstersList, heroIndex);
                    heroWin = attack.getHeroWin();
                    monsterWin = attack.getMonsterWin();
                }
            }
            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol;
                oldPosition[1] = heroRow-1;
                boardDecorator.HeroMove(heroIndex, newPosition , oldPosition);
                board.display();
            }

        }
    }

    public void afterBattle(){
        if(monsterWin == true){
            if (heroIndex == 1) {

                l.generateH1();
            } else if (heroIndex == 2) {
                l.generateH2();
            }
            else {
                l.generateH3();
            }
        }
        if (heroWin == true){
            monstersList.get(heroIndex).LeaveCurrentLocation(boardDecorator);
            if (heroIndex == 1) {
                l.generateM1();
            } else if (heroIndex == 2) {

                l.generateM2();
            }
            else {

                l.generateM3();
            }
        }
    }

    public void moveDown(){
        //向下移动不需要检测移动是否合法 因为向下移动不会使英雄越过怪兽 需要检测会不会超过底线的移动
        if(heroRow == 0|| board.getStatus()[heroCol][heroRow-1].getCurrentInfo().contains("H")){
            System.out.println("You cannot make this move!");
            moveable = false;

        } //如果合法的话 先检测是否会进入market
        else {
            moveable = true;
            heroRow --;
            heroList.get(heroIndex).sethHeroRow(heroRow);
            if (board.getStatus()[heroCol][heroRow] instanceof Nexus) {
                checkInMarketOrnot();
            }//检测是否有怪物在英雄的攻击范围
            else if (checkAttackOrNot(heroRow,heroCol) == true) {
                System.out.println("Monster is in hero attack range. Do you want to attack? ");
                System.out.println("1. Yes\n2. No (Answer by number)");
                int attackOrNot = inputValidator.getInt(3);
                if(attackOrNot == 1){
                    attack = new Attack(heroList, monstersList, heroIndex);
                    heroWin = attack.getHeroWin();
                    monsterWin = attack.getMonsterWin();
                }
            }
            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol;
                oldPosition[1] = heroRow + 1;
                boardDecorator.HeroMove(heroIndex, newPosition , oldPosition);
                board.display();
            }
        }
    }

    public void moveLeft(){
        if(heroCol == 0 || board.getStatus()[heroCol-1][heroRow] instanceof Inaccessible
                || board.getStatus()[heroCol-1][heroRow].getCurrentInfo().contains("H")){
            System.out.println("Hero cannot make this move.");
            moveable = false;
        }
        else {
            moveable = true;
            heroCol--;
            heroList.get(heroIndex).setHeroCol(heroCol);
            if (board.getStatus()[heroCol][heroRow] instanceof Nexus) {
                checkInMarketOrnot();
            } else if (checkAttackOrNot(heroRow,heroCol) == true) {
                System.out.println("Monster is in hero attack range. Do you want to attack? ");
                System.out.println("1. Yes\n2. No (Answer by number)");
                int attackOrNot = inputValidator.getInt(3);
                if(attackOrNot == 1){
                    attack = new Attack(heroList, monstersList, heroIndex);
                    heroWin = attack.getHeroWin();
                    monsterWin = attack.getMonsterWin();
                }
            }
            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol + 1;
                oldPosition[1] = heroRow;
                boardDecorator.HeroMove(heroIndex, newPosition , oldPosition);
                board.display();
            }
        }
    }

    public void moveRight(){
        if(heroCol+1>=8 || board.getStatus()[heroCol+1][heroRow] instanceof Inaccessible){
            System.out.println("Hero cannot make this move.");
            moveable = false;
        }
        else{
            moveable = true;
            heroCol++;
            heroList.get(heroIndex).setHeroCol(heroCol);
            if (board.getStatus()[heroCol][heroRow] instanceof Nexus) {
                checkInMarketOrnot();
            } else if (checkAttackOrNot(heroRow,heroCol) == true) {
                System.out.println("Monster is in hero attack range. Do you want to attack? ");
                System.out.println("1. Yes\n2. No (Answer by number)");
                int attackOrNot = inputValidator.getInt(3);
                if(attackOrNot == 1){
                    attack = new Attack(heroList, monstersList, heroIndex);
                    heroWin = attack.getHeroWin();
                    monsterWin = attack.getMonsterWin();
                }
            }
            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol - 1;
                oldPosition[1] = heroRow;
                boardDecorator.HeroMove(heroIndex, newPosition , oldPosition);
                board.display();
            }
        }
    }

    public void monsterMove(){
        if (monsterRow > heroRow){
            monsterRow --;
            int[] newPosition = new int[2];
            newPosition[0] = monsterCol;
            newPosition[1] = monsterRow;
            int[] oldPosition = new int[2];
            oldPosition[0] = monsterCol;
            oldPosition[1] = monsterRow + 1;
            boardDecorator.MonsterMove(heroIndex, newPosition, oldPosition );
            monstersList.get(heroIndex).setMonsterRow(monsterRow);
            //board.display();
        }
        else if(monsterRow - 1 == 0) {
            resultList.set(heroIndex,false);
            int monsterNum = heroIndex + 1;
            System.out.println("Monster " +monsterNum + " Wins!" );
        }
    }

}
