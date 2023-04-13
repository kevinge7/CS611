import java.util.ArrayList;
import java.util.Collections;


//define monster and hero move
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
    private DetectedBonusAttack dectedBonusAttack;
    private Map boardDecorator;
    private static Boolean gameEndOrNot;

    public Move(Board board, ArrayList<Heros> heroList, ArrayList<Monsters> monstersList){
        this.board = board;
        this.heroList = heroList;
        this.monstersList = monstersList;
        heroWin = false;
        monsterWin = false;
        this.boardDecorator = new Map(board, heroList);
        resultList = new ArrayList<>(Collections.nCopies(3, (Boolean) null));
        moveable = false;
        gameEndOrNot = false;
        sel = "";
        run();
    }

    public void run(){
        while(true) {
            if (gameEndOrNot == false) {
                for (int i = 0; i < resultList.size(); i++) {
                    if (resultList.get(i) == null) {
                        heroIndex = i;
                    } else {
                        break;
                    }
                    moveable = false;
                    if (heroList.get(i).getHP() > 0) {
                        int heroNum = i + 1;
                        board.display();
                        System.out.println("Please select a movement for H" + heroNum);
                        System.out.println("• W/w: move up\n" +
                                "• A/a: move left\n" +
                                "• S/s: move down\n" +
                                "• D/d: move right\n" +
                                "• T/t: teleport\n" +
                                "• R/r: recall to Nexus\n" +
                                "• Q/q: quit game\n" +
                                "• I/i: show information");
                    }

                    //get hero and monster current location
                    heroRow = heroList.get(heroIndex).getHeroRow();
                    heroCol = heroList.get(heroIndex).getHeroCol();
                    monsterRow = monstersList.get(heroIndex).getMonsterRow();
                    monsterCol = monstersList.get(heroIndex).getMonsterCol();

                    System.out.println("Monster row: "+monsterRow);
                    System.out.println("Monster Col: " + monsterCol);

                    sel = inputValidator.getChar();
                    if (sel.equals("W") | sel.equals("w")) {
                        moveUp();

                        if (moveable){ heroWin = false; monsterMove();}
                        if(gameEndOrNot == true){
                            break;
                        }
                    } else if (sel.equals("A") || sel.equals("a")) {
                        moveLeft();
                        if (moveable){
                            heroWin = false;
                            monsterMove();}
                    } else if (sel.equals("S") || sel.equals("s")) {
                        moveDown();
                        if (moveable){ heroWin = false;monsterMove();}
                    } else if (sel.equals("D") || sel.equals("d")) {
                        moveRight();
                        if (moveable){ heroWin = false; monsterMove();}
                    } else if (sel.equals("T") || sel.equals("t")) {
                        moveable = true;
                        try {
                            Teleport teleport = new Teleport(heroList, heroIndex, boardDecorator);
                            teleport.requestTeleport();
                            if (heroList.get(heroIndex).getHeroRow() == 0) {
                                checkInMarketOrnot();
                            }
                            monsterMove();
                        } catch (NegativeArraySizeException e) {
                            System.out.println("No available location to teleport.");
                            moveable = false;
                        }
                    } else if (sel.equals("R") || sel.equals("r")) {
                        moveable = true;
                        try {
                            Recall recall = new Recall(heroIndex, heroList, boardDecorator);
                            recall.back();
                            checkInMarketOrnot();
                            monsterMove();
                        } catch (OccupiedLocationException e) {
                            System.out.println(e.getMessage());
                            moveable = false;
                        }
                    } else if (sel.equals("Q") || sel.equals("q")) {
                        break;
                    } else if (sel.equals("i") || sel.equals("I")) {
                        for (Heros h : heroList) {
                            System.out.println("Hero " + h.getName() + " HP left " + h.getHP());
                        }
                        System.out.println();
                    }
                    if (!moveable) {
                        i--;
                    }
                }
                if (sel.equals("Q") || sel.equals("q")) {
                    break;
                }
        }
        else{
                System.out.println("Game end!");
                break;
            }
        }
    }

    public void beginAttack(){
        System.out.println("Monster is in hero attack range. Do you want to attack? ");
        System.out.println("1. Yes\n2. No (Answer by number)");
        int attackOrNot = inputValidator.getInt(3);
        if(attackOrNot == 1){
            dectedBonusAttack = new DetectedBonusAttack(heroList,monstersList,heroIndex,board);
            heroWin = DetectedBonusAttack.getHeroWin();
            monsterWin = DetectedBonusAttack.getMonsterWin();
            afterBattle();
        }
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

    public boolean checkAttackOrNot(){
        boolean canAttackOrNot;
        if (board.getStatus()[heroCol][heroRow].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.min(7,heroCol+1)][heroRow].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.max(0,heroCol-1)][heroRow].getCurrentInfo().contains("M") ||
                board.getStatus()[heroCol][Math.min(7,heroRow+1)].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.max(0, heroCol-1)][Math.min(7, heroRow+1)].getCurrentInfo().contains("M") ||
                board.getStatus()[Math.min(7, heroCol+1)][Math.min(7, heroRow+1)].getCurrentInfo().contains("M")){
            canAttackOrNot = true;
            board.display();
        }
        else {
            canAttackOrNot = false;
        }
        return canAttackOrNot;
    }

    public void afterBattle(){
        if(monsterWin == true){
            heroList.get(heroIndex).LeaveCurrentLocation(boardDecorator);
            heroList.remove(heroIndex);
            ReBorn reBorn = new ReBorn(heroList,monstersList,heroIndex,board);
            heroList = reBorn.getRealHero();
        }

        if (heroWin == true){
            monstersList.get(heroIndex).LeaveCurrentLocation(boardDecorator);
            monstersList.remove(heroIndex);
            ReBorn reBorn = new ReBorn(heroList,monstersList,heroIndex,board);
            monstersList = reBorn.getRealMonster();
        }
    }

//control hero move up behaviour
    public void moveUp() {
        //Moving up does not need to detect problems that can touch inaccessible areas
        //First check whether the hero's movement is legal
        if (heroRow + 1 > monsterRow|| board.getStatus()[heroCol][heroRow+1].getCurrentInfo().contains("H")) {
            System.out.println("Your hero cannot make that move. ");
            moveable = false;
        }
            //If it is legal, first check if the hero takes a step, can the hero win
        else {
            moveable = true;
            heroRow ++;
            heroList.get(heroIndex).sethHeroRow(heroRow);
            if (heroRow== 7) {
                int heroNum = heroIndex + 1;
                System.out.println("Hero " + heroNum + " Win!");
                gameEndOrNot = true;
                resultList.set(heroIndex,true);
            }
            //Whether the step of detecting heroes will enter the market
            else if (board.getStatus()[heroCol][heroRow] instanceof Nexus) {
                checkInMarketOrnot();
            }
            //Then check whether there will be monsters within the range of the hero taking this step, if so,
            // you can go directly to start attacking
            else if (checkAttackOrNot()) {
                beginAttack();
            }
//            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol;
                oldPosition[1] = heroRow-1;
                boardDecorator.HeroMove(heroIndex,heroList, newPosition , oldPosition);
//            }
        }
    }
//control hero move down behaviour
    public void moveDown(){
        //Moving down does not need to detect whether the movement is legal, because moving down will not make the
        // hero over the monster, it needs to detect whether the movement will exceed the bottom line
        if(heroRow == 0|| board.getStatus()[heroCol][heroRow-1].getCurrentInfo().contains("H")){
            System.out.println("You cannot make this move!");
            moveable = false;

        } //If it is legal, first check whether it will enter the market
        else {
            moveable = true;
            heroRow --;
            heroList.get(heroIndex).sethHeroRow(heroRow);
            if (board.getStatus()[heroCol][heroRow] instanceof Nexus) {
                checkInMarketOrnot();
            }//Detect if there is a monster in the hero's attack range
            else if (checkAttackOrNot()) {
                beginAttack();
            }
            }
            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol;
                oldPosition[1] = heroRow + 1;
                boardDecorator.HeroMove(heroIndex, heroList, newPosition , oldPosition);
            }
        }

//control hero move left behaviour
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
            }   else if (checkAttackOrNot()) {
                beginAttack();
            }

            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol + 1;
                oldPosition[1] = heroRow;
                boardDecorator.HeroMove(heroIndex, heroList, newPosition , oldPosition);
            }
        }
    }
//control hero move right behaviour
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
            }  else if (checkAttackOrNot()) {
                beginAttack();
            }
            if(monsterWin == false){
                int[] newPosition = new int[2];
                newPosition[0] = heroCol;
                newPosition[1] = heroRow;
                int[] oldPosition = new int[2];
                oldPosition[0] = heroCol - 1;
                oldPosition[1] = heroRow;
                boardDecorator.HeroMove(heroIndex,heroList, newPosition , oldPosition);
            }
        }
    }
//this can control monster move. monster will always go down if legal
    public void monsterMove(){
        if (monsterRow > boardDecorator.getHighestRowLane(heroIndex)){
            monsterRow --;
            int[] newPosition = new int[2];
            newPosition[0] = monsterCol;
            newPosition[1] = monsterRow;
            int[] oldPosition = new int[2];
            oldPosition[0] = monsterCol;
            oldPosition[1] = monsterRow + 1;
            boardDecorator.MonsterMove(heroIndex, newPosition, oldPosition );
            monstersList.get(heroIndex).setMonsterRow(monsterRow);

            if (checkAttackOrNot()) {
                beginAttack();
            }
        }
        if(monsterRow - 1 == 0) {
            gameEndOrNot = true;
            resultList.set(heroIndex,false);
            int monsterNum = heroIndex + 1;
            System.out.println("Monster " +monsterNum + " Wins!" );
        }
    }
}
