package DP;

public class Factorization {
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorialMemo(5));
	}
	public static int factorial(int n) {
		int result=1;
		for(int i=1;i<=n;i++) {
			result=result*i;
		}
		return result;
	}
	public static int factorialMemo(int n) {
		int[] memo=new int[n+1];
		if(n==1) {
			memo[1]=1;
			return 1;
		}else if(memo[n]!=0) {
			return memo[n];
			
		}else {
			memo[n]=n*factorialMemo(n-1);
			return memo[n];
		}
	}

}
