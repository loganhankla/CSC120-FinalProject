//import People.director;
import java.util.Scanner;
import java.util.Hashtable;

public class Game {

    private Nurse becky;
    private HealthCenter hCenter;
    private Camper c;
    private Scanner userInput;
    
    public Game(){
        this.becky = new Nurse("Becky");
        this.hCenter = new HealthCenter();
        this.hCenter.makeNames();
        this.becky.setHC(this.hCenter);
        this.userInput = new Scanner(System.in);

    }


    public void play(){
        boolean keepGoing = true;
        // while loop of running, have scanner open and if statements

        while(keepGoing){
            String userInput = this.userInput.nextLine().toUpperCase();
            if(userInput.equals("SUPPLY STORE")){
                this.hCenter.seeSupplyStore();
            } else if(userInput.contains("BUY")){
                this.becky.buy();
            } else if(userInput.equals("QUIT") || userInput.equals("Q")){
                break;
            } else if(userInput.equals("WALLET")){
                this.becky.seeWallet();
            } else if(userInput.equals("NEXT")){
                this.becky.next(); 
            } else if(userInput.equals("INVENTORY")){
                this.hCenter.seeInventory();
            } else if(userInput.equals("DISMISS")){
                this.becky.dismiss();
            } else if(userInput.contains("TREAT")){
                System.out.println("What item would you like to use?");
                Scanner in = new Scanner(System.in);
                String useInput = in.nextLine();
                if(this.hCenter.inventory.containsKey(useInput)){
                    this.hCenter.inventory.put(useInput, this.hCenter.inventory.get(useInput) - 1); //decreases stock
                    if(this.becky.c.appropriateTreatment.equals(useInput)){
                        this.becky.treat(); // increases success points 20
                        System.out.println("Great job! You successfully treated the camper. You have " + this.becky.successPoints + " Success Points. You can now DISMISS them.");
                    } else{
                        if(this.becky.c.severity == 1){
                            this.becky.successPoints -= 10;
                        } else if(this.becky.c.severity == 2){
                            this.becky.successPoints -= 25;
                        } else if(this.becky.c.severity == 3){
                            this.becky.successPoints -= 40;
                        }
                        System.out.println("You treated the camper incorrectly. You've lost points, and now have " + this.becky.successPoints + " Success Points. \nYou can DISMISS the camper, or try to TREAT them again.");
                    }
                } else{
                    this.becky.successPoints -= 5;
                    System.out.println("You don't have the supplies to treat the camper this way. Check your INVENTORY, and try to TREAT them again.");
                }
            } else if(userInput.contains("INTAKE") || userInput.equals("WHAT'S WRONG?")){
                this.becky.intake(); // GETS PRIMARY COMPLAINT
            } else if(userInput.equals("EXPLAIN") || userInput.equals("TELL ME MORE") || userInput.equals("EVALUATE")){
                this.becky.evaluate(); // GETS DETAILED EXPLANATION
            } else if(userInput.equals("POINTS")){
                this.becky.seePoints();
            } else if(userInput.equals("OPTIONS")){
                System.out.println("\n============COMMAND OPTIONS============ ");
                System.out.println("\n* Q or QUIT: quit the game \n* OPTIONS: prints command options \n* POINTS: show current Success Points"); 
                System.out.println("* SUPPLY STORE: Shows list of items available for purchase and their price ($) \n* WALLET: Shows amount of money you have available to spend \n* INVENTORY: shows items and number in stock at the Health Center \n* BUY: allows you to buy items from the supply store for the inventory");
                System.out.println("* NEXT: brings next camper in \n* INTAKE or WHAT'S WRONG?: hear camper's primary complaint");
                System.out.println("* EVALUATE or EXPLAIN or TELL ME MORE: gets the camper's more in depth explanation of the malady following intake");
                System.out.println("* COMPLAINT: reminds you of the camper's primary complaint after intake");
                System.out.println("* TREAT: allows you to treat the camper using an item from the inventory");
                System.out.println("* DISMISS: dismisses the current camper");
                //DO THIS, MAKE METHOD? NEXT, BUY, ETC.
            } else if(userInput.equals("COMPLAINT")){
                System.out.println("The camper's primary complaint is: " + this.becky.c.primaryComplaint);
            }
             

            if(this.becky.campersTreated >= 5 || userInput.equals("QUIT") || this.becky.successPoints < 0){ // terminates game play loop once treated enough
                keepGoing = false;
            }
        }

        System.out.println("\n*****Game over!***** \n Thanks for playing! \n********************\n");
    }

    public static void main(String[] args) {
        
        Game game = new Game();

        // gets the game started
        System.out.println("Welcome to summer camp! You've been hired as the Camp Nurse. Are you ready to begin (yes/no)?");
        
        String response = game.userInput.nextLine().toUpperCase();

        if(response.equals("YES")){
            System.out.println("Great! You'll work inside the Health Center, but first you need to make sure you have supplies.");
            System.out.println("You have $200 in the Health Center WALLET. Check the SUPPLY STORE to see what you can BUY for the INVENTORY.");
            game.play();
         }
        
        
        game.userInput.close();
        
    }
}
