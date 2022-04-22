package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackCollection {

	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(10);
//		System.out.println(stack.size());
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.isEmpty());
//		Queue<Integer> q=new LinkedList<Integer>();
//        Stack<Integer> s=new Stack<Integer>();
//        q.add(5);
//        q.add(10);
//        s.push(10);
//        s.push(20);
//        System.out.print(q.peek()+s.pop());
		Queue<Integer> q=new LinkedList<Integer>();
        for(int i=1;i<5;i++)
        {
            q.add(10+i);
        }
        System.out.print(q.poll()+" "+q.size());
	}

}
