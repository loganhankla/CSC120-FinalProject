import java.util.Scanner;

public class Nurse extends Person {
    
    public int wallet;
    private int successPoints;
    private int campersTreated;
    private Camper c;
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

    }

    public void setHC(HealthCenter h){
        this.hc = h;
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
    public void buy(){
        Scanner in = new Scanner(System.in);
        // print what do u wanna buy
        String userInput = in.nextLine();
        if(!this.hc.supplyStore.containsKey(userInput)){
            System.out.println("The store doesn't contain that item. Be sure to check your capitalization! What do you want to do next?");
        } else if(this.hc.inventory.containsKey(userInput)){
            if(this.wallet >= this.hc.supplyStore.get(userInput)){
                this.hc.inventory.put(userInput, this.hc.inventory.get(userInput) + 1);
            this.wallet -= this.hc.supplyStore.get(userInput); // subtract price of item from wallet
            } else{
                System.out.println("You don't have enough money! Your wallet contains $" + this.wallet + ".");
            }
        } else{
            if(this.wallet >= this.hc.supplyStore.get(userInput)){
                this.hc.inventory.put(userInput, 1);
                this.wallet -= this.hc.supplyStore.get(userInput);
            } else{
                System.out.println("You don't have enough money! Your wallet contains $" + this.wallet + ".");
            }
        }
            in.close();
        }

        public void dismiss(){
            //tells camper they're done, sends them out camper.exit()
            //update success points
            this.campersTreated += 1;
            System.out.println(c.name + " smiles at you and exits the health center.");
            this.c.exit();
            this.c = null;
            if(campersTreated < 5){
                System.out.println("Are you ready for the next camper?");
                System.out.println("You have " + this.successPoints);
            } else{
                System.out.println("You have completed the game.");
                if(this.successPoints >= 80){
                    System.out.println("Congratulations! You won!!");
                } else{
                    System.out.println("You FAILED.");
                }
            }
            // ask if nurse is ready for next camper, if so, next() but only until campersTreated = 5 or successPoints = 100 or something
        }
    
        public void next(Camper c){
            // Random camper name? 
            c.enter();
            this.c = c;
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
            Camper c = new Camper("Parker"); // should come from Random camper, from Game class? makeNames?
            System.out.println(c);
            becky.next(c);
            System.out.println("something main");
        }


    }
