

🧬 Cell Interaction Simulator

A Java-based simulation that models interactions between different biological cell types using object-oriented design, simple AI decision-making, and dynamic behavior.

⸻

🚀 Overview

This project simulates interactions between three types of cells:

* 🧫 Bacteria – focuses on regeneration and survival
* 🛡 Immune Cell – adapts and reduces incoming damage
* 🦠 Virus – evolves over time through mutation

Each cell acts independently using a decision system that balances randomness with condition-based behavior (e.g., low health triggers defensive actions).

The simulation runs in rounds until one cell loses all integrity.

⸻

🧠 Key Features

* Object-Oriented Design
    * Base Cell class with shared behavior
    * Specialized subclasses (Bacteria, ImmuneCell, Virus)
* AI Decision System
    * Randomized actions each round
    * Smarter behavior when health is low (adaptive strategy)
* Dynamic Mutation System
    * Virus increases toxicity with controlled randomness
* Simulation Loop
    * Turn-based interaction between two cells
    * Continues until one cell is no longer alive
* File Logging
    * Simulation results saved to simulation_log.txt
    * Tracks rounds, health changes, and final outcome

⸻

⚙️ How It Works

1. Two random cells are generated
2. Each round:
    * Both cells perform an action:
        * Interact (attack)
        * Adapt (reduce damage)
        * Use a special ability
3. Health (integrity) is updated after each round
4. Simulation ends when one cell reaches 0 integrity
5. Results are printed to the console and saved to a file

⸻

📂 Project Structure

src/
├── Main.java
├── Cell.java
├── Bacteria.java
├── ImmuneCell.java
├── Virus.java

⸻

▶️ How to Run

1. Clone the repository
2. Open the project in VS Code (or any Java IDE)
3. Compile and run:

javac src/*.java
java -cp src Main

⸻

📄 Example Output

Round 1
Bacteria integrity: 8
Virus integrity: 17
Round 2
Bacteria integrity: 5
Virus integrity: 21
Virus wins!

⸻

🧪 What I Learned

* Applying object-oriented programming to model real-world systems
* Designing behavior-driven simulations instead of static logic
* Implementing basic AI decision-making
* Managing state changes and interactions between objects
* Writing simulation data to files for later analysis

⸻

🚧 Future Improvements

* Run multiple simulations and track win rates
* Export results to CSV for data analysis
* Add more cell types and behaviors
* Improve AI with decision weighting instead of pure randomness
* Build a visual interface (GUI)

⸻

💡 Why This Project Matters

This project demonstrates how programming concepts like OOP, state management, and decision logic can be used to simulate real-world systems. It serves as a foundation for more advanced simulations, including biological modeling or machine learning experiments.

⸻

## Version 2
- Introduced multi-cell simulation (3+ cells)
- Implemented dynamic targeting system
- Added removal of dead cells during simulation
- Improved logging and round tracking


## Version 3 – Multi-Simulation & Statistics

- Added support for running multiple simulations (e.g., 50 runs)
- Implemented win tracking for each cell type (Bacteria, Immune Cell, Virus)
- Introduced statistical output to compare outcomes across simulations
- Improved logging to track results across multiple runs

This version transforms the project from a single simulation into a basic experimental system, allowing analysis of which cell types perform best over time.



🏁 Author

Richard Ricketts

::

