package recursion1;

public class RemoveDeuplicatesRecursively {
	public static String removeDuplicate(String s)
	{
		if(s.length()<=1)
		{
			return s;
		}
		if(s.charAt(0)==s.charAt(1))
		{
			return removeDuplicate(s.substring(1));
		}
		return s.charAt(0) + removeDuplicate(s.substring(1));
	}
	public static void main(String[] args) {
		String s="aabbaaaaccdd";
		System.out.println(removeDuplicate(s));

	}

}
