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



    
}
