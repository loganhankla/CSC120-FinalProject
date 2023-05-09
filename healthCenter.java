import java.util.Hashtable;
import java.util.ArrayList;

public class HealthCenter {
    
    /** Hashtable with item and number in stock at the Health Center */
    public Hashtable<String, Integer> inventory; 
    
    /** Hashtable with item and price at the Supply Store */
    public Hashtable<String, Integer> supplyStore; 
    
    /** List of camper names */
    public ArrayList<Camper> campers;

    /** Health Center constructor, adds items to supply store */
    public HealthCenter(){
        this.inventory = new Hashtable<String, Integer>();
        this.supplyStore = new Hashtable<String, Integer>();
        this.supplyStore.put("aloe", 10);
        this.supplyStore.put("ibuprofen", 5);
        this.supplyStore.put("Epipen", 40);
        this.supplyStore.put("benadryl", 10);
        this.supplyStore.put("bandaid", 5);
        this.supplyStore.put("gauze", 10);
        this.supplyStore.put("ACE bandage", 30);
        this.supplyStore.put("splint", 40);
        this.supplyStore.put("TUMS Antacid", 20);
        this.supplyStore.put("ambulance ride", 50);
    }

    /** adds names to list of camper names */
    public void makeNames(){
        this.campers = new ArrayList<Camper>();
        this.campers.add(new Camper("Olga")); 
        this.campers.add(new Camper("Samantha")); 
        this.campers.add(new Camper("Madeleine")); 
        this.campers.add(new Camper ("Iliana")); 
        this.campers.add(new Camper ("Qiaochu")); 
        this.campers.add(new Camper ("Michelle")); 
    }

    /** Getter method that prints inventory contents nicely. */
    public void seeInventory(){
        System.out.println("==============Health Center Inventory============== \n             (item (number in stock)): \n");
        this.inventory.entrySet().forEach( entry -> {
            System.out.println("- " + entry.getKey() + " (" + entry.getValue() + ")");
        });
    }

    /** Getter method that prints Supply Store contents nicely. */
    public void seeSupplyStore(){
        System.out.println("\n==============Supply Store============== \n The store has unlimited supply of the following items: \n ");
        this.supplyStore.entrySet().forEach( entry -> {
            System.out.println(entry.getKey() + ": $" + entry.getValue() + " each use");
        });
        System.out.println("\nType BUY if you would like to buy something.");
    }

    /**
     * Main method to test functions
     */
    public static void main(String[] args) {
        HealthCenter healthCenter = new HealthCenter();
        healthCenter.seeSupplyStore();
    }
}