package chapter8;

public class BooleanEvaluation {
	
	public static int countEval(String expr, Boolean evaluation) {
		
		if (expr.length()==0)
			return 0;
		
		if (expr.length()==1) {
			if (expr.equals("0") && evaluation==false)
				return 1;
			else if (expr.equals("1") && evaluation==true)
				return 1;
			else
				return 0;
		}
		
		int ways = 0;
		
		// for each operator in expr
		for (int i=1; i<expr.length(); i+=2) {
			
			String left = expr.substring(0, i);
			String right = expr.substring(i+1, expr.length());
			
			/* We can use the Catalan number to calculate the total number of expression. 
			 * By using it, we can reduce the number of countEval() call.
			 */
			int leftTotal = computeCatalan((left.length()-1)/2);
			int leftTrue = countEval(left, true);
			int leftFalse = leftTotal - leftTrue;
			
			//int leftFalse = countEval(left, false);
			
			int rightTotal = computeCatalan((right.length()-1)/2);
			int rightTrue = countEval(right, true);
			int rightFalse = rightTotal - rightTrue;
			
			//int rightFalse = countEval(right, false);
									
			int totalWay = leftTotal * rightTotal;
			//int totalWay = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int trueWay = 0;
			
			// calculate the number of ways that makes expression true
			switch(expr.charAt(i)) {
			case '&' :
				trueWay = leftTrue * rightTrue;
				break;
			case '|' :
				trueWay = leftTrue * rightTrue +
				          leftTrue * rightFalse +
				          leftFalse * rightTrue;
				break;
			case '^' :
				trueWay = leftTrue * rightFalse +
				          leftFalse * rightTrue;
				break;
			}
			
			ways = (evaluation==true) ? ways + trueWay : ways + (totalWay - trueWay);
		}
		
		return ways;
	}
	
	private static int computeCatalan(int n) {
		return factorial(2*n)/(factorial(n)*factorial(n+1));
	}
	
	private static int factorial(int n) {
		int result = 1;
		for(int i=1; i<=n; i++)
			result *= i;
		
		return result;
	}
	
	public static void main(String[] args) {
		int r=0;
		
		r = countEval("1^0|0|1", false);
		System.out.println("result : " + r);
		
		r = countEval("0&0&0&1^1|0", true);
		System.out.println("result : " + r);
	}
}
