package hashMap;

public class MapNode<K, V> {
	K keys;
	V values;
	MapNode<K, V> next;

	public MapNode(K keys, V values) {
		this.keys = keys;
		this.values = values;
	}
}
