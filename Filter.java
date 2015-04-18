
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo Vaca
 */
public class Filter {
    // Write a function named "evens" that takes as input an array of
    // ints and returns a different array of ints containing
    // only the even elements of the input.
    public static int[] evens(int[] input) {
        int input_size = input.length;
        int number_of_evens = 0;
        int temp_array_evens [] = new int [input_size];
        for(int i = 0; i < input_size; i++){
            if(input[i] % 2 == 0){                
                 temp_array_evens[number_of_evens++] = input[i];                 
            }                           
        }
        //The final array of excact size without zeros
        int final_array_evens [] = new int [number_of_evens];
        for(int i = 0; i < number_of_evens; i++){            
            final_array_evens[i] = temp_array_evens[i];
        }
        return final_array_evens; 
    }
 
    public static void main(String[] args) { //
        // Expected output:
        // test1 results:
        // 8
        // 6
        // 0
        // test2 results:
        // 2
        // 18
        // 28
        // 18
        // 28
        // 90
        // //STUDENTS, ADD ADDITIONAL TEST CASES BELOW
        int[] test1 = {8, 6, 7, 5, 3, 0, 9};
        int[] ans = evens(test1);
        System.out.println("test1results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
        int[] test2 = {2, 7, 18, 28, 18, 28, 45, 90, 45};
        ans = evens(test2);
        System.out.println("\ntest2results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
        int[] test3 = {0, 1, -2, 3, -4, 5, -6};
        ans = evens(test3);
        System.out.println("\ntest3results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
         int[] test4 = { 1, 3, 5};
        ans = evens(test4);
        System.out.println("\ntest4results:");
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }
    }
}
