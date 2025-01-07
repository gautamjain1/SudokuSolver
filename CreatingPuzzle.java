package com.sudoku;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreatingPuzzle {

    private static final int SIZE = 9; // 9x9 Sudoku grid
    private static final int SUBGRID_SIZE = 3; // 3x3 subgrids
    private static final int EMPTY = 0; // Empty cell value
    private static final int[][] grid = new int[SIZE][SIZE];
    private static final Random random = new Random();

            public static int[][] generate() {

                generateFullGrid();
//                printGrid(grid);

                System.out.println("Generated Sudoku ");

                return grid;
            }
            private static void generateFullGrid() {
                fillGrid(0, 0);
            }

    private static boolean fillGrid(int row, int col) {
        if (row == SIZE) {
            return true; // Reached the end of the grid
        }

        if (col == SIZE) {
            return fillGrid(row + 1, 0); // Move to the next row
        }

        List<Integer> numbers = getShuffledNumbers();

        for (int num : numbers) {
            if (isSafeToPlace(row, col, num)) {
                grid[row][col] = num;
                if (fillGrid(row, col + 1)) {
                    return true;
                }
                grid[row][col] = EMPTY; // Backtrack
            }
        }
        return false; // Backtrack if no number is suitable
    }

    // Get a shuffled list of numbers from 1 to 9
    private static List<Integer> getShuffledNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= SIZE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers, random);
        return numbers;
    }

    // Check if a number can be placed in the given position
    private static boolean isSafeToPlace(int row, int col, int num) {
        return isRowSafe(row, num) && isColSafe(col, num) && isSubgridSafe(row, col, num);
    }

    // Check if the number is safe in the row
    private static boolean isRowSafe(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (grid[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    // Check if the number is safe in the column
    private static boolean isColSafe(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (grid[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    // Check if the number is safe in the 3x3 subgrid
    private static boolean isSubgridSafe(int row, int col, int num) {
        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;

        for (int r = startRow; r < startRow + SUBGRID_SIZE; r++) {
            for (int c = startCol; c < startCol + SUBGRID_SIZE; c++) {
                if (grid[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int solve(int[][] grid, int row, int col, int count) {
        if (row == SIZE) {
            return count + 1;
        }

        if (col == SIZE) {
            return solve(grid, row + 1, 0, count);
        }

        if (grid[row][col] != EMPTY) {
            return solve(grid, row, col + 1, count);
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isSafeToPlace(row, col, num)) {
                grid[row][col] = num;
                count = solve(grid, row, col + 1, count);
                grid[row][col] = EMPTY;

                if (count > 1) {
                    return count; // More than one solution found
                }
            }
        }
        return count;
    }
    private static void printGrid(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}

