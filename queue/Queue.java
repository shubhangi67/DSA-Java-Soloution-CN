package queue;

public class Queue {

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		int arr[] = {10,20,30,40};
		for(int elem : arr)
		{
			queue.enqueue(elem);
		}
		while(!queue.isEmpty())
		{
			System.out.println(queue.dequeue());
		}
	}

}
