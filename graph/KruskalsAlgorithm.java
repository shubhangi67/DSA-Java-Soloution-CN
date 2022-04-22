package graph;

import java.util.Arrays;
import java.util.Scanner;

// in this currently we are using union find algorithm
// Improve union find algorithm is rank path compression


class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int weight;

	Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {

		return this.weight - o.weight;
	}
}
// ElogE +EV
// Overall complexity E-> O(V2)
public class KruskalsAlgorithm {

	public static void main(String[] args) {
		// time complexity O(E)
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		Edge edges[] = new Edge[E];
		for (int i = 0; i < E; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			Edge d = new Edge(v1, v2, weight);
			edges[i] = d;
		}
		Edge mst[] = kruskalsAlgo(edges, V);
		for (int i = 0; i < mst.length; i++) {
			if (mst[i].v1 < mst[i].v2) {
				System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
			} else {
				System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);

			}
		}
	}

	public static Edge[] kruskalsAlgo(Edge[] edges, int n) {
		//Sort all Edges O(ElogE)
		Arrays.sort(edges);
		
		Edge mst[] = new Edge[n - 1];
		int parent[] = new int[n];
		for (int j = 0; j < n; j++) {
			parent[j] = j;
		}
		int count = 0, i = 0;
		while (count != n - 1) {
			Edge currentEdge = edges[i++];
			int v1Parent = findParent(currentEdge.v1, parent);
			int v2Parent = findParent(currentEdge.v2, parent);
			if (v1Parent != v2Parent) {
				// Including currentEdge
				mst[count] = currentEdge;
				count++;
				parent[v1Parent] = v2Parent;
			}
		}
		return mst;

	}
// time complexity O(V)
	public static int findParent(int v1, int[] parent) {
		if (v1 == parent[v1]) {
			return v1;
		}
		return findParent(parent[v1], parent);
	}

}
