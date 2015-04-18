import java.util.*;

public class RealSparseMatrix{

	private int rows, cols;
	private ArrayList <Row> list_row;

	private class Point{
		int row;		
		int col;
		int value;
		Point(int rowIn, int colIn, int valueIn){
			row = rowIn;
			col = colIn;
			value = valueIn;
		}
	}

	private class Row{
		private ArrayList<Point> list_points;
		Row(){
			list_points = new ArrayList<Point>();
		}
	}

	public RealSparseMatrix(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		//matrix = new int [rows][cols];
		list_row =  new ArrayList<Row>();
		for (int i = 0; i < rows; i++)
			list_row.add(new Row());
	}

	public RealSparseMatrix(RealSparseMatrix m){
		rows = m.rows;
		cols = m.cols;
		list_row = m.list_row; //	Square matrix
	}

	public int rowDimension(){
		return rows;
	}

	public int columnDimension(){
		return cols;
	}

	public int size(){
		int size = 0;
		for(Row r : list_row)
			size += r.list_points.size();
		return size;
	}

	public double density(){
		double virtual_space_requirements = rows * cols;
		double real_space_requirements = size() * 3;
		return (real_space_requirements / virtual_space_requirements);
	}

	public void set(int row_index, int col_index, int value){
		//First we check if an elements already exists in that location
		for(Point p : list_row.get(row_index).list_points){			
			if(p.col == col_index){
				p.value = value;
				return;
			}
		}
		//If it doesnt exists we add it
		Point newPoint = new Point (row_index, col_index, value);
		list_row.get(row_index).list_points.add(newPoint);		
	}

	public int get(int row_index, int col_index){
		for(Point p : list_row.get(row_index).list_points){
			if(p.col == col_index){				
				return p.value;
			}
		}
		return 0;
	}

	public void addInMatrix(int row_index, int col_index, int value){
		for(Point p : list_row.get(row_index).list_points){
			if(p.col == col_index){				
				p.value += value;
				return;
			}
		}
		Point newPoint = new Point (row_index, col_index, value);
		list_row.get(row_index).list_points.add(newPoint);
	}

	// O(n^3)... poorly efficient
	public RealSparseMatrix add(RealSparseMatrix m){
		RealSparseMatrix aux = new RealSparseMatrix(this);
		for(int i = 0; i < rows; i++)
			for(Point p : m.list_row.get(i).list_points){
				aux.addInMatrix(p.row, p.col, p.value);
			}
		return aux;
	}

	public static void main(String args[]){
		RealSparseMatrix matrix = new RealSparseMatrix(4, 4);
		matrix.set(1, 1, 99);
		matrix.set(1,1, 100);
		RealSparseMatrix matrixAux = new RealSparseMatrix(4, 4);
		matrixAux.set(0, 0, 1);
		matrixAux.set(1, 1, 100);
		matrix.add(matrixAux);
		System.out.println("Elements in matrix: " + matrix.size());
		System.out.println("Element in 1, 1: " + matrix.get(1, 1));
		System.out.println("Density: " + matrix.density());
	}




}