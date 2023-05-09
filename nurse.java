import java.util.Scanner;

public class Nurse extends Person {
    
    /** Amount of dollars in wallet that can be spent. */
    public int wallet;

    /** Amount of Success Points the player currently has */
    public int successPoints;

    /** Number of campers treated by the nurse */
    public int campersTreated;

    /** The current camper the nurse is working with */
    public Camper c;

    /** The Health Center the nurse works in */
    private HealthCenter hc;
    
    
   /** Nurse constructor
    * @param name Nurse's name
    */ 
   public Nurse(String name){
        super(name); 
        this.wallet = 200;
        this.successPoints = 0;
        this.campersTreated = 0;
        this.inHealthCenter = true;
        this.c = new Camper("Test");
    }

    /**
     * Setter method for the nurse's Health Center
     * @param h Name of Health Center
     */
    public void setHC(HealthCenter h){
        this.hc = h;
    }

    /** Getter method to see amount in wallet ($) */
    public void seeWallet(){
        System.out.println("\nYour wallet contains $" + this.wallet + ".");
    }

    /**
     * Buys an item from the supply store one at a time, adds it to the inventory and decreases the appropriate $ amount from the wallet.
     * @param item Item to buy and put in inventory
     */
    public void buy(){
        Scanner in = new Scanner(System.in);
        System.out.println("What item do you want to buy?");
        String userInput = in.nextLine();
        if(!this.hc.supplyStore.containsKey(userInput)){
            System.out.println("The store doesn't contain that item. Be sure to check your capitalization! What do you want to do next?");
        } else if(this.hc.inventory.containsKey(userInput)){
            if(this.wallet >= this.hc.supplyStore.get(userInput)){
                this.hc.inventory.put(userInput, this.hc.inventory.get(userInput) + 1);
                System.out.println(userInput + " has been added to the inventory. BUY another item for the inventory, TREAT the current camper, or call the NEXT camper in.");
                this.wallet -= this.hc.supplyStore.get(userInput); // subtract price of item from wallet
            } else{
                System.out.println("You don't have enough money! Your wallet contains $" + this.wallet + ".");
            }
        } else{
            if(this.wallet >= this.hc.supplyStore.get(userInput)){
                this.hc.inventory.put(userInput, 1);
                this.wallet -= this.hc.supplyStore.get(userInput);
                System.out.println(userInput + " has been added to the inventory. BUY another item for the inventory, TREAT the current camper, or call the NEXT camper in.");
            } else{
                System.out.println("You don't have enough money! Your wallet contains $" + this.wallet + ".");
            }
        }
    }

        /** Dismisses current camper, increases campersTreated */
        public void dismiss(){
            this.campersTreated += 1;
            System.out.println(c.name + " smiles at you and exits the Health Center.");
            this.c.exit();
            this.c = null;
            if(campersTreated < 5){
                System.out.println("You have " + this.successPoints + " Success Points.");
                System.out.println("\nCall the NEXT camper when you're ready.");
            } else{
                System.out.println("You have completed the game with " + this.successPoints + " Success Points.");
                if(this.successPoints >= 110){
                    System.out.println("Congratulations! You won!!");
                } else{
                    System.out.println("You FAILED.");
                }
            }
        }
    
        /** Calls the next camper into the Health Center to be treated; moves down names in Health Center ArrayList */
        public void next(){
            int index = this.campersTreated;
            this.c = this.hc.campers.get(index);
            this.c.enter();
            System.out.println("The camper waits for INTAKE.");
        }
    
        /** Greets the camper after entrance and gets their primary complaint. 5 points. */
        public void intake(){
            System.out.println("\nYou greet the camper and smile. \"What seems to be the problem today?\" you ask.\n");
            this.c.complain();
            System.out.println("\nYou want to know more before treating them, so you must EVALUATE them.");
            this.successPoints += 5;
        }
        
        /** Asks for additional details and explanation of the malady followinng intake. 5 points. */
        public void evaluate(){
            if(this.c.primaryComplaint != null){
                this.c.explain();
                this.successPoints += 5;
            } else{
                System.out.println("You must INTAKE the camper first.");
            }
        }
    
        /** Increases points by 20. Called in Game play() when Nurse successfully treats camper. */
        public void treat(){
            this.successPoints += 20;
        }
    
        /** Getter method to see number of Success Points player currently has. */
        public void seePoints(){
            System.out.println("You currently have " + this.successPoints + " success points.");
        }
        
        /** Main method to test functions */
        public static void main(String[] args) {
            Nurse becky = new Nurse("Becky");
            becky.seeWallet();
            becky.enter();
            becky.seePoints();
            HealthCenter hCenter = new HealthCenter();
            becky.setHC(hCenter); // needed?
            System.out.println(becky.c);
            becky.next();
            System.out.println("something main");
        }
    }