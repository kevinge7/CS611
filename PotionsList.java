import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//define all the potion from files
public class PotionsList {
    private String filePath;
    private ArrayList<item> potionsList;

    public PotionsList(){
        potionsList = new ArrayList<item>();
        generateList();

    }
    //read potion txt file and store information to Arraylist
    public ArrayList<item> getPotionsList(){
        return this.potionsList;
    }
    public void generateList(){
        filePath = "Potions.txt";

        InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Scanner scanner = new Scanner(inputStreamReader);
        scanner.nextLine(); // skip first line
        while (scanner.hasNextLine()) {
            String[] data;
            data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int cost = Integer.parseInt(data[1]);
            int requiredLevel = Integer.parseInt(data[2]);
            int attributeIncrease = Integer.parseInt(data[3]);
            ArrayList<String> attributeAffected = new ArrayList<String>(Arrays.asList(data[4].split("/")));

            Potions potion = new Potions(name, cost, requiredLevel, attributeIncrease, attributeAffected);
            potionsList.add(potion);
        }

        scanner.close();
    }
    //print all the potion information
    public void print(){
        int i = 1;
        for (item potion : potionsList) {
            System.out.println(i);
            Potions p = (Potions) potion;
            System.out.print("Name: " + p.getName() + "\nCost: " + p.getCost() + "\nRequired Level: " +
                    p.getRequiredLevel() + "\nAttribute Increase: " + p.getAttributeIncrease() +
                    "\nAttribute Affected: ");
            for (String attribute : p.getAttributeAffect()) {
                System.out.print(attribute + " ");
            }
            System.out.println("\n");
            i++;
        }
    }
}
