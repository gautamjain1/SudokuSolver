package com.sudoku;
import java.util.Scanner;

public class SudokuMain {

    public static void main(String[] args){

        int[][] board = new int[9][9];

        Scanner scanner = new Scanner(System.in);

        System.out.println("press 1 for system generated sudoku press 2 for custom sudoku");

        int choise = scanner.nextInt();

        switch(choise){
            case 1:
                board = CreatingPuzzle.generate();
                break;

            case 2:
                CustomSudokuGenerator.generator(board);
                break;
        }

//        System.out.println("Printing puzzle");
//        SudokuMain.print(board);

        System.out.println("Printing puzzle after removing");
        Example.remove(board);
        SudokuMain.print(board);

        SudokuSolver.solveSudoku(board);


        int count = 0 ;

        for(int i = 0 ; i<9 ; i++){
            for(int j = 0 ; j<9 ; j++){
                if(board[i][j] == 0){
                    count++;
                }
            }
        }

        if(count != 0){
            System.out.println("No valid solution exist for given sudoku");
        }
        else{
            System.out.println("valid solution for given sudoku");
            SudokuMain.print(board);
        }

    }
    private static void print(int[][] board) {
        int n = board.length;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int count(int[][] board){

        int countEmptyCell = 0;
        int n = board.length;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(board[i][j] == 0){
                    countEmptyCell++;
                }
            }
        }
        return countEmptyCell;
    }
}
