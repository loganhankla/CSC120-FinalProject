//import People.director;
import java.util.ArrayList;


public class Game {

    private ArrayList<Camper> campers;
    
    public Game(){
        this.makeNames();
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

    public String toString(){
        return "Camper Names are: " + campers;
    }

    public static void main(String[] args) {
        //Camper c = new Camper("Parker");
        Nurse becky = new Nurse("Becky");
        Game game = new Game();
        System.out.println(game.toString());
        becky.next(game.campers.get(0));
        
        
    }
}
