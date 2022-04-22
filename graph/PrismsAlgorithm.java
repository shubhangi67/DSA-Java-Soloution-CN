package graph;

import java.util.Scanner;

public class PrismsAlgorithm {
	public static void prismAlgorithm(int adjMtrix[][]) {
		int n = adjMtrix.length;
		boolean visited[] = new boolean[n];
		int parent[] = new int[n];
		int weight[] = new int[n];

		// source - vertex 0
		parent[0] = -1;
		weight[0] = 0;
		for (int i = 1; i < n; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			int minvertex = findMinVertex(visited, weight);
			visited[minvertex] = true;
			for (int j = 0; j < n; j++) {
				if (adjMtrix[minvertex][j] != 0 && !visited[j]) {
					// updates values
					weight[j] = adjMtrix[minvertex][j];
					parent[j] = minvertex;
				}
			}
		} // Print MST
		for (int i = 1; i < adjMtrix.length; i++) {
			if (i < parent[i]) {
				System.out.println(i + " " + parent[i] + " " + weight[i]);
			} else {
				System.out.println(parent[i] + " " + i + " " + weight[i]);
			}
		}

	}
	// Print MST
	private static int findMinVertex(boolean[] visited, int[] weight) {
		int minVertex = -1;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < E; i++) {
			int vertices1 = s.nextInt();
			int vertices2 = s.nextInt();
			int weight = s.nextInt();
			adjMatrix[vertices1][vertices2] = weight;
			adjMatrix[vertices2][vertices1] = weight;

		}
		prismAlgorithm(adjMatrix);

	}
	
//	5 7
//	0 1 4
//	0 2 8
//	1 2 2
//	1 3 6
//	2 3 3 
//	2 4 9
//	3 4 5

}
