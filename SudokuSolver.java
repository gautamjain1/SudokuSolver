package com.sudoku;

public class SudokuSolver {
        public static boolean solveSudoku(int[][] board){

            for(int i = 0 ; i<9 ; i++){
                for(int j = 0 ; j<9 ; j++){
                    if(board[i][j] == 0){
                        for(int ch = 1 ; ch<=9 ; ch++){
                            if(SudokuValidator.isValid(board , i , j , ch)){
                                board[i][j] = ch;
                                if(SudokuSolver.solveSudoku(board)){
                                    return true;
                                }
                                else{
                                    board[i][j] = 0;
                                }
                            }
                        }

                        return false;
                    }
                }
            }
            return true;
        }
}
