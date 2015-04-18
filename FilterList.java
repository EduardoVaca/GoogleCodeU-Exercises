import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FilterList {
    // Write a function named "evens" that takes as input a
    // list of Integer (almost but not quite int) and returns
    // a new list of ints containing only the even elements
    // of the input.

    //Function that recieves as a parameter a List of Integers, and return a new list of only the even numbers of the list recieved
    public static List<Integer> evens(List<Integer> input) {
        List<Integer> list_of_evens = new ArrayList<Integer>();
        for(Integer element : input){
            if(element % 2 == 0)
                list_of_evens.add(element);            
        }        
        return list_of_evens;
    }

    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<Integer>(Arrays.asList(8,6,7,5,3,0,9));
        List<Integer> ans = evens(test1);
        // Expected output: 8, 6, 0
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();

        List<Integer> test2 = new ArrayList<Integer>(Arrays.asList(2,7,18,28,18,28,45,90,45));
        ans = evens(test2);
        // Expected output: 2, 18, 28, 18, 28, 90
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();

        //The test of the typical list from 1 to 10
        List<Integer> test3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ans = evens(test3);
        //Expected output: 2, 4, 6, 8, 10
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();

        //Test without any even number
        List<Integer> test4 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9));
        ans = evens(test4);
        //Expected output: 
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();

        //Test with negative numbers
        List<Integer> test5 = new ArrayList<Integer>(Arrays.asList(-2,2,-2,2,-2,2,12222));
        ans = evens(test5);
        // Expected output: -2, 2, -2, 2, -2, 2, 12222
        for (Integer n: ans) {
            System.out.print(Integer.valueOf(n) + ", ");
        }
        System.out.println();
    }
}
