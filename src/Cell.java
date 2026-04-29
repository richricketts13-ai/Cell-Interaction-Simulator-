public class Cell {

   // Fields
    private final String name;
    private int cellHealth;
    private double resistance = 1.0;
    private int toxicity;
    private final int maxCellHealth;

    //Constructor
    public Cell(String name, int cellHealth, int toxicity) {
        this.name = name;
        this.cellHealth = cellHealth;
        this.toxicity = toxicity;
        this.maxCellHealth = cellHealth;
    }

    //Methods
    public void absorbToxin(int toxinAmount) {

        int adjustedToxinAmount = (int)(toxinAmount * resistance);

        cellHealth -= adjustedToxinAmount;

        resistance = 1.0;

        if (cellHealth < 0) {
            cellHealth = 0;
        }
   
    } 

    public void interact(Cell targetCell) {

        targetCell.absorbToxin(this.toxicity);

        System.out.println(this.getName() + " interacts with " + targetCell.getName() + " and releases " + this.toxicity + " toxicity");

    
       }


       public void regenerate(int amount) {
         int oldHealth = cellHealth;

         cellHealth += amount;

         if (cellHealth > maxCellHealth) {
             cellHealth = maxCellHealth;
         }
         int healed = cellHealth - oldHealth;

         System.out.println("" + this.getName() + " regenerates " + healed + " integrity");
        }


        public void adapt() {
            resistance = 0.5;
            System.out.println("" + this.getName() + " adapts and reduces toxin damage ");
        }

        public boolean isAlive() {
            return cellHealth > 0;
        }


    // Getters
    public String getName() {
        return name;
    }

    public int getCellHealth() {
        return cellHealth;
    }

    public double getResistance() {
        return resistance;
    }

    public int getMaxCellHealth() {
        return maxCellHealth;
    }

    public int getToxicity() {
        return toxicity;
    }




    //Setters
    public void setResistance(double resistance) {
        this.resistance = resistance;
    } 

    public void setToxicity(int toxicity) {
        this.toxicity = toxicity;
        
    }

    public void setCellHealth(int cellHealth) {
        this.cellHealth = cellHealth;
    }
}






