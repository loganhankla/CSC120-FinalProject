package Locations;

import java.util.Hashtable;


public class healthCenter {
    public Hashtable<String, int> inventory; //int is stock number
    public Hashtable<String, int> supplyStore; // int is price

    public healthCenter(){
        this.inventory = new Hashtable<String, int>();
        this.supplyStore = new supplyStore<String, int>();
        this.supplyStore.put("aloe", 10);
    
    }

    public static void main(String[] args) {
        healthCenter healthCenter = new healthCenter();
        System.out.println(healthCenter.supplyStore);
    }
}
