package validation;


import org.junit.runner.RunWith;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;

import chapter2.*;

@RunWith(JUnitPlatform.class)
public class chapter2Test {
	
	@RepeatedTest(100)
	void testPartition() {
		Partition p = new Partition();
		Random random = new Random();
		
		int nodeCnt = random.nextInt(100);
		int val = random.nextInt(10);
		// val = 0;
		p.insertNodes(nodeCnt);
		
		System.out.println("The number of nodes is " + nodeCnt + " with partition value of " + val);
		
		System.out.println("Original List");
		p.printList();
						
		p.partitionWith(val);
		
		System.out.println("After partitioning");
		p.printList();
		
		Boolean found = false;
		
		for (Node node = p.getHead(); node != null; node = node.getNext()) {
			if (found == false) {
				if (node.getData() >= val) {
					found = true;
				}
			} else {
				if (node.getData() < val) {
					System.out.println("FAILED!");
					fail();
				}
			}
		}
		
		/* count each occurrence of number to verify that only permutation of nodes is changed. */
		
	}
}
