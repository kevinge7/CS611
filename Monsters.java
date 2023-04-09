import java.util.ArrayList;
//initiate monster information
public abstract class Monsters {
    private String name;
    private int experiences;
    private int level;
    private int HP;
    private int damage;
    private int defense;
    private int dodge;
    private int monsterRow;
    private int monsterCol;
    private int index;

    public Monsters(String name, int level, int damage, int defense, int dodge){
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodge = dodge;
        monsterRow = 0;
        monsterCol = 0;
        index = 0;
        this.HP = level * 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getMonsterRow() {
        return monsterRow;
    }

    public void setMonsterRow(int monsterRow) {
        this.monsterRow = monsterRow;
    }

    public int getMonsterCol() {
        return monsterCol;
    }

    public void setMonsterCol(int monsterCol) {
        this.monsterCol = monsterCol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void LeaveCurrentLocation(Map map){
        map.MonsterLeave(this.monsterCol, this.monsterRow);

    }
}
