package recurcionHardQuestions;

public class ReturnSubSequenceOfString {
	public static String[] findSubSequence(String str) {
		if (str.length() == 0) {
			String ans[] = { "" };
			return ans;
		}

		String smallAnswer[] = findSubSequence(str.substring(1));
		String answer[] = new String[2 * smallAnswer.length];
		int k = 0;
		for (int i = 0; i < smallAnswer.length; i++) {
			answer[k] = smallAnswer[i];
			k++;
		}
		for (int i = 0; i < smallAnswer.length; i++) {
			answer[k] = str.charAt(0) + smallAnswer[i];
			k++;
		}
		return answer;
	}
	public static void printSubSequence(String input,String outputSoFar)
	{
		if(input.length() == 0)
		{
			System.out.println(outputSoFar);
			return;
		}
		//We choose not to include the first character
		printSubSequence(input.substring(1),outputSoFar);
		//We choose to include the first character
		printSubSequence(input.substring(1), outputSoFar+input.charAt(0));
	}
	public static void printSubSequence(String input)
	{
		printSubSequence(input, "");
	}
	public static void main(String[] args) {
		String str = "xyz";
		String ans[] = findSubSequence(str);
		printSubSequence(str);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
