public class ImmuneCell extends Cell {
   
    // Constructor
    public ImmuneCell(String name, int cellHealth, int toxicity) {
        super(name, cellHealth, toxicity);
    }

    // Methods
    public void immuneResponse() {
        System.out.println(this.getName() + " initiates an immune response ");
        setResistance(0.25);

    }

    @Override
    public void performAction(Cell targetCell) {

        int maxHealth = this.getMaxCellHealth();

        if (this.getCellHealth() < maxHealth * 0.5) {
            immuneResponse();
            System.out.println("" + this.getName() + " is low on integrity and initiates an immune response to heal itself");
        }
        else if (targetCell.getCellHealth() < targetCell.getMaxCellHealth() * 0.3) {
            interact(targetCell);
            System.out.println(this.getName() + " attacks " + targetCell.getName() + " which is low on integrity.");
        }
        else {
            adapt();
            System.out.println("" + this.getName() + " adapts cautiously.");
        }
    }   




    
}
