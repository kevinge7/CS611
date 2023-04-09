

public abstract class Cell {

    /*是否有英雄占领*/
    private boolean isHeroOccupied;

    private boolean isMonsterOccupied;

    private String type;

    private char letter;

    private String currentInfo;

    private String heroInfo = "  ";
    private String monsterInfo = "  ";


    /*是不是有英雄占据*/
    /*Probability of encoutering a monster*/

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
        return isHeroOccupied;
    }

    public boolean isMonsterOccupied() {
        return isMonsterOccupied;
    }
}






