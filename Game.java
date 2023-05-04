//import People.director;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {

    public ArrayList<Camper> campers;
    private Nurse becky;
    private HealthCenter hCenter;
    private Camper c;
    private Scanner userInput;
    
    public Game(){
        this.makeNames();
        this.becky = new Nurse("Becky");
        this.hCenter = new HealthCenter();
        this.becky.setHC(this.hCenter);
        this.userInput = new Scanner(System.in);

    }

    public void printOptions(){
        //buy, use, dismiss, intake, call next, ask more, check wallet
    }

    public void makeNames(){
        //make ArrayList of camper names
        this.campers = new ArrayList<Camper>();
        this.campers.add(new Camper("Lucia")); 
        this.campers.add(new Camper("Samantha")); 
        this.campers.add(new Camper("Madeleine")); 
        this.campers.add(new Camper ("Iliana")); 
        this.campers.add(new Camper ("Qiaochu")); 
        //System.out.println(this.camperNames);
       // return this.camperNames;
    }

    //public String toString(){
      //  return "Camper Names are: " + campers;
    //}

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
                this.becky.next(c); // take out c as input?
            } else if(userInput.equals("INVENTORY")){
                this.hCenter.seeInventory();
            } else if(userInput.equals("DISMISS")){
                this.becky.dismiss();
            } else if(userInput.contains("USE")){
                System.out.println("[PUT CODE HERE]"); // PUT CODE HERE
                // if .contains() items in inventory, maybe in use method in nurse
            } else if(userInput.contains("INTAKE") || userInput.equals("WHAT'S WRONG?")){
                this.becky.intake(); // GETS PRIMARY COMPLAINT
                // ONLY IF CAMPER IN?
            } else if(userInput.equals("EXPLAIN") || userInput.equals("TELL ME MORE") || userInput.equals("EVALUATE")){
                this.becky.evaluate(); // GETS DETAILED EXPLANATION
            } else if(userInput.equals("POINTS")){
                this.becky.seePoints();
            }
            if(this.becky.campersTreated >= 5 || userInput.equals("QUIT")){ // terminates game play loop once treated enough
                break;
            }

            //put in closing game message, if won, etc.
        }
    }

    public static void main(String[] args) {
        
        Game game = new Game();

        

        // gets the game started
        System.out.println("Welcome to summer camp! You've been hired as the Camp Nurse. Are you ready to begin?");
        
        String response = game.userInput.nextLine().toUpperCase();

        if(response.equals("YES")){
            System.out.println("Great! You'll work inside the Health Center, but first you need to make sure you have supplies.");
            System.out.println("You have $200 in the Health Center WALLET. Check SUPPLY STORE to see what you can BUY for the INVENTORY.");
            game.play();
         } // else{
        //     System.out.println("Welcome to summer camp! You've been hired as the Camp Nurse. Are you ready to begin?");
        //     // while(response.equals("NO")){
        //     //     System.out.println("Welcome to summer camp! You've been hired as the Camp Nurse. Are you ready to begin?");
        //     //     if(!response.equals("NO")){
        //     //         System.out.println("Command not understood.");
        //     //     }
        //     }
        
        
        game.userInput.close();
        
        //Game game = new Game();
       // game.becky.next(game.campers.get(0));

        
    }
}
