package chapter4;

import java.util.Random;


public class MinimalTree {
	private BinarySearchTree bst;
	private int arr[];

	public BinarySearchTree getBst() {
		return bst;
	}

	/* fill the array. Elements are sorted in ascending order. */
	public void fill(int n) {
		arr = new int[n];
		Random rand = new Random();
		arr[0] = rand.nextInt(10);
		for(int i=1; i<n; i++) {
			arr[i] = arr[i-1] + rand.nextInt(3) + 1;
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public MinimalTree() {
		bst = new BinarySearchTree();
	}
	
	public int getHeight() {
		return bst.getHeight();
	}
		
	/* Create binary search tree with a minimum height. */
	public void buildTree(int startIdx, int endIdx) {
		
		if (startIdx == endIdx) {
			bst.insert(arr[startIdx]);
		}
		else {
			int middle = (endIdx-startIdx)/2;
						
			bst.insert(arr[startIdx + middle]);
			
			if (middle == 0) {
				bst.insert(arr[endIdx]);
			} else {
				buildTree(startIdx, startIdx + middle - 1);
				buildTree(startIdx + middle + 1, endIdx);
			}			
		}
		
	}
		
	public static void main(String[] args) {
		
		MinimalTree mt = new MinimalTree();
		mt.fill(10); // arr.length 		
		mt.buildTree(0, 9);
	}
}
