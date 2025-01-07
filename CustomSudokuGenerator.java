package com.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tupid{
    int row;
    int col;
    char value;
    public Tupid(int row , int col , char value){
        this.row = row;
        this.col = col;
        this.value = value;
    }


}
public class CustomSudokuGenerator{

    public static void generator(int[][] board){

        List<Tupid> list = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = read.nextInt();

        for(int i = 0 ; i<n ; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter row , col and value separated by space: ");
            String input = scanner.nextLine();
            String[] parts = input.split(",");

            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            char value = parts[2].charAt(0);

            Tupid tupid = new Tupid(row, col, value);
            list.add(tupid);
        }

        System.out.println("Tupid created successfully");

//        for(int i = 0 ; i<list.size() ; i++){
//            Tupid t = list.get(i);
//            int row = t.row;
//            int col = t.col;
//            char value = t.value;
//
//            System.out.println("Row: " +row + " Col: "+col + " Value: "+value);
//        }
        Input.insertInput(list , board);
    }
}