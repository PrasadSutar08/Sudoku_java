public class Sudoku{
    public static void main(String[] args) {
        int[][] puzzle = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        
        if (solvePuzzle(puzzle)) {
            displayPuzzle(puzzle);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean solvePuzzle(int[][] puzzle) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (puzzle[r][c] == 0) {
                    for (int candidate = 1; candidate <= 9; candidate++) {
                        if (isValidPlacement(puzzle, r, c, candidate)) {
                            puzzle[r][c] = candidate;
                            if (solvePuzzle(puzzle)) {
                                return true;
                            }
                            puzzle[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidPlacement(int[][] puzzle, int row, int col, int candidate) {
        for (int x = 0; x < 9; x++) {
            if (puzzle[row][x] == candidate) {
                return false;
            }
        }

        for (int x = 0; x < 9; x++) {
            if (puzzle[x][col] == candidate) {
                return false;
            }
        }

        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[boxStartRow + i][boxStartCol + j] == candidate) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void displayPuzzle(int[][] puzzle) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(puzzle[row][col] + " ");
            }
            System.out.println();
        }
    }
}
