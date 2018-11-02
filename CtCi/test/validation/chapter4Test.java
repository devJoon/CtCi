package validation;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import chapter4.MinimalTree;

import static org.junit.Assert.fail;

@RunWith(JUnitPlatform.class)
public class chapter4Test {
	
	@RepeatedTest(10)
	public void testBST() {
		Random rand = new Random();
		int n = rand.nextInt(50) + 10;
		
		MinimalTree mt = new MinimalTree();
		mt.fill(n); // arr.length 		
		mt.buildTree(0, n-1);
		
		int h = 0;
		while(n >= Math.pow(2, h)) {
			h++;
		}
		
		System.out.println("The number of node : " + n + ", height : " + mt.getHeight());
		
		if(h != mt.getHeight())
			fail();
		
	}
}
