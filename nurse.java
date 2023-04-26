import java.util.Scanner;

public class nurse extends person {
    
    public int wallet;
    public int successPoints;
    private int campersTreated;
    
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

    public void getTreatOptions(){
        System.out.println("* disinfect" + "\n * bandaid");
    }
       
    public static void main(String[] args) {
        nurse becky = new nurse("Becky");
       // becky.getTreatOptions();
       becky.seeWallet();
       becky.enter();
    }


}
