package recursion1.assignment;

public class Multiplicative {
	public static int multiply(int m, int n)
	{
		if(m==0 || n==0)
		{
			return 0;
		}
		return m+multiply(m, n-1);
	}
	public static void main(String[] args) {
		int m=10;
		int n=10;
		System.out.println(multiply(m, n));

	}

}
