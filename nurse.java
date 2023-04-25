import Locations.healthCenter;

public class nurse extends person {
    
    public int wallet;
    public int successPoints;
    
    public nurse(String name){
        super(name);
        this.wallet = 200;
        this.successPoints = 0;

    }

    public void buy(String item){
        //scanner input
        if(healthCenter.supplyStore.contains(item)){
            healthCenter.inventory.put(item, 1);
            // if enough in wallet
        }
    }

    public String getTreatOptions();
        System.out.println("* disinfect" + "\n * bandaid");
}
