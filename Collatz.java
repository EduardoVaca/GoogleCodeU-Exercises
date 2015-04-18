
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
public class Collatz {
    //Consider a sequence of positive integers starting with x.If x is
    // even,the next integer in the sequence is x/2.If x is odd, the
    // next integer in the sequence is 3 * x + 1. The sequence stops when it
    // reaches1.
    //
    // For example, if x is 7, the sequence is
    //
    // 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1
    //
    // Fill in the function loopCount so that it returns the length of
    // the sequence starting from x.
    static int loopCount(int x) {
        int counter = 0;
        while(x != 1)
        {
            if(x % 2 == 0)
                x /= 2;
            else
                x = (x * 3) + 1;
            counter++;
        }
        return ++counter;
    }
 
    // Using loopCount, fill in the function maxLoop so that it returns
    // the maximum sequence length for any sequence that starts with a
    // number greater than or equal to x and less than y.
    static int maxLoop(int x, int y) {
        int max = 0;
        int counter_actual_loop;
        while (x < y)
        {
           counter_actual_loop = loopCount(x);
           if(counter_actual_loop > max)
               max = counter_actual_loop;                        
           x++;
        }
        return max;
    }
 
 //ANOTHER WAY OF DOING IT ->I SHOULD COMPARE COMPUTE TIME
    //Function that returns the whole loop in an ArrayList
    static ArrayList wholeLoop(int x) {
        ArrayList <Integer> loop = new ArrayList<Integer>();
        while(x != 1)
        {
            loop.add(x);
            if(x % 2 == 0)
                x /= 2;
            else
                x = (x * 3) + 1;
        }
        loop.add(x);
        for(int i = 0; i < loop.size(); i++){
            System.out.print(loop.get(i) + " ");
        }
        //Other way for traverse an arrayList
        /*for(Integer i: loop){
           System.out.println(i);
        }*/
        System.out.println();
        return loop;
    }
    
    static int maxLoopMyWay(int x, int y){        
        ArrayList <Integer> maxLoop = wholeLoop(x);
        ArrayList <Integer> actualLoop;
        int maxSize = maxLoop.size();
        int actualSize;
        int calculus = 0;
        while(x < y)
        {
            x++;
            if(maxLoop.contains(x) == false){
                System.out.println("ENTER " + calculus);
                calculus++;
                actualLoop = wholeLoop(x);
                actualSize = actualLoop.size();
                if(actualSize > maxSize){
                    maxLoop = actualLoop;
                    maxSize = actualSize;
                }
            }                
        }
        System.out.println("Calculs made: " + calculus);
        return maxSize;
    }
    
    
    public static void main(String[] args) {
        //System.out.println(maxLoop(1, 100000));
        //System.out.println("Loops for 77031: " + loopCount(77031));
        //System.out.println("Loops for 77031: " + loopCount(97371));
        //ArrayList <Integer> a = wholeLoop(99999);
        System.out.println(maxLoopMyWay(1, 100));
    }
}
