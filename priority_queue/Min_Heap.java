package priority_queue;

import java.util.ArrayList;

public class Min_Heap<T> {

	private ArrayList<Element<T>> heap;

	public Min_Heap() {
		heap = new ArrayList<>();
	}

	// Upheapify Operation
	// Very very Important
	public void insert(T value, int priority) {
		Element<T> e = new Element<T>(value, priority);
		heap.add(e);

		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		while (childIndex > 0) {
			if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}

	}

	public T getMin() throws PriorityQueyueException {
		if (isEmpty()) {
			throw new PriorityQueyueException();
		}
		return heap.get(0).value;
	}

	public T removeMin() throws PriorityQueyueException {
		if (isEmpty()) {
			throw new PriorityQueyueException();
		}
		// O(1) operation
		Element<T> removed = heap.get(0);
		T ans = removed.value;

		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		// DownHeapify operation

		int parentIndex = 0;
		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;
		while(leftChildIndex < heap.size()) {
			int minIndex = parentIndex;
			if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority)
			{
				minIndex = leftChildIndex;
			}
			if(heap.get(rightChildIndex).priority < heap.get(minIndex).priority)
			{
				minIndex = rightChildIndex;
			}
			Element<T> temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = minIndex;
			leftChildIndex = 2 * parentIndex + 1;
			rightChildIndex = 2 * parentIndex + 2;
		}
		return ans;
		
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
}
