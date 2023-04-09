import java.io.*;
import java.util.ArrayList;

//initiate spell information
public class SpellList {
    ArrayList<item> spellList;
    private static String filePath;

    public SpellList(){
        spellList = new ArrayList<item>();
        String filePath1 = "FireSpells.txt";
        generateList(filePath1);
        String filepath3 = "LightningSpells.txt";
        String filePath2 = "IceSpells.txt";
        generateList(filePath2);
        generateList(filepath3);

    }
    public ArrayList<item> getSpellList(){
        return this.spellList;
    }
    public void generateList(String filePath) {
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
                    int mana_cost = Integer.parseInt(tokens[4]);
                    spellList.add(new Spells(name, cost, level, damage, mana_cost));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void print(){
        int i = 1;
        for (item a : spellList) {
            Spells armory = (Spells) a;
            System.out.println(i);
            System.out.print("Name: " + armory.getName() + "\nCost: " + armory.getCost() + "\nRequired Level: " +
                    armory.getRequiredLevel() + "\nDamage: " + armory.getDamage() +
                    "\nMana cost: "+armory.getMana_cost());
            i++;
            System.out.println("\n");
        }
    }
}
