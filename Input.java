package com.sudoku;

import java.util.List;

public class Input {

    public static void insertInput(List<Tupid> list, int[][] board){

        for(int i = 0 ; i<list.size() ; i++){
            Tupid t = list.get(i);
            int row = t.row;
            int col = t.col;
            char value = t.value;

            board[row][col] = value;
        }

    }
}
