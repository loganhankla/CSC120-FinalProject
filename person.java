
public class person {
    String name;
    boolean inHealthCenter;

    /** Person constructor.
     * @param name Person's name
     */
    public person(String name){
        this.inHealthCenter = false;
    }

    public void enter(){
        if(this.inHealthCenter = false){
            this.inHealthCenter = true;
            System.out.println(this.name + " has entered the Health Center.");
            // could include description of what they see inside
        } else{
            System.out.println("You are already inside the Health Center.");
        }  
    }

public void exit(){
    if(this.inHealthCenter = true){
        this.inHealthCenter = false;
        System.out.println("You have exited the Health Center.");
        // could provide more description here
    } else{
        System.out.println("You are already outside of the Health Center.");
    }
}

}