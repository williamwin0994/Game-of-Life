public class GameOfLifeMVC {
    public static void main(String[] args) {
        // Create an instance of the GameOfLifeModel with a grid size of 20x20. 20x20 you can change whatever you want
        GameOfLifeModel model = new GameOfLifeModel(20, 20);

        // Create an instance of the GameOfLifeView.
        GameOfLifeView view = new GameOfLifeView();

        // Create an instance of the GameOfLifeController, passing the model and view as parameters.
        GameOfLifeController controller = new GameOfLifeController(model, view);

        // Initialize the grid randomly using the controller.
        controller.initializeRandomly();

        // Run the Game of Life by using the controller.
        controller.runGame();
    }
}