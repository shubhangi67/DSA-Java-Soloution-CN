package linkedList;

import java.util.Scanner;

public class Mid_pointinLL {
	public static Node<Integer> takeInput() {
		// Time complexity of taking of output is 0(n2)
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
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
	
	public static Node<Integer> midpoint(Node<Integer> head)
	{
		Node<Integer> slow= head, fast= head;
		while(slow.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		Node<Integer> mid = midpoint(head);
		System.out.println(mid.data);

	}

}
