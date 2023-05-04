import java.util.Random;

public class Camper extends Person {

    public int severity;
    public String primaryComplaint;
    //public String explanation;

    
    public Camper(String name){
        super(name);
        this.severity = 0; // make Random?
        this.inHealthCenter = false;
    }

    public String toString(){
        return this.name;
    }

    

    //give camper name?

    public void complain(){
        String[] possibleComplaints = {"ankle", "stomach", "arm", "rash", "head"};
        Random complaint = new Random();
        int index = complaint.nextInt(possibleComplaints.length);
        this.primaryComplaint = possibleComplaints[index];
        System.out.println("My " + possibleComplaints[index] + " is bothering me.");
        // set this.camper's primaryComplaint, generated randomly from a list of complaints

        //add more and maybe more detail? 
    }
   
    /** Prints the camper's more in-depth explanation of their primary complaint depending on the level of severity. */
    public void getArmExplanation(){
        if(this.severity == 1){
            System.out.println("\"My arm hurts right here. I fell when we were hiking up to the pond.\" The camper points to their forearm just below the elbow, where you notice a small scratch and some blood.");
        } else{
            if(this.severity == 2){
                System.out.println("\"I'm bleeding a lot right here, and it's really stinging. We were making a cookout dinner at our camp site, and I cut myself with the knife when I was cutting the chicken.\" \nYou take a closer look and notice lots of blood. There is a two-inch long cut down the length of the arm. It is a fairly deep cut but not dangerously so if treated appropriately.");
            } else{
                System.out.println("\"We were doing the low ropes course as a group, and I was the one doing the trust fall. I was falling, but I don't know what happened, and they didn't catch me.\" \nYou notice the camper is holding their arm close to their chest. \n\"I tried to break my fall, and I heard a popping sound. It hurts so bad. Right here.\" \nThe camper lets out a cry and points at a specific spot on their forearm. You gingerly take their arm in your grasp and notice a bump. Something looks out of place.");
            }
        }

    }
    
    /** Randomly determines the level of severity for the primary complaint and decreases health points accordingly.
     * @return severity int 1-3
     */
    public int getSeverity(){
        //randomly generates severity level from 1-3
        Random rand = new Random();
        this.severity = rand.nextInt((3 - 1) + 1) + 1;
        System.out.println("Severity: " + this.severity);
        
        return this.severity;
    }
    
    public void explain(){
        // should set this.camper's explanation, using getSeverity(), gives different explanations of primaryComplaint
        // if primaryComplaint is ankle, severity 3 is a break, severity 2 is a sprain, severity 1 is a walk it off/bruise/scrape
        this.getSeverity();
        if(this.primaryComplaint == "arm"){
            getArmExplanation();
        } else{ // could do else if()
            if(this.primaryComplaint == "stomach"){
                getStomachExplanation();
            } else{
                if(this.primaryComplaint == "ankle"){
                    getAnkleExplanation();
                } else{
                    if(this.primaryComplaint == "rash"){
                        getRashExplanation();
                    } else{
                        if(this.primaryComplaint == "head"){
                            getHeadExplanation();
                        } else{
                            throw new RuntimeException("This primary complaint doesn't exist.");
                        }
                    }
                }
            }
        }

        System.out.println("\n Nurse, how would you like to treat the camper?");
        //put Scanner in?
    }

    public void getHeadExplanation(){
        if(this.severity == 1){
            System.out.println("\"[EXPLANATION]");
        } else{
            if(this.severity == 2){
                System.out.println("\" [EXPLANATION]");
            } else{
                System.out.println("[EXPLANATION]");
            }
        }
    }

    public void getRashExplanation(){
        if(this.severity == 1){
            System.out.println("\"[EXPLANATION]");
        } else{
            if(this.severity == 2){
                System.out.println("\" [EXPLANATION]");
            } else{
                System.out.println("[EXPLANATION]");
            }
        }
    }
    
    public void getAnkleExplanation(){
        if(this.severity == 1){
            System.out.println("\"[EXPLANATION]");
        } else{
            if(this.severity == 2){
                System.out.println("[EXPLANATION]");
            } else{
                System.out.println("[EXPLANATION]");
            }
        }
    }

    public void getStomachExplanation(){
        if(this.severity == 1){
            System.out.println("\"[EXPLANATION]");
        } else{
            if(this.severity == 2){
                System.out.println("\" [EXPLANATION]");
            } else{
                System.out.println("[EXPLANATION]");
            }
        }
    }

    public static void main(String[] args) {
        Camper matilda = new Camper("Matilda");
        matilda.enter();
        matilda.getSeverity();
        matilda.complain();
        matilda.primaryComplaint = "arm";
        matilda.getArmExplanation();
    }
}

