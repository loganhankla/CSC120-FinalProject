import java.util.Scanner;

public class Nurse extends Person {
    
    public int wallet;
    public int successPoints;
    public int campersTreated;
    public Camper c;
    private HealthCenter hc;
    //private Game g;
    
   /** Nurse constructor
    * @param name Nurse's name
    */ 
   public Nurse(String name){
        super(name); 
        this.wallet = 200;
        this.successPoints = 0;
        this.campersTreated = 0;
        this.inHealthCenter = true;
       // this.c = new Camper(this.hc.campers.get(this.campersTreated + 1));
       // this.hc.campers.get(this.campersTreated + 1)
       // this.g.campers.get(campersTreated + 1);
        //this.hc = setHC(hc);

        this.c = new Camper("Test");

    }

    public void setHC(HealthCenter h){
        this.hc = h;
    }

    /** Views amount in wallet ($) */
    public void seeWallet(){
        System.out.println("\nYour wallet contains $" + this.wallet + ".");
    }

    /**
     * Buys an item from the supply store one at a time, adds it to the inventory and decreases the appropriate amount from the wallet.
     * @param item Item to buy and put in inventory
     */
    public void buy(){
        
        Scanner in = new Scanner(System.in);
        System.out.println("What item do you want to buy?");
        // print what do u wanna buy
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

        public void dismiss(){
            //tells camper they're done, sends them out camper.exit()
            //update success points
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
    
        public void next(){
            int index = this.campersTreated;
            this.c = this.hc.campers.get(index);
            this.c.enter();
            System.out.println("The camper waits for INTAKE.");
            //initialize & calls next camper in to health center
        }
    
        public void intake(){
            System.out.println("\nYou greet the camper and smile. \"What seems to be the problem today?\" you ask.\n");
            this.c.complain();
            System.out.println("\nYou want to know more before treating them, so you must EVALUATE them.");
            this.successPoints += 5;
        }
        
        public void evaluate(){
            if(this.c.primaryComplaint != null){
                this.c.explain();
                this.successPoints += 5;
            } else{
                System.out.println("You must INTAKE the camper first.");
            }
        }
    
        public void treat(){
            //"ankle", "stomach", "arm", "rash", "head"
           // if(c.primaryComplaint.equals("rash")){
            this.successPoints += 20;
           // }
            // if(userInput.contains(this.hc.inventory.containsKey())){
            //     this.hc.inventory.get(userInput) -= 1; 
            //     // decrease stock in inventory by one
            // //     // if correct treatment, increase successPoints
            // } else{
            //      System.out.println("You don't have the supplies to treat the camper this way.");
            // }
            
            // choose how to treat the camper by using items in the inventory, check if in inventory
            // should camper have attribute of how well treated? like if sent home/bandaid/shake it off, appropriate?
            // should adjust nurse's success points

            //treat options method? USE item, SEND HOME
        }
    
        public void seePoints(){
            System.out.println("You currently have " + this.successPoints + " success points.");
        }
        
           
        public static void main(String[] args) {
            Nurse becky = new Nurse("Becky");
            becky.seeWallet();
            becky.enter();
            becky.seePoints();
            HealthCenter hCenter = new HealthCenter(); // needed?
            becky.setHC(hCenter); // needed?
            System.out.println(becky.c);
            becky.next();
            System.out.println("something main");
        }


    }
