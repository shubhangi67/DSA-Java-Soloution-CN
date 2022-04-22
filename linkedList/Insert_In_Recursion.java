package linkedList;

import java.util.Scanner;

public class Insert_In_Recursion {
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

	public static Node<Integer> insertR(Node<Integer> head, int elem, int pos) {
		if(head== null && pos>0)
		{
			return head;
		}
		if (pos == 0) {
			Node<Integer> newNode = new Node<Integer>(elem);
			newNode.next = head;
			return newNode;
		} else {
			//			Node<Integer> smallerHead = insertR(head.next, elem, pos - 1);
			//			head.next = smallerHead;
			head.next = insertR(head.next, elem, pos - 1);
			return head;
		}
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
		head=insertR(head, 20, 9);
		print(head);

	}

}
