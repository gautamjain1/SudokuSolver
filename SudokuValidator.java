package com.sudoku;

public class SudokuValidator {
    public static boolean isValid(int[][] board , int row , int col , int ch){

        for(int i = 0 ; i<9 ; i++){
            if(board[row][i] == ch){
                return false;
            }
            if(board[i][col] == ch){
                return false;
            }

            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch){
                return false;
            }
        }
        return true;
    }
}
