package linkedList;

import java.util.Scanner;

public class Recursion_In_LinkedList {
	public static Node<Integer> takeInput() {
		// Time complextixity of taking of output is 0(n2)
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
	public static void printR(Node<Integer> head) {
		if (head == null) {
			return;
		}
		printR(head.next);
		System.out.print(head.data + " * ");
//		printR(head.next);
//		System.out.print(head.data + " | ");
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printR(head);

	}

}
