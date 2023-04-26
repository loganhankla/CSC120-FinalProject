import java.util.Random;


public class camper extends person {

    private int severity;
    private int HP; //Health Points


    public camper(String name){
        super(name);
        this.severity = 0; // make Random?
        this.HP = 100; // make Random?
    }

    public void complain(){
        String[] initialComplaint = {"My ankle hurts."};
        Random complaint = new Random();
        int index = complaint.nextInt(initialComplaint.length);
        System.out.println(initialComplaint[index]);  //maybe make a way to remove that complaint so they don't get repeats?

    }
    
}
