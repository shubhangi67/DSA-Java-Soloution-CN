package recurcionHardQuestions;

public class Return_Keypad_Code {
	public static char[] numberOptions(int n) {
		switch (n) {
		case 2:
			char option2[] = { 'a', 'b', 'c' };
			return option2;
		case 3:
			char option3[] = { 'd', 'e', 'f' };
			return option3;
		case 4:
			char option4[] = { 'g', 'h', 'i' };
			return option4;
		case 5:
			char option5[] = { 'j', 'k', 'l' };
			return option5;
		case 6:
			char option6[] = { 'm', 'n', 'o' };
			return option6;
		case 7:
			char option7[] = { 'p', 'q', 'r', 's' };
			return option7;
		case 8:
			char option8[] = { 't', 'u', 'v' };
			return option8;
		case 9:
			char option9[] = { 'w', 'x', 'y', 'z' };
			return option9;
		default:
			char option[] = { '\0' };
			return option;
		}
	}

	public static String[] keyPad(int n) {
		if (n == 0) {
			String ans[] = { "" };
			return ans;
		}
		int lastDigit = n % 10;
		int smallNumber = n / 10;
		String smallAns[] = keyPad(smallNumber);
		char options[] = numberOptions(lastDigit);
		String ans[] = new String[smallAns.length * options.length];
		int k = 0;

		for (int i = 0; i < smallAns.length; i++) {
			for (int j = 0; j < options.length; j++) {
				ans[k] = smallAns[i] + options[j];
				k++;
			}
		}
		return ans;
	}

	public static void printkeyPad(int n) {
		printkeyPad(n, "");
	}

	public static void printkeyPad(int n, String outputSoFar) {
		if (n == 0) {
			System.out.println(outputSoFar);
			return;
		}
		int lastDigit = n % 10;
		char options[] = numberOptions(lastDigit);
		for (int i = 0; i < options.length; i++) {
			printkeyPad(n / 10, options[i] + outputSoFar);
		}

	}

	public static void main(String[] args) {
		int n = 234;
		String ans[] = keyPad(n);
		printkeyPad(n);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(i + " " + ans[i]);
		}
	}

}
