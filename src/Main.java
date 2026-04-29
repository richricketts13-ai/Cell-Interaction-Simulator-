import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        try {

        FileWriter writer = new FileWriter("simulation_log.txt");

        Cell cellA = createRandomCell();

        Cell cellB = createRandomCell();

        int round = 1;

        while (cellA.isAlive() && cellB.isAlive()) {
            System.out.println("Round " + round);
            writer.write("Round " + round + "\n");
            round++;

            performAction(cellA, cellB);

            if (cellB.isAlive()) {
                performAction(cellB, cellA);
            }
            System.out.println();
            System.out.println(cellA.getName() + " integrity: " + cellA.getCellHealth());
            writer.write(cellA.getName() + " integrity: " + cellA.getCellHealth() + "\n");

            System.out.println(cellB.getName() + " integrity: " + cellB.getCellHealth());
            writer.write(cellB.getName() + " integrity: " + cellB.getCellHealth() + "\n");
        }
        if (cellA.isAlive()) {
            System.out.println(cellA.getName() + " wins!");
            writer.write(cellA.getName() + " wins!\n");

        } else if (cellB.isAlive()) {
            System.out.println(cellB.getName() + " wins!");
            writer.write(cellB.getName() + " wins!\n");
            
        } else {
            System.out.println("It's a draw!");
            writer.write("It's a draw!\n");
        }
        writer.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }





    public static Cell createRandomCell() {

        int rand = (int)(Math.random() * 3) + 1;
        Cell cell = null;

        switch (rand) {
            case 1 -> cell = new Bacteria("Bacteria", 10, 10);
            case 2 -> cell = new ImmuneCell("Immune Cell", 15, 5);
            case 3 -> cell = new Virus("Virus", 20, 7);
        }
        if (cell != null) {
            System.out.println("Created " + cell.getName() + " with " + cell.getCellHealth() + " integrity and " + cell.getToxicity() + " toxicity");
        }
        return cell;
    }






    public static void performAction(Cell cell, Cell targetCell) {

    int maxHealth = cell.getMaxCellHealth();

    if (cell.getCellHealth() < maxHealth * 0.3) {
        switch (cell) {
            case Bacteria bacteria -> {
                bacteria.replicate();
                System.out.println("" + cell.getName() + " is low on integrity and replicates to heal itself");
                return;
            }
            case ImmuneCell immuneCell -> {
                immuneCell.immuneResponse();
                System.out.println("" + cell.getName() + " is low on integrity and initiates an immune response to heal itself");
                return;
            }
            case Virus virus -> {
                virus.mutate();
                System.out.println("" + cell.getName() + " is low on integrity and mutates to adapt");
                return;
            }
            default -> {
            }
        }
    } else {
        switch (new Random().nextInt(3) + 1) {
            case 1 -> cell.interact(targetCell);
            case 2 -> cell.adapt();
            case 3 -> {
            switch (cell) {
                case Bacteria bacteria -> {
                    bacteria.replicate();
                    System.out.println("" + cell.getName() + " performs a regular replication to maintain integrity");
                }
                case ImmuneCell immuneCell -> {
                    immuneCell.immuneResponse();
                    System.out.println("" + cell.getName() + " initiates an immune response to maintain integrity");
                }
                case Virus virus -> {
                    virus.mutate();
                    System.out.println("" + cell.getName() + " mutates to adapt");
                }
                default -> {
                }
            }
            }
        }
        System.out.println(cell.getName() + " performs an action");
    }
}

    

   









        }  

     







