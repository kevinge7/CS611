import java.io.*;
import java.util.ArrayList;


public class MonsterList {
    private static ArrayList<Monsters> monsterList;
    private String filePath1;
    private String filePath2;
    private String filePath3;


    public MonsterList(){
        monsterList = new ArrayList<Monsters>();
        generateList();
    }
    public ArrayList<Monsters> getMonsterList(){
        return this.monsterList;
    }
    //generate monster list from monsters file
    public void generateList(){
        //read dragon.txt and store all the information to Arraylist
        filePath1 = "Dragons.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath1);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int level = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    int defense = Integer.parseInt(tokens[3]);
                    int dodge = Integer.parseInt(tokens[4]);
                    monsterList.add(new Dragons(name,level,damage,defense,dodge));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    //read Exoskeletons.txt and store all the information to Arraylist
        filePath2 = "Exoskeletons.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath2);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int level = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    int defense = Integer.parseInt(tokens[3]);
                    int dodge = Integer.parseInt(tokens[4]);
                    monsterList.add(new Exoskeletons(name,level,damage,defense,dodge));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//read spirits.txt and store all the information to Arraylist
        filePath3 = "Spirits.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath3);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int level = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    int defense = Integer.parseInt(tokens[3]);
                    int dodge = Integer.parseInt(tokens[4]);
                    monsterList.add(new Spirits(name,level,damage,defense,dodge));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//print out all the
    public void print(){
        for (Monsters character : monsterList) {
            if (character instanceof Dragons) {
                Dragons player = (Dragons) character;

                System.out.println("Dragon Name: " + player.getName());
                System.out.println("Dragon level: " + player.getLevel());
                System.out.println("Dragon damage: " + player.getDamage());
                System.out.println("Dragon defense: " + player.getDefense());
                System.out.println("Dragon dodge "+player.getDodge());
            }
            if (character instanceof Exoskeletons) {
                Exoskeletons player = (Exoskeletons) character;
                //
                System.out.println("Exoskeleton Name: " + player.getName());
                System.out.println("Exoskeleton level: " + player.getLevel());
                System.out.println("Exoskeleton damage: " + player.getDamage());
                System.out.println("Exoskeleton defense: " + player.getDefense());
                System.out.println("Exoskeleton dodge "+player.getDodge());
            }
            if (character instanceof Spirits) {
                Spirits player = (Spirits) character;
                //
                System.out.println("Spirit Name: " + player.getName());
                System.out.println("Spirit level: " + player.getLevel());
                System.out.println("Spirit damage: " + player.getDamage());
                System.out.println("Spirit defense: " + player.getDefense());
                System.out.println("Spirit dodge "+player.getDodge());
            }
        }

}
}
