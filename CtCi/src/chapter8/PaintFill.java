package chapter8;

import java.util.HashSet;
import java.util.Random;

public class PaintFill {
	
	private char[][] matrix;
	private int length;
	
	public PaintFill(int n) {
		matrix = new char[n][];
		for (int i=0; i<n; i++)
			matrix[i] = new char[n];
		
		length = n;
		
		Random random = new Random();
		
		for(int i=0; i<length; i++) {
			for (int j=0; j<length; j++) {
				int val = random.nextInt(3);
				
				switch(val) {
				case 0:
					matrix[i][j] = 'R';
					break;
				case 1:
					matrix[i][j] = 'G';
					break;
				case 2:
					matrix[i][j] = 'B';
					break;
				}
			}
		}
		
	}
		
	public void print() {
		
		for(int i=0; i<length; i++) {
			for (int j=0; j<length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void fill(int x, int y, char to) {
				
		char from = matrix[x][y];
		HashSet<int[]> set = new HashSet<>();
		
		fill(set, x, y, from, to);
	}
	
	private void fill(HashSet<int[]> set, int x, int y, char from, char to ) {
		
		if (x >= length || y >= length || x < 0 || y < 0)
			return;
		
		if (matrix[x][y] != from || matrix[x][y] == to)
			return;
		
		int coord[] = new int[2];
		coord[0] = x;
		coord[1] = y;
		
		if (set.contains(coord)) {
			return;
		} else {
			matrix[x][y] = to;
			set.add(coord);
			
			if (x-1 >= 0)
				fill(set, x-1, y, from, to);
			
			if (x+1 < length)
				fill(set, x+1, y, from, to);
			
			if (y-1 >= 0)
				fill(set, x, y-1, from, to);
			
			if (y+1 < length)
				fill(set, x, y+1, from, to);
			
			return;
		}
	}
			
	public static void main(String[] args) {
		int n = 10;
		Random random = new Random();
		int x = random.nextInt(n);
		int y = random.nextInt(n);
		
		PaintFill pf = new PaintFill(n);
		pf.print();
		
		System.out.println("(x,y) : (" + x + "," + y +")" );
		
		pf.fill(x, y, 'Y');
		pf.print();
	}
	
}
