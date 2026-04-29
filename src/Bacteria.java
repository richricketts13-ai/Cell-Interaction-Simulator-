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

    
    
}
