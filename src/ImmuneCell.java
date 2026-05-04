public class ImmuneCell extends Cell {
   
    // Constructor
    public ImmuneCell(String name, int cellHealth, int toxicity, Personality personality) {
        super(name, cellHealth, toxicity, personality);
    }

    // Methods
    public void immuneResponse() {
        System.out.println(this.getName() + " initiates an immune response ");
        setResistance(0.25);

    }

    
    @Override
      public void performAction(Cell targetCell) {

        int maxHealth = this.getMaxCellHealth();

        Personality currentPersonality = this.getPersonality();

        if (currentPersonality == Personality.AGGRESSIVE) {

            if (targetCell.getCellHealth() > targetCell.getMaxCellHealth() * 0.6) {
                interact(targetCell);
            } else if (this.getCellHealth() < maxHealth * 0.4) {
                immuneResponse();
            }
            else if (targetCell.getCellHealth() < this.getToxicity()) {
                interact(targetCell);
                System.out.println(this.getName() + " aggressively attacks " + targetCell.getName() + " which is critically low on integrity.");
                
            } else {
                adapt();
                System.out.println("" + this.getName() + " adapts aggressively.");
            }   

        } else if (currentPersonality == Personality.DEFENSIVE) {

            if (this.getCellHealth() < maxHealth * 0.6) {
                immuneResponse();
            } else if (targetCell.getCellHealth() < targetCell.getMaxCellHealth() * 0.4) {
                interact(targetCell);
            } else {
                adapt();
                System.out.println("" + this.getName() + " adapts defensively.");
            }

        } else if (currentPersonality == Personality.NEUTRAL) {

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
              

        

        
    }


    

