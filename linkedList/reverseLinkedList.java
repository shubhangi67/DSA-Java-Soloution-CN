package linkedList;

import java.util.Scanner;

public class reverseLinkedList {
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
	public static void printReverse(Node<Integer> root) {
		//Your code goes here
        if(root==null) {
			return;
		}
       printReverse(root.next);
		System.out.println(root.data);
	
	}
	
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printReverse(head);
		

	}

}
