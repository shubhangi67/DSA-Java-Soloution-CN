package recursion;

public class RemoveConsecutiveAlphabet {
	
	public static String Remove(String s)
	{
		if(s.length()<=1)
		{
			return s;
		}
		if(s.charAt(0)==s.charAt(1))
		{
			return Remove(s.substring(1));
		}
		return s.charAt(0)+Remove(s.substring(1));
	}
	
	public static void main(String[] args) {
		String s = "aabbccddeeff";
		System.out.println(Remove(s));

	}

}
