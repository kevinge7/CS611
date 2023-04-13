import java.io.*;
import java.util.ArrayList;

//initiate all the hero from file and store them into Arraylist
public class HeroList {
    private static ArrayList<Heros> heroList;
    private String filePath1;
    private String filePath2;
    private String filePath3;


    public HeroList(){
        heroList = new ArrayList<Heros>();
        generateList();
    }

    public ArrayList<Heros> getHeroList(){
        return this.heroList;
    }
    //read from the file
    public void generateList(){
        // read file warrior.txt and store the information into hero list(Arraylist)
        filePath1 = "Warriors.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath1);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int mana = Integer.parseInt(tokens[1]);
                    int strength = Integer.parseInt(tokens[2]);
                    int agility = Integer.parseInt(tokens[3]);
                    int dexterity = Integer.parseInt(tokens[4]);
                    int money = Integer.parseInt(tokens[5]);
                    int experience = Integer.parseInt(tokens[6]);
                    heroList.add(new Warriors(name, mana, strength, agility, dexterity, money, experience));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //read file Sorcerers.txt and store the information into hero list
        filePath2 = "Sorcerers.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath2);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int mana = Integer.parseInt(tokens[1]);
                    int strength = Integer.parseInt(tokens[2]);
                    int agility = Integer.parseInt(tokens[3]);
                    int dexterity = Integer.parseInt(tokens[4]);
                    int money = Integer.parseInt(tokens[5]);
                    int experience = Integer.parseInt(tokens[6]);
                    heroList.add(new Sorcerers(name, mana, strength, agility, dexterity, money, experience));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //read file from Paladins.txt and store information into hero list
        filePath3 = "Paladins.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath3);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int mana = Integer.parseInt(tokens[1]);
                    int strength = Integer.parseInt(tokens[2]);
                    int agility = Integer.parseInt(tokens[3]);
                    int dexterity = Integer.parseInt(tokens[4]);
                    int money = Integer.parseInt(tokens[5]);
                    int experience = Integer.parseInt(tokens[6]);
                    heroList.add(new Paladins(name, mana, strength, agility, dexterity, money, experience));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //print out all the hero from hero list
    public void print(){
        int now = 1;
        for (Heros character : heroList) {
            System.out.println(now);
            if (character instanceof Warriors) {
                Warriors player = (Warriors) character;
                // 打印Player对象的属性值
                System.out.print("Warriors Name: " + player.getName());
                System.out.print(" Warriors Strength: " + player.getStrength());
                System.out.print(" Warriors money: "+player.getMoney());
                System.out.println("Warriors level: "+player.getLevel());
        }
            else if (character instanceof Sorcerers) {
                Sorcerers player = (Sorcerers) character;
                // 打印Player对象的属性值
                System.out.print("Sorcerers Name: " + player.getName());
                System.out.print(" Sorcerers Mana: " + player.getMP());
                System.out.println( "Sorcerers Strength: " + player.getStrength());
            }
            else if (character instanceof Paladins) {
                Paladins player = (Paladins) character;
                // 打印Player对象的属性值
                System.out.print("Paladins Name: " + player.getName());
                System.out.print(" Paladins Mana: " + player.getMP());
                System.out.println("Paladins Strength: " + player.getStrength());
            }
            now++;
        }
    }
}
