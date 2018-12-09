package chapter5;

public class PairwiseSwap {
	public static int swap(int n) {
	
		// >>> : zero-extension, >> : sign-extension
		// <<< : doesn't exist. Only << when shifting left
		return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
	}
	
	public static void main(String[] args) {
		// int n = Integer.MIN_VALUE;
		
		int n = -24349352;
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(swap(n)));
	}
}
