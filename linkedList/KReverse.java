package linkedList;

import java.util.Scanner;

public class KReverse {
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

	
	public static Node<Integer> kReverse(Node<Integer> head, int k)
	{
		//time Complexity is O(n)
		//Space Complexity is O(n)
		if(k == 0 || k == 1)
        {
            return head;
        }
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> fwd = null;
        
        int count = 0;
        while(count < k && curr != null)
        {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            count++;
        }
        if(fwd != null)
        {
            head.next = kReverse(fwd, k);
        }
        return prev;
	}
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		head = kReverse(head, 3);
		printR(head);

	}

}
