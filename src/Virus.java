import java.util.Random;
public class Virus extends Cell {

    // Constructor
    public Virus(String name, int cellHealth, int toxicity, Personality personality) {
        super(name, cellHealth, toxicity, personality);
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

        Personality currentPersonality = this.getPersonality();

        if (currentPersonality == Personality.AGGRESSIVE) {

            if (targetCell.getCellHealth() > targetCell.getMaxCellHealth() * 0.5) {
                interact(targetCell);
                System.out.println(getName() + " aggressively attacks " + targetCell.getName());
            } else if (this.getCellHealth() < this.getMaxCellHealth() * 0.7) {
                mutate();
                System.out.println(getName() + " mutates to increase toxicity against a weakened target.");
            } else {
                interact(targetCell);
                System.out.println(getName() + " attacks " + targetCell.getName());
            }


        } else if (currentPersonality == Personality.DEFENSIVE) {
            
            if (this.getCellHealth() < this.getMaxCellHealth() * 0.5) {
                mutate();
                System.out.println(getName() + " mutates defensively to increase toxicity.");
            } else if (targetCell.getCellHealth() < targetCell.getMaxCellHealth() * 0.3) {
                interact(targetCell);
                System.out.println(getName() + " attacks " + targetCell.getName() + " which is low on integrity.");
            } else {
                adapt();
                System.out.println(getName() + " adapts defensively to avoid confrontation.");
            }

        } else if (currentPersonality == Personality.NEUTRAL) {

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












       














     

}













