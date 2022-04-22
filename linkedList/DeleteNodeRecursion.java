package linkedList;

import java.util.Scanner;

public class DeleteNodeRecursion {

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

	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
		if (head == null) {
			return head;
		}
		if (pos == 0) {
			
			return head.next;
		} else {
			head.next = deleteNode(head.next, pos - 1);
			return head;
		}
	}
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		Node<Integer> d =deleteNode(head,0);
		print(d);
		

	}

}
