
public class GameOfLifeView {
    // Declare a method to display the current state of the grid in the console.
    public void displayGrid(int[][] grid) {
        // Iterate through each row in the grid.
        for (int[] row : grid) {
            // Iterate through each cell in the current row.
            for (int cell : row) {
                // Print "■ " if the cell is alive (1), and "□ " if it's dead (0).
                System.out.print((cell == 1) ? "■ " : "□ ");
            }
            // Move to the next line after printing the cells in the current row.
            System.out.println();
        }
        // Print a line of dashes to separate.
        System.out.println("-------------");
    }
}