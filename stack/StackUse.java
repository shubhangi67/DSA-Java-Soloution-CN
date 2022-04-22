package stack;
import java.util.Stack;
public class StackUse {

	public static void main(String[] args) throws StackFullException {
//		StackUsingArray stack = new StackUsingArray();
//		stack.push(10);
//		stack.pop();
//		System.out.println(stack.top());
//		//stack.isEmpty();
//		//stack.size();
		Stack<Integer> stack=new Stack<Integer>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.print(stack.pop());

	}

}
