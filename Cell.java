
//this is cell class which define each cell in the board.
public abstract class Cell {

    /*Whether Hero is occupied*/
    private boolean isHeroOccupied;

    private boolean isMonsterOccupied;

    private String type;

    private char letter;

    private String currentInfo;

    private String heroInfo = "  ";
    private String monsterInfo = "  ";


    public Cell(){

    }



    public void printCell() {
        System.out.println(" " + letter + " - " + letter + " - " + letter + " ");
        System.out.println("| " + currentInfo + " |");
        System.out.println(" " + letter + " - " + letter + " - " + letter + " ");
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getCurrentInfo() {
        return currentInfo;
    }

    public void setCurrentInfo(String currentInfo) {
       this.currentInfo = currentInfo;
    }



    public void HeroLeave(){
        isHeroOccupied = false;
        heroInfo = "  ";
        this.currentInfo = heroInfo + " " + monsterInfo;
    }


    public boolean isHeroOccupied() {
        return currentInfo.contains("H");
    }

    public boolean isMonsterOccupied() {
        return isMonsterOccupied;
    }
}






