public class nurse extends person {
    
    public int wallet;
    public int successPoints;
    
    public nurse(String name){
        super(name);
        this.wallet = 200;
        this.successPoints = 0;

    }

    public void buy(String item){
        
    }

    public String getTreatOptions();
        System.out.println("* disinfect" + "\n * bandaid");
}
