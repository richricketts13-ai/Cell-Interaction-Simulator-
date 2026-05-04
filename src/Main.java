import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Main {
    public static void main(String[] args) {

        int BacteriaWins = 0;
        int ImmuneCellWins = 0;
        int VirusWins = 0;

        Random RAND = new Random();

        for (int sim = 1; sim <= 50; sim++) {

        List<Cell> cells = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {

              cells.add(createRandomCell());
       }
       

       int round = 1;


        try {

        FileWriter writer = new FileWriter("simulation_log.txt", true);

        writer.write("\n======== Simulation " + sim + ":\n");

       

        while (cells.size() > 1 && round <= 100) {

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

        cell.performAction(targetCell);
    }

    
    for (Cell cell : cells) {
        if (!cell.isAlive()) {

            System.out.println(cell.getName() + " has died.");
            writer.write(cell.getName() + " has died.\n");
        }
    }

   
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


if (round > 100) {
    System.out.println("Maximum rounds reached. Ending simulation.");
    writer.write("Maximum rounds reached. Ending simulation.\n");
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

        if (cells.size() == 1) {
            if (cells.get(0) instanceof Bacteria) {
                BacteriaWins++;
            } else if (cells.get(0) instanceof ImmuneCell) {
                ImmuneCellWins++;
            } else if (cells.get(0) instanceof Virus) {
                VirusWins++;
            }
        }
      }
      
        System.out.println("Simulation Results after 50 runs:");
        System.out.println("Bacteria Wins: " + BacteriaWins + " (" + (BacteriaWins * 100 / 50) + "%)");
        System.out.println("Immune Cell Wins: " + ImmuneCellWins + " (" + (ImmuneCellWins * 100 / 50) + "%)");
        System.out.println("Virus Wins: " + VirusWins + " (" + (VirusWins * 100 / 50) + "%)");
    }





    public static Cell createRandomCell() {

        int rand = (int)(Math.random() * 3) + 1;
        Cell cell = null;

        Personality personality = Personality.values()[new Random().nextInt(Personality.values().length)];

        switch (rand) {
            case 1 -> cell = new Bacteria("Bacteria", 10, 10, personality);
            case 2 -> cell = new ImmuneCell("Immune Cell", 15, 5, personality);
            case 3 -> cell = new Virus("Virus", 20, 7, personality);
        }
        if (cell != null) {
            System.out.println("Created " + cell.getName() + " with " + cell.getCellHealth() + " integrity and " + cell.getToxicity() + " toxicity");
        }
        return cell;
    }
 }
    


    

   









        

     







