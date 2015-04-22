import java.util.ArrayList;
import java.util.Collections;

/* Questions:

What happens if you have 50% of one element and the other 50% of another element?
May the collection received be empty?
Is there a maximum size of the collection?
MENTOR: Is there a better collection for this problem?
MENTOR: Difference between Integer and int?

Approach: Sort the array, the check index i and check index i + halfSizeOfArray, 
if they have the same value, return if, else continue checking until i = sizeArray/2 - 1
*/

public class Majority{
	
	//Without documentation
	public static Integer hasMajority(ArrayList<Integer> listOfElements){
		Collections.sort(listOfElements);
		int halfSizeOfArray = listOfElements.size() / 2;
		int limitOfChecking;
		if(listOfElements.size() % 2 == 0)
			limitOfChecking = listOfElements.size() / 2 - 1;//if size isPair
		else
			limitOfChecking = listOfElements.size() / 2;
		int pastElement = 0;
		for(int i = 0; i <= limitOfChecking; i++){
			if(i == 0 || listOfElements.get(i) != pastElement){
				if(listOfElements.get(i) == listOfElements.get(i + halfSizeOfArray))
					return listOfElements.get(i);
			}				
			pastElement = listOfElements.get(i);
		}
		return null;
	}

	//With documentation
	  public static Integer hasMajorityWithDoc(ArrayList<Integer> listOfElements){
		Collections.sort(listOfElements);
		int halfSizeOfArray = listOfElements.size() / 2;
		int limitOfChecking;
		if(listOfElements.size() % 2 == 0)
			limitOfChecking = listOfElements.size() / 2 - 1;//if size is even
		else
			limitOfChecking = listOfElements.size() / 2;// if size not even
        int i = 0;
        while(i <= limitOfChecking){
            if(listOfElements.get(i) == listOfElements.get(i + halfSizeOfArray)) //is it better to have an local Integer to represent listOfElements.get(i)?
                return listOfElements.get(i);
            i = listOfElements.lastIndexOf(listOfElements.get(i)) + 1;
            
        }
		return null;
	}

	public static void main(String args[]){
		ArrayList<Integer> list = new ArrayList<Integer>();		
		list.add(5);
		list.add(3);
		list.add(9);
		list.add(4);
		list.add(3);
		list.add(3);
		list.add(8);
		list.add(3);
		list.add(3);
		Integer maj = hasMajorityWithDoc(list);
		if(maj != null)
			System.out.println("Majority: " + maj);
		else
			System.out.println("null");
	}
}