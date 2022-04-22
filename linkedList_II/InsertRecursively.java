package linkedList_II;

import java.util.Scanner;
import linkedList.Node;

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

public class InsertRecursively {
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

	public static Node<Integer> insertRecursive(Node<Integer> head, int data, int pos) {
		if (head == null && pos > 0) {
			return head;
		}
		if (pos == 0) {
			Node<Integer> newNode = new Node<Integer>(data);
			newNode.next = head;
//			newNode = head;
			return newNode;
		} else {
			Node<Integer> smallHead = insertRecursive(head.next, data, pos - 1);
			head.next = smallHead;
			return head;
		}

	}
// Time complexity is O(n2)
	public static Node<Integer> reverseR(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reverseR(head.next);
		Node<Integer> tail = smallHead;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		head.next = null;
		return smallHead;
	}
//Time complexity is O(n)
	public static DoubleNode reverseBetter(Node<Integer> head)
	{
		DoubleNode ans;
		if(head == null || head.next == null)
		{
			ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		// This double node will have both head and tail of reversed LL
		DoubleNode smallAns = reverseBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
		
	}
	
	public static Node<Integer> reverseBetter1(Node<Integer> head)
	{
		DoubleNode ans = reverseBetter(head);
		return ans.head;
	}
//Time complexity is O(n)
	public static Node<Integer> reverseBest(Node<Integer> head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		Node<Integer> smallHead = reverseBest(head.next);
		Node<Integer> reversedTail = head.next;
		reversedTail.next = head;
		head.next = null;
		return smallHead;
	}
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		head = reverseBest(head);
		printR(head);
		

	}

}
