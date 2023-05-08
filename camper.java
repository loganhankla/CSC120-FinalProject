import java.util.Random;

public class Camper extends Person {

    public int severity;
    public String primaryComplaint;
    public String appropriateTreatment;
    //public String explanation;

    
    public Camper(String name){ 
        super(name);
        this.severity = 0; // make Random?
        this.inHealthCenter = false;
    }

    // public String toString(){
    //     return this.name;
    // }


    //give camper name?

    public void complain(){
        String[] possibleComplaints = {"ankle", "stomach", "arm", "rash", "head"};
        Random complaint = new Random();
        int index = complaint.nextInt(possibleComplaints.length);
        this.primaryComplaint = possibleComplaints[index];
        System.out.println("\"My " + possibleComplaints[index] + " is bothering me,\" the camper says.");
        // set this.camper's primaryComplaint, generated randomly from a list of complaints
    }
   
    /** Prints the camper's more in-depth explanation of their primary complaint depending on the level of severity. */
    public void getArmExplanation(){
        if(this.severity == 1){
            this.appropriateTreatment = "bandaid";
            System.out.println("\"My arm hurts right here. I fell when we were hiking up to the pond.\" The camper points to their forearm just below the elbow, where you notice a small scratch and some blood.");
        } else{
            if(this.severity == 2){
                this.appropriateTreatment = "gauze";
                System.out.println("\n\"I'm bleeding a lot right here, and it's really stinging. We were making a cookout dinner at our camp site, and I cut myself with the knife when I was cutting the chicken.\" \nYou take a closer look and notice lots of blood. There is a two-inch long cut down the length of the arm. It is a fairly deep cut but not dangerously so if treated appropriately.");
            } else{
                this.appropriateTreatment = "splint";
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
       // System.out.println("\nSeverity: " + this.severity);
        
        return this.severity;
    }
    
    public void explain(){
        // should set this.camper's explanation, using getSeverity(), gives different explanations of primaryComplaint
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

        System.out.println("\nNurse, would you like to TREAT the camper?");
    }

    public void getHeadExplanation(){
        if(this.severity == 1){
            this.appropriateTreatment = "ibuprofen";
            System.out.println("\"I have a headache, and I haven't had much water today.\" \n You look at the camper's profile and notice that their hometown is at a lower elevation than the camp.");
        } else{
            if(this.severity == 2){
                this.appropriateTreatment = "gauze";
                System.out.println("\"We were playing dodgeball at the sports field, and I ran into somebody else.\"");
                System.out.println("\nYou notice a cut on " + this.name + "'s forehead. There's a significant cut and the wound is continuously bleeding.");
                System.out.println("\nYou check for symptoms of a concussion, but the camper looks clear. You know that heads bleed a lot, so without a concussion, the injury should be treatable at camp.");
            } else{
                this.appropriateTreatment = "ambulance ride";
                System.out.println("\nThe camper stumbles into a seat. Slowly, she says, \"I hit my head,\" but her speech is slurred.");
                System.out.println(this.name + " holds her stomach and leans forward. She looks quit nauseated. You suspect a severe concussion and decide you are not equipped to treat her adequately as the Camp Nurse.");
            }
        }
    }

    public void getRashExplanation(){
        if(this.severity == 1){
            this.appropriateTreatment = "aloe";
            System.out.println("\"My skin is really red, and it hurts to touch.\"");
            System.out.println("\nYou notice the camper's skin is red all over. You ask, \"Did you wear sunscreen today?\"");
            System.out.println("The camper timidly shakes their head. You don't see any blistering on their skin, so you identify the camper's malady as a low-grade sunburn.");
        } else{
            if(this.severity == 2){
                this.appropriateTreatment = "benadryl";
                System.out.println("\"My arm is really itchy.\" You see redness and some little bumps that look like hives.");
                System.out.println("\"" + this.name + ", did you touch any plants or animals?\" She nods her head, \"I touched a plant while we were hiking, and it started itching right after that.\" You nod and suspect an allergic reaction. Nothing you can't handle!");
            } else{
                this.appropriateTreatment = "Epipen";
                System.out.println("The camper is wheezing and indicates that her throat is closing up. You make out one word from what " + this.name + " tries to say: allergic. \nYou notice the skin around her mouth and eyes is puffing up.");
                System.out.println("\nYou quickly flip to her camper profile and see a list of severe allergies and a history of anaphylaxis. You know that you will call an ambulance, but what do you do to treat her in the meantime?");
            }
        }
    }
    
    public void getAnkleExplanation(){
        if(this.severity == 1){
            this.appropriateTreatment = "bandaid";
            System.out.println("\"We were playing Camouflage in the meadow, and I tripped when I was running to my new hiding spot.\"");
            System.out.println("\nYou ask " + this.name + " to remove their shoe and show you their ankle. You see a little scratch.");
        } else{
            if(this.severity == 2){
                this.appropriateTreatment = "ACE bandage";
                System.out.println("\"I was getting out of the canoe up at the pond, and it got so wiggly. I was off-balance and just twisted my foot in a rock in the water.\"");
                System.out.println("\"Ouch!\" you say. " + this.name + " shakes their head when you ask if they heard a pop. You have them stand up and walk a little.");
                System.out.println("\n\"It hurts to put too much weight on it, but I can generally move it around.\" They give you a 6/10 on their pain scale.");
            } else{
                this.appropriateTreatment = "splint";
                System.out.println("[EXPLANATION]");
            }
        }
    }

    public void getStomachExplanation(){
        if(this.severity == 1){
            this.appropriateTreatment = "bandaid";
            System.out.println("\"[EXPLANATION]");
        } else{
            if(this.severity == 2){
                this.appropriateTreatment = "TUMS Antacid";
                System.out.println("\" [EXPLANATION]");
            } else{
                this.appropriateTreatment = "ambulance ride";
                System.out.println("[EXPLANATION]: appendix burst");
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

