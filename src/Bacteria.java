public class Bacteria extends Cell {

    // Constructor
    public Bacteria(String name, int cellHealth, int toxicity, Personality personality) {
        super(name, cellHealth, toxicity, personality);
    }

    // Methods
    public void replicate() {

        int oldHealth = getCellHealth();
        int newHealth = getCellHealth() + 10;

        if (newHealth > getMaxCellHealth()) {
            newHealth = getMaxCellHealth();
        }
        setCellHealth(newHealth);
        int healed = newHealth - oldHealth;
        System.out.println(this.getName() + " replicates and healed " + healed + " integrity to " + newHealth);
    }




    @Override
public void performAction(Cell targetCell) {

    int maxHealth = getMaxCellHealth();
    int currentHealth = getCellHealth();

    Personality currentPersonality = this.getPersonality();

    if (currentPersonality == Personality.AGGRESSIVE) {

        if (targetCell.getCellHealth() > targetCell.getMaxCellHealth() * 0.6) {
            interact(targetCell);
            System.out.println(getName() + " aggressively attacks " + targetCell.getName());
        } else if (currentHealth < maxHealth * 0.7) {
            replicate();
            System.out.println(getName() + " replicates to heal itself against a weakened target.");
        } 
        else if (targetCell.getCellHealth() < this.getToxicity()) {
            interact(targetCell);
            System.out.println(getName() + " finishes off " + targetCell.getName());

        } else {
            interact(targetCell);
            System.out.println(getName() + " attacks " + targetCell.getName());
        }
        
    } else if (currentPersonality == Personality.DEFENSIVE) {
          if (currentHealth < maxHealth * 0.6) {
        replicate();
        System.out.println(getName() + " is low on integrity and replicates to heal itself.");
    }

   
    else if (targetCell.getCellHealth() <= getToxicity()) {
        interact(targetCell);
        System.out.println(getName() + " finishes off " + targetCell.getName());
    }

   
    else if (targetCell.getCellHealth() < targetCell.getMaxCellHealth() * 0.3) {
        interact(targetCell);
        System.out.println(getName() + " attacks " + targetCell.getName() + " which is low on integrity.");
    }

    else {
        adapt();
        System.out.println(getName() + " adapts cautiously.");
    }

        
    } else if (currentPersonality == Personality.NEUTRAL) {
        if (currentHealth < maxHealth * 0.4) {
        replicate();
        System.out.println(getName() + " is low on integrity and replicates to heal itself.");
    }

   
    else if (targetCell.getCellHealth() <= getToxicity()) {
        interact(targetCell);
        System.out.println(getName() + " finishes off " + targetCell.getName());
    }

   
    else if (targetCell.getCellHealth() < targetCell.getMaxCellHealth() * 0.3) {
        interact(targetCell);
        System.out.println(getName() + " attacks " + targetCell.getName() + " which is low on integrity.");
    }

    else {
        adapt();
        System.out.println(getName() + " adapts cautiously.");
    }
}

    
    
}

    
    
}
