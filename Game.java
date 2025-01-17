import java.util.Scanner;
import java.util.Hashtable;

public class Game {

    /** Nurse for the game: what the user plays */
    private Nurse becky;

    /** Health Center used for the game */
    private HealthCenter hCenter;

    /** Current camper */
    private Camper c;

    /** User's input */
    private Scanner userInput;
    
    /** Game constructor */
    public Game(){
        this.becky = new Nurse("Nurse");
        this.hCenter = new HealthCenter();
        this.hCenter.makeNames();
        this.becky.setHC(this.hCenter);
        this.userInput = new Scanner(System.in);
    }

    /** Main play method for game that takes expected command input; stops the game when end conditions are met or user fails. */
    public void play(){
        boolean keepGoing = true;

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
                if(this.becky.inHealthCenter == true){
                    this.becky.next();
                } else{
                    System.out.println("You must ENTER the Health Center to call the NEXT camper.");
                }
            } else if(userInput.equals("INVENTORY")){
                this.hCenter.seeInventory();
            } else if(userInput.equals("DISMISS")){
                this.becky.dismiss();
            } else if(userInput.contains("TREAT")){
                System.out.println("What item would you like to use?");
                Scanner in = new Scanner(System.in);
                String useInput = in.nextLine();
                if(this.hCenter.inventory.containsKey(useInput) && this.hCenter.inventory.get(useInput) > 0){
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
                            System.out.println("Oh no, that was bad. The severity of the camper's malady is high. ");
                        }
                        System.out.println("You treated the camper incorrectly. You've lost points, and now have " + this.becky.successPoints + " Success Points. \nYou can DISMISS the camper, or try to TREAT them again.");
                    }
                } else{
                    this.becky.successPoints -= 5;
                    System.out.println("You don't have the supplies to treat the camper this way. Check your INVENTORY, and try to TREAT them again.");
                }
            } else if(userInput.contains("INTAKE") || userInput.equals("WHAT'S WRONG?")){
                if(this.becky.inHealthCenter == true){
                    this.becky.intake(); // GETS PRIMARY COMPLAINT
                } else{
                    System.out.println("You must be inside the Health Center to INTAKE the camper.");
                }
            } else if(userInput.equals("EXPLAIN") || userInput.equals("TELL ME MORE") || userInput.equals("EVALUATE")){
                if(this.becky.inHealthCenter == true){
                    this.becky.evaluate(); // GETS DETAILED EXPLANATION
                } else{
                    System.out.println("You must be inside the Health Center to EVALUATE the camper.");
                }    
            } else if(userInput.equals("POINTS")){
                this.becky.seePoints();
            } else if(userInput.equals("OPTIONS")){
                System.out.println("\n============COMMAND OPTIONS============ ");
                System.out.println("\n* Q or QUIT: quit the game \n* OPTIONS: prints command options \n* POINTS: show current Success Points"); 
                System.out.println("* SUPPLY STORE: Shows list of items available for purchase and their price ($) \n* WALLET: Shows amount of money you have available to spend \n* INVENTORY: shows items and number in stock at the Health Center \n* BUY: allows you to buy items from the supply store for the inventory");
                System.out.println("* EXIT: Nurse exits the Health Center \n* ENTER: Nurse enters the Health Center");
                System.out.println("* NEXT: brings next camper in \n* INTAKE or WHAT'S WRONG?: hear camper's primary complaint");
                System.out.println("* EVALUATE or EXPLAIN or TELL ME MORE: gets the camper's more in depth explanation of the malady following intake");
                System.out.println("* COMPLAINT: reminds you of the camper's primary complaint after intake");
                System.out.println("* TREAT: allows you to treat the camper using an item from the inventory");
                System.out.println("* DISMISS: dismisses the current camper");
            } else if(userInput.equals("COMPLAINT")){
                if(this.c != null){
                    System.out.println("The camper's primary complaint is: " + this.becky.c.primaryComplaint);
                } else{
                    System.out.println("You're not currently seeing a camper. Call the NEXT one in.");
                }
            } else if(userInput.equals("ENTER")){
                this.becky.enter();
            } else if(userInput.equals("EXIT")){
                this.becky.exit();
                System.out.println("You have exited the Health Center. Re-ENTER in order to treat campers.");
            } else{
                System.out.println("Command not understood. Check OPTIONS.");
            }

            if(this.becky.campersTreated >= 5 || userInput.equals("QUIT") || this.becky.successPoints < 0){ // terminates game play loop once treated enough
                keepGoing = false;
            }
        }

        System.out.println("\n*****Game over!***** \n Thanks for playing! \n********************\n");
    }

    /**
     * Main method where gameplay happens; initializes game, greets user and takes input, starts play() method
     */
    public static void main(String[] args) {
        
        Game game = new Game();
        System.out.println("Welcome to summer camp! You've been hired as the Camp Nurse. Are you ready to begin (yes/no)?");
        String response = game.userInput.nextLine().toUpperCase();

        if(response.equals("YES")){
            System.out.println("\nGreat! You will earn and lose points based on how well you treat your campers' maladies. The game will terminate if you lose too many points or when you successfully treat enough campers. You'll work inside the Health Center, but first you need to make sure you have supplies.");
            System.out.println("You can check OPTIONS at any point to see available commands.");
            System.out.println("\nYou have $200 in the Health Center WALLET. Check the SUPPLY STORE to see what you can BUY for the INVENTORY.");
            game.play();
         }
        game.userInput.close();
    }
}
