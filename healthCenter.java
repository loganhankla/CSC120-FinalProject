import java.util.Hashtable;

//import javax.swing.RowFilter.Entry;


public class HealthCenter {
    public Hashtable<String, Integer> inventory; //int is stock number
    public Hashtable<String, Integer> supplyStore; // int is price
    public boolean running;

    public HealthCenter(){
        this.running = true;
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
        this.supplyStore.put("single-use thermometer", 10);
        this.supplyStore.put("alcohol wipe", 5);
    
    }

public void seeInventory(){
    System.out.println("Your inventory contains (item (number in stock)): \n");
    this.inventory.entrySet().forEach( entry -> {
        System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
    });
}

public void seeSupplyStore(){
    System.out.println("The Medical Supply Store has unlimited supply of the following items: \n ");
    this.supplyStore.entrySet().forEach( entry -> {
        System.out.println(entry.getKey() + ": $" + entry.getValue() + " each use");
    });

    System.out.println("\nWhat do you wish to buy? Please tell us one item at a time.");
}

    public static void main(String[] args) {
        HealthCenter healthCenter = new HealthCenter();
        healthCenter.seeSupplyStore();
    }
}
