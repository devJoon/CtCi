package chapter5;

public class PairwiseSwap {
	public static int swap(int n) {
	
		return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1);
	}
	
	public static void main(String[] args) {
		int n = 948372637;
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(swap(n)));
	}
}
