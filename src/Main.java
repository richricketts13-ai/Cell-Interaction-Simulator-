import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {

        Random RAND = new Random();


        try {

        FileWriter writer = new FileWriter("simulation_log.txt");

       List<Cell> cells = new ArrayList<>();

       for (int i = 0; i < 3; ++i) {
              cells.add(createRandomCell());
       }


        int round = 1;

        while (cells.size() > 1) {
            System.out.println("Round " + round);
            writer.write("Round " + round + "\n");
            round++;

            // 1. Actions
            for (Cell cell : cells) {
                if (!cell.isAlive()) continue;

                 Cell targetCell = cells.get(RAND.nextInt(cells.size()));

                  while (targetCell == cell) {

                       targetCell = cells.get(RAND.nextInt(cells.size()));
                    }

        performAction(cell, targetCell, RAND);
    }

    // 2. Log deaths
    for (Cell cell : cells) {
        if (!cell.isAlive()) {

            System.out.println(cell.getName() + " has died.");
            writer.write(cell.getName() + " has died.\n");
        }
    }

    // 3. Remove dead cells
    for (int i = cells.size() - 1; i >= 0; i--) {
        if (!cells.get(i).isAlive()) {
            cells.remove(i);
        }
    }

    for (Cell cell : cells) {
        System.out.println(cell.getName() + " has " + cell.getCellHealth() + " integrity");
        writer.write(cell.getName() + " has " + cell.getCellHealth() + " integrity\n");
    }
    System.out.println();
    writer.write("\n");
}

if (cells.size() == 1) {
    System.out.println(cells.get(0).getName() + " is the last cell standing!");
    writer.write(cells.get(0).getName() + " is the last cell standing!\n");
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






    public static void performAction(Cell cell, Cell targetCell, Random RAND) {

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
        switch (RAND.nextInt(3) + 1) {
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

     







