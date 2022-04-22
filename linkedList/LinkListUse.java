package linkedList;

public class LinkListUse {
	public static Node<Integer> createLinkedList() {
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);
		Node<Integer> n5 = new Node<>(50);
		n1.next = n2;
		//System.out.println("n1 " + n1 + " data " + n1.data + " next " + n1.next);
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		n5.next=null;
		return n1;
	}

//	public static void print(Node<Integer> head) {
//		//System.out.println("Print " + head);
////		System.out.println(head.data);
////		System.out.println(head.next);
////		System.out.println(head.next.data);
////		System.out.println(head.next);
////		System.out.println(head.next.next.data);
////		while (head != null) {
////			System.out.println(head.data);
////			head = head.next;
////		}
//		while (head!= null) {
//			System.out.print(head.data+" ");
//			head = head.next;
//		}
//		System.out.println();
//	}
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
//		temp=head;
//		while (temp!= null) {
//			System.out.print(temp.data+" ");
//			temp = temp.next;
//		}
//		System.out.println();
	}
	public static void increment(Node<Integer> head){
	    Node<Integer> temp = head;
	    while(temp != null){
	        temp.data++;
	        temp = temp.next;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = createLinkedList();
		increment(head);
		print(head);
		
//		print(head.next);
//		print(head.next.next);

//		Node n1 = new Node(10);
//		System.out.println(n1);
//		System.out.println(n1.data);
		
		
//		Node<Integer> n1 = new Node<>(10);
//		System.out.println(n1);
//		System.out.println(n1.data);

		
		
		
		
		
		//		System.out.println(n1.next);
//		char m ="piper".charAt(3);
//		System.out.println(m);

	}

}
