package recursion;

public class Recursionfac {
	public static int fact(int n)
	{
		if(n==0)
		{
			return 1;
		}
		int smalloutput = fact(n-1);
		int output = n*smalloutput;
		return output;
	}
	public static void main(String[] args) {
		System.out.println(fact(5));
	}

}
