import java.util.Scanner;

public class SparseMatrixInput{

	private static int maxRowSize = 0; // this variable represents the number of rows which the matrix will have
	private static int maxColSize = 0; // this variable represents the number of cols which the matrix will have

	private static class MatrixElement{
		int value;
		int row;
		int col;

		MatrixElement(){
			value = 0;
			row = 0;
			col = 0;
		}
	}

	//Function that reciebes the query/entry and from it it obtains the int values for the row, col and value for filling the matrix later
	//It saves the values in an array of MatrixElements
	public static void obtainValuesFromUserEntry(String entry, MatrixElement [] array, int index){
		array[index] = new MatrixElement();
		int obtaining_number = 0;
		boolean negative_number = false;
		char [] entry_array = entry.toCharArray();
		for(int i = 0; i < entry_array.length; i++){
			if(entry_array[i] == '-')
				negative_number = true;
			else if(Character.isDigit(entry_array[i])){
				if(obtaining_number == 0)
					array[index].row = (array[index].row * 10) + (entry_array[i] - 48); //I use the -48 to change it to the real int value using ASCII
				else if(obtaining_number == 1)
					array[index].col = (array[index].col * 10) + (entry_array[i] - 48);
				else if(obtaining_number == 2)
					array[index].value = (array[index].value * 10) + (entry_array[i] - 48);
			}
			else if(entry_array[i] == ','){
				obtaining_number = 1;
				if(array[index].row > maxRowSize) // updating the size (number of rows) of the matrix
					maxRowSize = array[index].row;
			}
			else if(entry_array[i] == ']' || entry_array[i] == ':'){
				obtaining_number = 2;
				if(array[index].col > maxColSize) // updating the size (number of cols) of the matrix
					maxColSize = array[index].col;
			}
		}
		if(negative_number)
			array[index].value *= -1;
	}

	// Function that fill the matrix with the values obtain in entries (which are saved in the array of MatrixElemts)
	public static void fillSparseMatrix(int [][] matrix, MatrixElement [] array_elements){
		int actualRow;
		int actualCol;		
		for(int i = 0; i < array_elements.length; i++){
			actualRow = array_elements[i].row;
			actualCol = array_elements[i].col;
			matrix[actualRow][actualCol] = array_elements[i].value;
		}
	}

	// Funtion that prints the SparseMatrix
	public static void printSparseMatrix(int [][] matrix){
		for(int i= 0; i < matrix.length; i++){
			System.out.print("| ");
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("|");
		}
	}


	public static void main(String args[]){

		int number_of_entries, counter_of_entries = 0, maxRow = 0, maxCol = 0;
		String user_entry;
		Scanner scan = new Scanner(System.in);
		System.out.println("Entry format: [1, 1]: 6");
		System.out.println("Enter number of entries: ");
		number_of_entries = scan.nextInt();
		MatrixElement [] array_MatrixElements = new MatrixElement[number_of_entries];
		array_MatrixElements[0] = new MatrixElement();		

		//Loop to obtain the entries
		while(counter_of_entries < number_of_entries){
			System.out.println("Entry " + (counter_of_entries + 1) + ":");
			//Need two scans the fisrt loop because it scans the intro char of the last command
			if(counter_of_entries == 0)
				user_entry = scan.nextLine();		
			user_entry = scan.nextLine();			
			obtainValuesFromUserEntry(user_entry, array_MatrixElements, counter_of_entries);
			counter_of_entries++;
		}
		maxRowSize++; //increments because locations begin at [0]
		maxColSize++;

		//Creation of the Matrix
		int sparseMatrix [][] = new int [maxRowSize][maxColSize];
		fillSparseMatrix(sparseMatrix, array_MatrixElements);
		printSparseMatrix(sparseMatrix);
	}
}