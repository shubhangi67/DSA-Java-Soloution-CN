package linkedList;

import java.util.Scanner;

public class MergeTwoSortedLL {
public static Node<Integer> takeInput() {
		
		//Time complexity of taking of output is 0(n2)
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail=null;
		while (data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if (head == null) {
				// Make this node as head node
				head = currentNode;
				tail = currentNode;
			} else {		
				tail.next = currentNode;
				tail = currentNode;
			}

			data = s.nextInt();
		}
		return head;

	}
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> t1 = head1, t2 = head2, head = null, tail = null;

		if (t1 == null) {
			return head2;
		}
		if (t2 == null) {
			return head1;
		}
		if (t1.data <= t2.data) {
			head = t1;
			tail = t1;
			t1 = t1.next;
		} else {
			head = t2;
			tail = t2;
			t2 = t2.next;
		}
		while(t1!=null && t2!=null)
		{
			if(t1.data <= t2.data)
			{
				tail.next = t1;
				tail=t1;
				t1=t1.next;
			}
			else
			{
				tail.next = t2;
				tail=t2;
				t2=t2.next;
			}
		}
		if(t1!=null)
		{
			tail.next = t1;
		}
		else
		{
			tail.next = t2;
		}
		return head;

	}

	public static void main(String[] args) {
		Node<Integer> head1 = takeInput();
		Node<Integer> head2 = takeInput();
		Node<Integer> m = merge(head1, head2);
		print(m);
	
	}

}
