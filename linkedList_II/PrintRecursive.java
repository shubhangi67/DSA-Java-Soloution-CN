package linkedList_II;

import java.util.Scanner;

import linkedList.Node;

public class PrintRecursive {

	public static Node<Integer> takeInput() {
		// Time Complexity is O(n)
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while (data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if (head == null) {
				// Make this node as head node;
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
		System.out.print(head.data + " ");
		printR(head.next);
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printR(head);

	}

}
