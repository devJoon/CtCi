package validation;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;

import chapter3.SortStack;

@RunWith(JUnitPlatform.class)
public class chapter3Test {
	
	@RepeatedTest(5)
	void testSortStack() {
		SortStack sstack = new SortStack();
		Random rnd = new Random();
		
		/* Define stack size */
		int stackSize = 30;
		
		/* Fill stack */
		for(int i=0; i<stackSize; i++) {
			sstack.getStack().push(rnd.nextInt(50));
		}
		
		System.out.println("Original stack");
		sstack.getStack().print();
		
		sstack.sort();		
		
		System.out.println("After sorting");
		sstack.getStack().print();
						
		Boolean isFirst = true;
		// TODO : add fail condition
		
		int prev = 0;
		
		while(sstack.getStack().isEmpty() != false) {
			int tmp	= sstack.getStack().pop();
			
			if (!isFirst) {			
				if (prev > tmp)
					fail();								
			}			
			prev = tmp;
			isFirst = false;
		}		
	}
}
