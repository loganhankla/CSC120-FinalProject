
public class Person {
    /** Person's name */
    public String name;

    /** Boolean as to whether a person is inside the Health Center */
    public boolean inHealthCenter;

    /** Person constructor.
     * @param name Person's name
     */
    public Person(String name){
        this.inHealthCenter = false;
        this.name = name;
    }

    /** Enter method allowing a person to enter the Health Center */
    public void enter(){
        if(this.inHealthCenter == false){
            this.inHealthCenter = true;
            System.out.println(this.name + " has entered the Health Center.");
        } else{
            System.out.println(this.name + " is already inside the Health Center. Either TREAT or DISMISS them.");
        }  
    }

    /** Method allowing person to exit the Health Center. */
    public void exit(){
        if(this.inHealthCenter == true){
            this.inHealthCenter = false;
        } else{
            System.out.println("This person is already outside of the Health Center.");
        }
    }

}
