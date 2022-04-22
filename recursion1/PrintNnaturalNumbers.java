package recursion1;

public class PrintNnaturalNumbers {
	public static void call(int n)
	{
		if(n==0)
		{
			return;
		}
		 call(n-1);
		 System.out.println(n);
	}
	public static void main(String[] args) {
		call(8);
	}

}
