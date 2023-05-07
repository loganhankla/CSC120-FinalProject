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
        //Scanner in = new Scanner(System.in);
        //String userInput = in.nextLine().toUpperCase();
        // if else for user inputs "USE" "BUY" 

        // while loop of running, have scanner open and if statements

        while(true){
            //Scanner in = new Scanner(System.in);
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
                   // this.hCenter.inventory.get(useInput) -= 1; 
                    this.hCenter.inventory.put(useInput, this.hCenter.inventory.get(useInput) - 1); //decreases stock
                    if(this.becky.c.appropriateTreatment.equals(useInput)){ // THIS NOT WORKING
                        this.becky.treat(); // increases success points 20
                        System.out.println("Great job! You successfully treated the camper. You have " + this.becky.successPoints + " Success Points. You can now DISMISS them.");
                    } else{
                        this.becky.successPoints -= 20;
                        System.out.println("You treated the camper incorrectly. You've lost 20 points. You can DISMISS the camper, or try to TREAT them again.");
                    }
                    // decrease stock in inventory by one
                    // if correct treatment, increase successPoints
                } else{
                     System.out.println("You don't have the supplies to treat the camper this way. Check your INVENTORY, and try to TREAT them again.");
                }
               // System.out.println("[PUT CODE HERE]"); // PUT CODE HERE to set success points and see if correct item
            } else if(userInput.contains("INTAKE") || userInput.equals("WHAT'S WRONG?")){
                this.becky.intake(); // GETS PRIMARY COMPLAINT
                // ONLY IF CAMPER IN?
            } else if(userInput.equals("EXPLAIN") || userInput.equals("TELL ME MORE") || userInput.equals("EVALUATE")){
                this.becky.evaluate(); // GETS DETAILED EXPLANATION
            } else if(userInput.equals("POINTS")){
                this.becky.seePoints();
            } else if(userInput.equals("OPTIONS")){
                System.out.println("PRINT OPTIONS HERE \n* NEXT: brings next camper in \n* INTAKE: hear camper's primary complaint"); 
                //DO THIS, MAKE METHOD? NEXT, BUY, ETC.
            } 
            // else if(userInput.equals("COMPLAINT")){
            //     System.out.println(this.c.primaryComplaint);
            // }

            if(this.becky.campersTreated >= 5 || userInput.equals("QUIT")){ // terminates game play loop once treated enough
                break;
            }

           //put in closing game message, if won, etc.
        }
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
