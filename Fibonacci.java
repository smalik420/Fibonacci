/**
 *	Calculating Fibonacci numbers using iteration and recursion.
 *	Recursion is O(2^n) while iteration is O(n).
 *
 *	@author	Mr Greenstein
 *	@since	December 11, 2016
 */
public class Fibonacci {
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.run(args);
	}
	
	/*
	 *	Run both the iterative and recursive versions of the algorithm
	 *	to compute the Fibonacci numbers. Report both the number result
	 *	and the time to compute the number in seconds.
	 */
	public void run(String[] args) {
		int n = 0;
		if (args.length < 1) {
			System.err.println("Usage: java Fibonacci <integer>");
			System.exit(0);
		}
		
		try {
			n = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException e) {
			System.err.println("Usage: java Fibonacci <integer>");
			System.exit(-1);
		}
		long startTime = System.currentTimeMillis();
		long result = fibIterative(n);
		long stopTime = System.currentTimeMillis();
		System.out.println("fibIterative(" + n + ") = " + result + "  seconds = "
						+ ((stopTime - startTime) / 1000.0));
		startTime = System.currentTimeMillis();
		result = fibRecursive(n);
		stopTime = System.currentTimeMillis();
		System.out.println("fibRecursive(" + n + ") = " + result + "  seconds = "
						+ ((stopTime - startTime) / 1000.0));
	}
	
	/**
	 *	Calculate the nth Fibonacci number using iteration.
	 *	@param n	the Fibonacci index
	 *	@return		the nth Fibonacci number
	 */
	public long fibIterative(int n) 
	{
		long fib1 = 1;
		long fib2 = 1;
		while (n > 2) {
			long temp = fib1 + fib2;
			fib1 = fib2;
			fib2 = temp;
			n--;
		}
		
		return fib2;
	}
	
	//works for iterative and recursive, but iterative takes less stack
	//space and is also much faster, proving how it is better to default
	//to using iterative unless it is a tree, converging, or it gets
	//significantly simpler without losing too much effeciency
	
	/**
	 *	Calculate the nth Fibonacci number using recursion.
	 *	@param n	the Fibonacci index
	 *	@return		the nth Fibonacci number
	 */
	public long fibRecursive(int n) 
	{
		if (n < 3) //base case
			return 1;
		return fibRecursive(n - 1) + fibRecursive(n - 2);
		
	}

}
