package chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackofBoxes {
	
	private static class Box {
		int width;
		int height;
		int depth;
		
		private boolean canPutAbove(Box box2) {			
			return (box2.width > this.width && box2.height > this.height && box2.depth > this.depth) ? true : false;				
		}
		
		public Box(int w, int h, int d) {
			width = w;
			height = h;
			depth = d;
		}
		
		public static List<Box> makeBoxesof(int n) {
			List<Box> boxes = new ArrayList<>();
			Random random = new Random();
			for(int i=0; i<n; i++) {
				boxes.add(new Box(random.nextInt(100), random.nextInt(100), random.nextInt(100)));
			}
			return boxes;
		}
	}
	
	public static int getTallestHeight(List<Box> boxPool) {
		
		return addBoxtoStack(0, null, boxPool);
	}
	
		
	public static int addBoxtoStack(int stackHeight, Box boxAtTop, List<Box> boxPool) {
		
		int max = stackHeight;
		
		if (boxPool.isEmpty()) {
			return stackHeight;
		}
		
		for (Box box: boxPool) {
			if (boxAtTop == null || box.canPutAbove(boxAtTop)) {
				List<Box> newPool = new ArrayList<>(boxPool);
				newPool.remove(box);
				max = Math.max(max, addBoxtoStack(stackHeight + box.height, box, newPool));				
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		/*Box b1 = new Box(3,4,5);
		Box b2 = new Box(8,9,10);
		Box b3 = new Box(7,22,7);
		
		List<Box> boxes = new ArrayList<>();
		boxes.add(b1);
		boxes.add(b2);
		boxes.add(b3);*/
		
		List<Box> boxes = Box.makeBoxesof(40);
		
		int tallest = StackofBoxes.getTallestHeight(boxes);
		System.out.println(tallest);
	}
	
	
}
