/*Exercise 5 - Find dictionary words #1 - Split a string into words
Given an input string (with no spaces) and a dictionary of words, 
implement a method that breaks up the input string into a space-separated
 string of dictionary words that a search engine might use for "Did you mean?"  
 For example, an input of "applepie" should yield an output of "apple pie", 
 assuming that "apple" and "pie" are in the dictionary.
The most basic version of this problem assumes that:
We are only concerned with breaking up an input string into 2 dictionary words.
The dictionary fits in memory.
All feasible outputs are equally valid, e.g., for an input of "aman", we are indifferent between "a man" and "am an" as outputs.
We require that the entire input string be consumed, and do not allow any edits.
A useful (and harder) variation is to assume the input is an arbitrary number of words, 
and find all the candidate splits that produce 2 or more valid words.  This is typically called segmentation.*/


/*Questions
1. Are there always a minimun of two words?
2. Which is the minimum length of a word in the dictionary?
3. Is the look for a word in the dictionary is O(1), like a hash?
*/

public static String splitStringByDiccionary(String s){
	String a, b;
	int i = 0 , j = 0, lastIndex = s.length() - 1;
	while(j < (s.length() - 1)){
		a = s.substring(i, j);		
		b = s.substring(j + 1, lastIndex);
		if(isInDictionary(a) && isInDictionary(b))
			return a + " " + b;
		else
			j++;
	}
	return "Not in Dictionary";
}