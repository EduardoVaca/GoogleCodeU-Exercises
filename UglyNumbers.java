/*
Ugly numbers are defined as the positive integers whose prime factors are limited to 2, 3, or 5.
By convention, 1 is also part of the sequence.  Here are the first 10 Ugly numbers:  1, 2, 3, 4, 5, 6, 8, 9, 10, and 12.
Write a method to print the K’th Ugly number.

Questions:
Can I use an additional data structure?
Whats the maximun value of K
What is more important: efficiency or storage?
Can I have some startup time?

*/

public class UglyNumbers{

	static int array_ugly_numbers [] = new int [1000];

	public static boolean isUglyNumber(int n){
		if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n == 1){
			return true;
		}
		return false;
	}

	public static void fillArrayUglyNumbers(){
		int sizeArrayUglyNumbers = array_ugly_numbers.length;
		int actualNumber = 1;
		int index = 0;
		while(index < sizeArrayUglyNumbers){
			if(isUglyNumber(actualNumber)){
				array_ugly_numbers[index] = actualNumber;
				index++;
			}
			actualNumber++;
		}
	}

	public static Integer findKUglyNumber(int k){
		if(k > 0 && k < array_ugly_numbers.length + 1)
			return array_ugly_numbers[k - 1];
		return null;
	}

	public static void main(String args[]){
		fillArrayUglyNumbers();
		System.out.println("Ugly Number 1: " + findKUglyNumber(1));
		System.out.println("Ugly Number 2: " + findKUglyNumber(2));
		System.out.println("Ugly Number 10: " + findKUglyNumber(10));
		System.out.println("Ugly Number 20: " + findKUglyNumber(20));
		System.out.println("Ugly Number -1: " + findKUglyNumber(-1));
		System.out.println("Ugly Number 1000: " + findKUglyNumber(1000));
	}
}