package linkedList;

import java.util.Scanner;

class DoubleNode {
	Node<Integer> head;
	Node<Integer> tail;

	public DoubleNode() {

	}

	public DoubleNode(Node<Integer> head, Node<Integer> tail) {
		this.head = head;
		this.tail = tail;
	}

}

public class Reversed_LinkedList_Recursive_2 {
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

	public static Node<Integer> reversed(Node<Integer> head) {

		// Time complexity of this linkList O(n2);
		// The recursive call for this T(n) = T(n-1)+n-1;
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reversed(head.next);
		Node<Integer> tail = smallHead;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		head.next = null;
		return smallHead;
	}

	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static DoubleNode reverseRBetter(Node<Integer> head) {
		DoubleNode ans;
		if (head == null || head.next == null) {
			ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		DoubleNode smallAns = reverseRBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		//l = (reversed(l));
		DoubleNode ans = reverseRBetter(head);
		print(ans.head);
	}

}
