import static java.util.Arrays.sort;
import java.util.Collection;

/*Questions
1. Which exception shall I throw?
2. What happen comparing equal numbers? For example if I have {1, 2, 3, 3}, nthLargest() should return 3 or an Exceotion?
*/

public class Largest {
    
    int [] array;
	
	public Largest(int [] array){
		this.array = array;
		sort(array);
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
	}

	public Integer nthLargest(int nth){
		if(nth > array.length){			           	
            throw new NullPointerException();                    
		}
		int pastNumber = array[array.length - 1];
		for(int i = array.length - 1; i >= 0; i--){
			if(i < array.length - 1 && array[i] != pastNumber){
				pastNumber = array[i];
				nth --;
			}
			if(nth == 1)
				return array[i];
		}			
        throw new NullPointerException();
	}


	public static void main(String args[]){

		int array[] = {5, 3, 9, 4, 3, 3, 8, 3, 3};
		Largest larger = new Largest(array);
		System.out.println("Largest: " + larger.nthLargest(9));
	}
    
}
