public class Bacteria extends Cell {

    // Constructor
    public Bacteria(String name, int cellHealth, int toxicity) {
        super(name, cellHealth, toxicity);
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

    // 1. Survival first
    if (currentHealth < maxHealth * 0.4) {
        replicate();
        System.out.println(getName() + " is low on integrity and replicates to heal itself.");
    }

    // 2. Can finish target → attack
    else if (targetCell.getCellHealth() <= getToxicity()) {
        interact(targetCell);
        System.out.println(getName() + " finishes off " + targetCell.getName());
    }

    // 3. Weak target → attack
    else if (targetCell.getCellHealth() < targetCell.getMaxCellHealth() * 0.3) {
        interact(targetCell);
        System.out.println(getName() + " attacks " + targetCell.getName() + " which is low on integrity.");
    }

    // 4. Otherwise adapt
    else {
        adapt();
        System.out.println(getName() + " adapts cautiously.");
    }
}

    
    
}
