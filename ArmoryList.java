import java.io.*;
import java.util.ArrayList;


public class ArmoryList {
    private ArrayList<Armory> armoryList;
    private String filepath;

    public ArmoryList(){
        armoryList = new ArrayList<Armory>();
        generateList();
    }

    public ArrayList<Armory> getArmoryList(){
        return this.armoryList;
    }

    //read through the file and generate the Arraylist from the file and store in arraylist
    public void generateList(){
        filepath = "Armory.txt";

        try (InputStream inputStream = ArmoryList.class.getClassLoader().getResourceAsStream(filepath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("Name")) {
                    String[] tokens = line.split("\\s+");
                    String name = tokens[0];
                    int cost = Integer.parseInt(tokens[1]);
                    int level = Integer.parseInt(tokens[2]);
                    int damage_reduce = Integer.parseInt(tokens[3]);

                    armoryList.add(new Armory(name, cost, level, damage_reduce));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //print out the list of armory
    public void print(){
        for (Armory armory : armoryList) {
            System.out.print("Name: " + armory.getName() + "\nCost: " + armory.getCost() + "\nRequired Level: " +
                    armory.getRequiredLevel() + "\ndamage_reduce: " + armory.getDamage_reduce());

            System.out.println("\n");
        }
    }
}
