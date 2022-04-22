package recursion1;

public class CheckPlaindrome {
	public static boolean isStringPalindrome(String input, int start, int end) {
		if (start == end) {
			return true;
		}
		if (input.charAt(start)!=input.charAt(end)) {
			return false;
		}
		return isStringPalindrome(input,start,end+1);
	}

	public static boolean isStringPalindrome(String input) {
		return isStringPalindrome(input, 0, input.length()-1);
	}

	public static void main(String[] args) {
		

	}

}
