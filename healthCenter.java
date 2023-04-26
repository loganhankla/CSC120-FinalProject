import java.util.Hashtable;

//import javax.swing.RowFilter.Entry;


public class healthCenter {
    public Hashtable<String, Integer> inventory; //int is stock number
    public Hashtable<String, Integer> supplyStore; // int is price

    public healthCenter(){
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

public void seeSupplyStore(){
    System.out.println("The Medical Supply Store has unlimited supply of the following items: \n ");
    this.supplyStore.entrySet().forEach( entry -> {
        System.out.println(entry.getKey() + ": $" + entry.getValue() + " each use");
    });

    System.out.println("\nWhat do you wish to buy? Please tell us one item at a time.");
}

    public static void main(String[] args) {
        healthCenter healthCenter = new healthCenter();
        healthCenter.seeSupplyStore();
    }
}
