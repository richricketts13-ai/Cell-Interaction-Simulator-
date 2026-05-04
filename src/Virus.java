import java.util.Random;
public class Virus extends Cell {

    // Constructor
    public Virus(String name, int cellHealth, int toxicity) {
        super(name, cellHealth, toxicity);
    }

    //Methods 
    public void mutate() {

        int currentToxicity = getToxicity();

        int random = new Random().nextInt(6) + 3;
         
        int newToxicity = currentToxicity + random;

        int increase = newToxicity - currentToxicity;

        setToxicity(newToxicity);
        
        System.out.println(this.getName() + " mutates and increases toxicity by " + increase + " to " + newToxicity);
    
    }
    

    @Override
    public void performAction(Cell targetCell) {

       if (targetCell.getCellHealth() <= getToxicity()) {

        interact(targetCell);
        System.out.println(getName() + " finishes off " + targetCell.getName());
       } 
       else if (getToxicity() < 20) {

           mutate();
           System.out.println(getName() + " mutates to increase toxicity.");
       } else {

        interact(targetCell);
        System.out.println(getName() + " attacks " + targetCell.getName());
       }
     }














     

}













