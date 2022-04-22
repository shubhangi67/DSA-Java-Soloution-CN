package hashMap;

import java.util.ArrayList;

public class Map<K, V> {

	ArrayList<MapNode<K, V>> buckets;
	int count;
	int numBuckets;

	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 20;
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
	}

	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while (head != null) {
			if (head.keys.equals(key)) {
				if (prev != null) {
					prev.next = head.next;
				} else {
					buckets.set(bucketIndex, head.next);
				}
				count--;
				return head.values;
			}
			head = head.next;
		}
		return null;
	}

	public int size() {
		return count;
	}

	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			if (head.keys.equals(key)) {
				return head.values;
			}
			head = head.next;
		}
		return null;

	}

	private int getBucketIndex(K key) {
		int hc = key.hashCode();
		int index = hc % numBuckets;
		return index;
	}

	public void insert(K key, V values) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		// If element is already there? just update its value
		while (head != null) {
			if (head.keys.equals(key)) {
				head.values = values;
				return;
			}
			head = head.next;
		}
		// element is not there , insert at 0th position of linkedList
		head = buckets.get(bucketIndex);
		MapNode<K, V> newNode = new MapNode(key, values);
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		count++;

		double loadFactor = (1.0 * count) / numBuckets;
		if(loadFactor > 0.7)
		{
			reHash();
		}

	}
	public double loadFactor()
	{
		return (1.0 * count) / numBuckets;
	}
	private void reHash() {
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		for (int i = 0; i < 2 * numBuckets; i++) {
			buckets.add(null);
		}
		count = 0;
		numBuckets = 2 * numBuckets;
		for(int i=0;i<temp.size();i++)
		{
			MapNode<K, V> head = temp.get(i);
			while(head != null)
			{
				K key = head.keys;
				V value =head.values;
				insert(key, value);
				head = head.next;
			}
		}
	}

}
