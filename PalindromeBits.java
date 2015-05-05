import java.lang.String;

public class PalindromeBits{

	static int [] array_palindrome_numbers = new int [1000];

	public static boolean isPalindrome(String s){
		char [] arrayChars = s.toCharArray();
		int sizeArray = arrayChars.length;
		int halfIndex, leftIndex, rightIndex;
		halfIndex = sizeArray / 2;
		if(sizeArray % 2 == 0){
			rightIndex = halfIndex;
			leftIndex = rightIndex - 1;
		}else{
			rightIndex = halfIndex + 1;
			leftIndex = halfIndex - 1;
		}
		for(int i = 0; i < halfIndex; i++){
			if(arrayChars[leftIndex] != arrayChars[rightIndex])
				return false;
			rightIndex++;
			leftIndex--;	
		}
		return true;			
	}

	public static void fillArrayPalindromes(){
		int sizePalindromeArray = array_palindrome_numbers.length;
		int actualNumber = 1, indexToPutIn = 0;
		while(indexToPutIn < sizePalindromeArray){
			if(isPalindrome(Integer.toBinaryString(actualNumber))){
				array_palindrome_numbers[indexToPutIn] = actualNumber;
				indexToPutIn++;
			}
			actualNumber++;
		}
	}

	public static int findPalindromeK(int k){
		return array_palindrome_numbers[k - 1];
	}

	public static void main(String args[]){
		fillArrayPalindromes();
		System.out.println("Palindrome #1: " + findPalindromeK(1));
		System.out.println("Palindrome #2: " + findPalindromeK(2));
		System.out.println("Palindrome #3: " + findPalindromeK(3));
		System.out.println("Palindrome #10: " + findPalindromeK(10));
		System.out.println("Palindrome #100: " + findPalindromeK(100));
		System.out.println("Palindrome #1000: " + findPalindromeK(1000));
		/*Output:
		Palindrome #1: 1
		Palindrome #2: 3
		Palindrome #3: 5
		Palindrome #10: 31
		Palindrome #100: 2409
		Palindrome #1000: 250671*/
		
	}
}


/*Exercise 1 - Palindrome #1 - bits
A palindrome is a sequence that is the same if it is reversed.  The string “abba” is a palindrome.  
The string “aaba” is not.  A sequence of digits, characters, numbers, or whatever can be palindromic. 
Natural language palindromes typically ignore spaces and punctuation (e.g., “Madam, I’m Adam”) is considered a palindrome.
Write a method with integer argument K that finds and returns the K’th positive integer whose binary representation is a palindrome. 
The first such integers are 1 (‘1’), 3 (‘11’), 5 (‘101’), 7 (‘111’), etc.
There are actually two ways to do this problem;  (1A) ignore leading zeros, or (1B) use as many leading zeros as you need.
Using definition 1B, two additional integers, 2 (‘010’), and 6 (‘0110’) are added to the list.

Questions 
Which is the maximun value of K?
I’m I allowed to use an additional data structure?
May I use Integer.toBinaryString()?
*/
