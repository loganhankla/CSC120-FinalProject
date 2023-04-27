import java.util.Scanner;

public class nurse extends person {
    
    public int wallet;
    private int successPoints;
   // private int campersTreated;
    
    public nurse(String name){
        super(name);
        this.wallet = 200;
        this.successPoints = 0;
        this.campersTreated = 0;

    }

    public void getInventory(){

    }

    public void seeWallet(){
        System.out.println("Your wallet contains $" + this.wallet + ".");
    }

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
    }

    public void next(){
        //initialize & calls next camper in to health center, enter()
    }

    public void intake(){
        // after next(), if scanner input asks for malady
        // ask camper for primary complaint, response should give random from camper complain()
    }
    
    public void evaluate(){
        // ask camper for more details, to show how impacting, helps to determine severity of malady
    }

    public void treat(){
        // choose how to treat the camper by using items in the inventory
        // should camper have attribute of how well treated? like if sent home/bandaid/shake it off, appropriate?
        // should adjust nurse's success points
        // adjust camper health points?
    }

    public void seePoints(){
        System.out.println("You currently have " + this.successPoints + " success points.");
    }
    
       
    public static void main(String[] args) {
        nurse becky = new nurse("Becky");
       becky.seeWallet();
       becky.enter();
       becky.seePoints();
    }


}
