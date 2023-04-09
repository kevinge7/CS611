import java.io.*;
import java.util.ArrayList;

//generate an Arraylist to store all the warrior information
public class WeaponList {
    private static ArrayList<item> weaponList;
    private String filePath;

    public WeaponList(){
        weaponList = new ArrayList<item>();
        generateList();
    }

    public ArrayList<item> getWeaponList(){
        return weaponList;
    }
    //read Weaponry.txt and store all the information to weapon list.
    public void generateList(){
        filePath = "Weaponry.txt";
        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int cost = Integer.parseInt(tokens[1]);
                    int level = Integer.parseInt(tokens[2]);
                    int damage = Integer.parseInt(tokens[3]);
                    int hands = Integer.parseInt(tokens[4]);
                    weaponList.add(new Weaponry(name, cost, level, damage, hands));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //print all the weapon information inside weapon list
    public void print(){
        int i = 1;
        for (item a : weaponList) {
            Weaponry armory = (Weaponry) a;
            System.out.println(i);
            System.out.print("Name: " + armory.getName() + "\nCost: " + armory.getCost() + "\nRequired Level: " +
                    armory.getRequiredLevel() + "\nDamage: " + armory.getDamage()+"\nHand: "+armory.getHands());
            i++;
            System.out.println("\n");
        }
    }
}
