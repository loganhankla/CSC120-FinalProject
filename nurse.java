import java.util.Scanner;

public class Nurse extends Person {
    
    public int wallet;
    private int successPoints;
    private int campersTreated;
    
   /** Nurse constructor
    * @param name Nurse's name
    */ 
   public Nurse(String name){
        super(name); 
        this.wallet = 200;
        this.successPoints = 0;
        this.campersTreated = 0;
        this.inHealthCenter = true;

    }

    /** Prints the contents of the inventory, with items and number in stock. */
    public void getInventory(){

    }

    /** Views amount in wallet ($) */
    public void seeWallet(){
        System.out.println("Your wallet contains $" + this.wallet + ".");
    }

    /**
     * Buys an item from the supply store one at a time, adds it to the inventory and decreases the appropriate amount from the wallet.
     * @param item Item to buy and put in inventory
     */
    public void buy(String item){
        Scanner in = new Scanner(System.in);
        String userInput = "";
        while(!userInput.equals("")){ //is this what should be in here?
            userInput = in.nextLine();
        
        }

        in.close();

        //scanner input
       // if(healthCenter.supplyStore.contains(item)){
        //    healthCenter.inventory.put(item, 1);
            // if enough in wallet
     //   }
    }


    public void dismiss(){
        //tells camper they're done, sends them out camper.exit()
        //increase camper treated # and update success points

        // ask if nurse is ready for next camper, if so, next() but only until campersTreated = 5 or successPoints = 100 or something
    }

    public void next(Camper c){
        // Random camper name? 
        c.enter();
        System.out.println("A camper, " + c + ", walks in.");
        //initialize & calls next camper in to health center, enter()
    }

    public void intake(Camper c){
        // after next(), if scanner input asks for malady
        // ask camper for primary complaint, response should give random from camper complain()
    }
    
    public void evaluate(){
        // ask camper for more details, to show how impacting, helps to determine severity of malady
    }

    public void treat(){
        // choose how to treat the camper by using items in the inventory, check if in inventory
        // should camper have attribute of how well treated? like if sent home/bandaid/shake it off, appropriate?
        // should adjust nurse's success points
        // adjust camper health points?
    }

    public void seePoints(){
        System.out.println("You currently have " + this.successPoints + " success points.");
    }
    
       
    public static void main(String[] args) {
        Nurse becky = new Nurse("Becky");
        becky.seeWallet();
        becky.enter();
        becky.seePoints();
        Camper c = new Camper("Parker");
        System.out.println(c);
        becky.next(c);
        System.out.println("something main");
    }


}
