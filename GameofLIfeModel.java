
class GameOfLifeModel {
    // Declare private variables to store the grid, number of rows, and number of columns.
    private int[][] grid;
    private int rows;
    private int columns;

    // Create a constructor that initializes the model with a specified number of rows and columns.
    public GameOfLifeModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        // Initialize the grid with the specified number of rows and columns.
        this.grid = new int[rows][columns];
    }

    // Define a method to get the number of rows in the grid.
    public int getRows() {
        return rows;
    }

    // Define a method to get the number of columns in the grid.
    public int getColumns() {
        return columns;
    }

    // Define a method to retrieve the current state of the grid.
    public int[][] getGrid() {
        return grid;
    }

    // Define a method to set the state of a specific cell in the grid.
    public void setCellState(int row, int col, int state) {
        grid[row][col] = state;
    }

    // Define a method to get the state of a specific cell in the grid.
    public int getCellState(int row, int col) {
        return grid[row][col];
    }

    // Define a method to evolve the grid to the next generation based on the rules of the Game of Life.
    public void evolve() {
        // Create a new grid to store the updated state.
        int[][] newGrid = new int[rows][columns];

        // Iterate through each cell in the grid.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Count the number of live neighbors for the current cell.
                int liveNeighbors = countLiveNeighbors(i, j);

                // Apply update the cell's state in the new grid.
                if (grid[i][j] == 1) {
                    newGrid[i][j] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
                } else {
                    newGrid[i][j] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        // Update the original grid with the new state.
        for (int i = 0; i < rows; i++) {
            System.arraycopy(newGrid[i], 0, grid[i], 0, columns);
        }
    }

    // Define a helper method to count the number of live neighbors for a specific cell.
    private int countLiveNeighbors(int row, int col) {
        // Initialize a counter for live neighbors.
        int count = 0;

        // Iterate through the neighboring cells.
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Calculate the coordinates of the neighboring cell.
                int newRow = row + i;
                int newCol = col + j;

                // Check if the neighboring cell is valid and not the current cell.
                if (isValidCell(newRow, newCol) && !(i == 0 && j == 0)) {
                    // Increment the live neighbor count if the neighboring cell is alive.
                    count += grid[newRow][newCol];
                }
            }
        }

        // Return the total count of live neighbors.
        return count;
    }

    // Define a helper method to check if a cell is within the valid boundaries of the grid.
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}
