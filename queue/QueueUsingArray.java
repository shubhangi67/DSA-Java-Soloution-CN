package queue;

public class QueueUsingArray {

	private int data[];
	private int front;
	private int rear;
	private int size;

	public QueueUsingArray() {
		// TODO Auto-generated constructor stub
		data = new int[5];
		front = -1;
		rear = -1;
	}

	public QueueUsingArray(int capacity) {
		// TODO Auto-generated constructor stub
		data = new int[capacity];
		front = -1;
		rear = -1;
	}

	// 0(1)
	public int size() {
		return size;
	}

	// 0(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// 0(1)
	public void enqueue(int elem) {
		if (size == data.length) {
			doubleCapacity();
		}
		if (size == 0) {
			front = 0;
		}
//		rear++;
//		if(rear == data.length)
//		{
//			rear = 0;
//		}
		rear = (rear + 1) % data.length;
		data[rear] = elem;
		size++;
	}

	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		int index = 0;
		for (int i = front; i < temp.length; i++) {
			data[index++] = temp[i];
		}
		for (int i = 0; i < front - 1; i++) {
			data[index++] = temp[i];
		}
		front = 0;
		rear = temp.length - 1;

	}

	// 0(1)
	public int front() {
		if (size == 0) {
			return 0;
		}
		return data[front];
	}

	// 0(1)
	public int dequeue() {
		if (size == 0) {
			return 0;
		}
		int temp = data[front];
//		front++;
//		if(front == data.length)
//		{
//			front = 0;
//		}
		front = (front + 1) % data.length;
		size--;
		if (size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
}
