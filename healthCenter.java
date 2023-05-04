import java.util.Hashtable;
import java.util.ArrayList;

//import javax.swing.RowFilter.Entry;


public class HealthCenter {
    public Hashtable<String, Integer> inventory; //int is stock number
    public Hashtable<String, Integer> supplyStore; // int is price
    public ArrayList<Camper> campers;

    public HealthCenter(){
        this.inventory = new Hashtable<String, Integer>();
        this.supplyStore = new Hashtable<String, Integer>();
        this.supplyStore.put("aloe", 10);
        this.supplyStore.put("ibuprofen", 5);
        this.supplyStore.put("Epipen", 50);
        this.supplyStore.put("benadryl", 10);
        this.supplyStore.put("bandaid", 5);
        this.supplyStore.put("gauze", 10);
        this.supplyStore.put("ACE bandage", 30);
        this.supplyStore.put("splint", 40);
        this.supplyStore.put("TUMS Antacid", 20);
        this.supplyStore.put("thermometer", 10);
        //this.supplyStore.put("alcohol wipe", 5);
    
    }

    public void makeNames(){
        //make ArrayList of camper names
        this.campers = new ArrayList<Camper>();
        this.campers.add(new Camper("Lucia")); 
        this.campers.add(new Camper("Samantha")); 
        this.campers.add(new Camper("Madeleine")); 
        this.campers.add(new Camper ("Iliana")); 
        this.campers.add(new Camper ("Qiaochu")); 
        //System.out.println(this.camperNames);
       // return this.camperNames;
    }

    public void seeInventory(){
        System.out.println("==============Health Center Inventory============== \n              (item (number in stock)): \n");
        this.inventory.entrySet().forEach( entry -> {
            System.out.println("- " + entry.getKey() + " (" + entry.getValue() + ")");
        });
    }

    public void seeSupplyStore(){
        System.out.println("\n==============Supply Store============== \n The store has unlimited supply of the following items: \n ");
        this.supplyStore.entrySet().forEach( entry -> {
            System.out.println(entry.getKey() + ": $" + entry.getValue() + " each use");
    
            /// ONLY PRINTS SOME ITEMS SOMETIMES??
        });
    
        System.out.println("\nType BUY if you would like to buy something.");
    }

    public static void main(String[] args) {
        HealthCenter healthCenter = new HealthCenter();
        healthCenter.seeSupplyStore();
    }
}
