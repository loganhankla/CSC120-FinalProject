package Locations;

import java.util.Hashtable;


public class healthCenter {
    public Hashtable<String, Integer> inventory; //int is stock number
    public Hashtable<String, Integer> supplyStore; // int is price

    public healthCenter(){
        this.inventory = new Hashtable<String, Integer>();
        this.supplyStore = new Hashtable<String, Integer>();
        this.supplyStore.put("aloe", 10);
        //System.out.println(this.supplyStore);
    
    }

    public static void main(String[] args) {
        healthCenter healthCenter = new healthCenter();
        System.out.println(healthCenter.supplyStore);
    }
}
