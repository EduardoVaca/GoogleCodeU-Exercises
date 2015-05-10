/*
Exercise 4 - Returning change
Given an integer N, and an unlimited supply of coins of M different denominations { D[0], D[1], .. D[M-1] }, 
compute the number of different ways you can make change for N “cents”.
For example, if we name this method makeChange, makeChange(10, {2, 3, 5}) 
should return 4, since there are 4 ways that combinations of 2, 3, and 5 add up to 10 ({5,5}, {2,3,5}, {2,2,2,2,2}, and {2,2,3,3}). 
makeChange(1, {2, 3, 5}) should return 0.
*/

/*Questions:
Approach: Dynamic Programming.

is there something more efficient?

not returning any change is a way of returning?
*/

import java.util.Scanner;

public class MakeCoinChange{

	public static int makeChange(int number, int [] coins){
		number++;
		int matrix[][] = new int[coins.length][number];
		for(int i = 0; i < coins.length; i++){
			for(int j = 0; j < number; j++){
				if(i == 0 || j == 0)
					matrix[i][j] = 1;
				else if(coins[i] > j)
					matrix[i][j] = matrix[i - 1][j];
				else if(coins[i] <= j)
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j - coins[i]];
			}
		}
		printMatrix(matrix);
		return matrix[coins.length-1][number-1];
	}

	public static void printMatrix(int matrix[][]){
		for(int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String args[]){
		int array [] = {1,2,5,10};		
		System.out.println(makeChange(10, array));
	}

}

