package priority_queue;

import java.util.PriorityQueue;

public class Inbuild_Priority_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(5);
		pq.add(6);
		pq.add(1);
		pq.add(13);
		System.out.println(pq.peek());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//      System.out.println(pq.element());
		pq.isEmpty();

	}

}
