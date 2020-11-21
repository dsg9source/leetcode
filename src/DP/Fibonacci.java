package DP;

public class Fibonacci {
	
	public static void main(String[] args) {
		fibonacci(20);
		System.out.println("This is Memoization ");
		System.out.println(fibonacciMemo(20));
		System.out.println(fibonacciTabulation(20));
	}
	
	public static void fibonacci(int n) {
		//generate first n fibonacci sequence
		int n0=1;
		int n1=1;
		System.out.print(n0+" "+n1);
		for(int i=2;i<=n;i++) {
			int temp=n0+n1;
			n0=n1;
			n1=temp;
			System.out.print(" "+n1);
		}
	}
	
	public static int fibonacciMemo(int n) {
		int memo[]=new int[n+1];
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		if(memo[n]!=0) {
			return memo[n];
		}else {
			memo[n]=fibonacciMemo(n-1)+fibonacciMemo(n-2);
			return memo[n];
		}
		//Time O(n)
		//Space O(n)
		
		
	}
	public static int fibonacciTabulation(int n) {
		int[] tabulation=new int[n+1];
		if(n==0 || n==1) {
			return 1;
		}
		tabulation[0]=tabulation[1]=1;
		for(int i=2;i<=n;i++) {
			tabulation[i]=tabulation[i-1]+tabulation[i-2];
		}
		return tabulation[n];
		
		//Time O(n)
		//Space O(n)
	}

}
