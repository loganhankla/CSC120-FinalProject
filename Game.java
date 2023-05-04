//import People.director;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {

    public ArrayList<Camper> campers;
    private Nurse becky;
    private HealthCenter hCenter;
    private Camper c;
    
    public Game(){
        this.makeNames();
        this.becky = new Nurse("Becky");
        this.hCenter = new HealthCenter();
        this.becky.setHC(this.hCenter);

        //while this.hCenter.going = true loop?
    }

    public void printOptions(){
        //buy, use, dismiss, intake, call next, ask more, check wallet
    }

    public void makeNames(){
        //make ArrayList of camper names
        this.campers = new ArrayList<Camper>();
        this.campers.add(new Camper("Brian")); 
        this.campers.add(new Camper("Samantha")); 
        this.campers.add(new Camper("Madeleine")); 
        this.campers.add(new Camper ("Adrienne")); 
        this.campers.add(new Camper ("Willa")); 
        //System.out.println(this.camperNames);
       // return this.camperNames;
    }

    //public String toString(){
      //  return "Camper Names are: " + campers;
    //}

    public void play(){
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().toUpperCase();
        // if else for user inputs "USE" "BUY"
    }

    public static void main(String[] args) {
        //Camper c = new Camper("Parker");
        
        Game game = new Game();
        //System.out.println(Game.toString());
        game.becky.next(game.campers.get(0));
        
        
    }
}
