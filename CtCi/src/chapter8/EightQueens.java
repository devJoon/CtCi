package chapter8;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
	
	private static int GRIDSIZE = 8;
	
	public static void placeAllQueens() {
		
		int columns[] = new int[GRIDSIZE];
		List<int[]> results = new ArrayList<>();
		
		// start building from the first row
		placeQueen(0, columns, results);
		
		/*for(int[] result : results) {
			for (int col : result) {
				System.out.print(col + " ");
			}
			System.out.println();
		}*/
		
		// print board
		for(int[] result : results) {
			printBoard(result);
		}			
	}
	
	private static void printBoard(int[] result) {
	
		for (int i=0; i<GRIDSIZE; i++) {
			for (int j=0; j<GRIDSIZE; j++) {
				if (result[i] == j) {
					System.out.print("O ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	/* columns holding partial result
	 * question : array columns from the past call does not affect future call?
	 *         -> Does not affect. But value from the previous call is stored in columns.   
	 */
	private static void placeQueen(int row, int[] columns, List<int[]> results) {
		
		/*
		System.out.println("row : " + row);
		System.out.print("[");
		for (int col : columns)
			System.out.print(col + " ");
		System.out.print("]");
		System.out.println();
		*/
		
		if (row == GRIDSIZE) {
			 
			/* results.add(columns); */
			// should copy the values in the columns, not passing reference of columns. 
			
			results.add(columns.clone());
			
		} else {
			for (int col=0; col<GRIDSIZE; col++) {
				if (isValid(columns, row, col)) {
					columns[row] = col; // place queen on the [row][col]
					placeQueen(row+1, columns, results); // for the next row
				}
			}
		}		
		return;
	}
	
	// test if [r][c] is valid location for queen on the board(columns)
	private static boolean isValid(int[] columns, int r, int c) {
		
		for (int row=0; row<r; row++) {
			
			int col = columns[row];
			
			// on the same column
			if (c==col)
				return false;
						
			// on the same diagonal line
			int width = Math.abs(c - col);
			int height = r - row;
			
			if (width == height)
				return false;
		}				
		return true;
	}
	
	public static void main(String[] args) {
		EightQueens.placeAllQueens();
	}
	
}
