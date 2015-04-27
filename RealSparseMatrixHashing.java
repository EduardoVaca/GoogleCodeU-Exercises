/*Questions:
1. Can I use an array of [row][col] as a key for each element in the hashTable?
2. Can I recieve a query with a rwo and column not int the size of my matrix?
*/



import java.util.*;
import java.util.Hashtable;

public class RealSparseMatrixHashing{

	private int rows, cols;	
	private Hashtable <Integer, Integer> matrixHashTable;


	public RealSparseMatrixHashing(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		matrixHashTable = new Hashtable<Integer, Integer>();
	}

	public int rowDimension(){
		return rows;
	}

	public int columnDimension(){
		return cols;
	}

	public void setWithHash(int row_index, int col_index, int value){
		if(row_index > -1 && col_index > -1 && row_index < rowDimension() 
						&& col_index < columnDimension()){ // validations for keeping a matrix properties
			Integer key[] = new Integer[2];
			key[0] = row_index;
			key[1] = col_index;
			matrixHashTable.put(Arrays.hashCode(key), value);
		}				
	}

	public Integer getWithHash(int row_index, int col_index){
		if(row_index > -1 && col_index > -1 && row_index < rowDimension() 
						&& col_index < columnDimension()){ // validations for keeping a matrix properties
			Integer key[] = new Integer[2];			
			key[0] = row_index;
			key[1] = col_index;
			Integer result = matrixHashTable.get(Arrays.hashCode(key));
			if(result != null)
				return result;
			return 0;
		}
		return null;
	}


	public static void main(String args[]){
		RealSparseMatrixHashing matrix = new RealSparseMatrixHashing(4, 4);
		matrix.setWithHash(1, 1, 99);
		matrix.setWithHash(1,1, 100);
		matrix.setWithHash(3,2, 95);
		System.out.println("Number at 1, 1: " + matrix.getWithHash(1,1));
		System.out.println("Number at 2, 1: " + matrix.getWithHash(2,1));
		System.out.println("Number at 3, 2: " + matrix.getWithHash(3,2));
		System.out.println("Number at -1, -1: " + matrix.getWithHash(-1,-1));	
	}

	/*Output:
	Number at 1, 1: 100
	Number at 2, 1: 0
	Number t 3, 2: 95
	Number at -1, -1: null
	*/

}