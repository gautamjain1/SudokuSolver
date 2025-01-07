package com.sudoku;

import java.util.*;

public class Example {

    public static void remove(int[][] board){
        int n = 30;
        Random random = new Random();

        int rownum = 8;
        int colnum = 8;

        while(n>=0){
            int row = random.nextInt(rownum);
            int col = random.nextInt(colnum);
            board[row][col] = 0;
//            System.out.println("Row "+row + " Col " + col);
            n--;
        }
    }
}

