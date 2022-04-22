package recursion1.assignment;

public class CheckPalindrome {
	public static boolean checkPalindrome(String input)
	{
		if(input.length()<=1)
		{
			return true;
		}
		if(input.charAt(0)==input.charAt(input.length()-1))
		{
			return checkPalindrome(input.substring(1,input.length()-1));
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args) {
		String s="abbac";
		System.out.println(checkPalindrome(s));

	}

}
