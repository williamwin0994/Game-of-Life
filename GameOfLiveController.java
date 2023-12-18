
class GameOfLifeController {
    // Declare private variables to hold references to the model and view.
    private GameOfLifeModel model;
    private GameOfLifeView view;

    // Create a constructor to initialize the controller with references to the model and view.
    public GameOfLifeController(GameOfLifeModel model, GameOfLifeView view) {
        this.model = model;
        this.view = view;
    }

    // Define a method to initialize the grid randomly.
    public void initializeRandomly() {
        // Iterate through each cell in the grid and randomly set it as alive (1) or dead (0).
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getColumns(); j++) {
                model.setCellState(i, j, Math.random() < 0.5 ? 1 : 0);
            }
        }
    }

    // Define a method to run the Game of Life simulation.
    public void runGame() {
        // Display the initial state of the grid.
        view.displayGrid(model.getGrid());

        // Iterate through a specified number of generations. In this case, it is set to 5 generations. You can set whatever number you want.
        for (int generation = 1; generation <= 5; generation++) {
            // Evolve the grid to the next generation based on the rules of the Game of Life.
            model.evolve();

            // Display the updated state of the grid.
            view.displayGrid(model.getGrid());

            try {
                // Introduce a delay to observe the changes between generations.
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}