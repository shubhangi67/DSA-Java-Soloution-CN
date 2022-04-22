package graph;

import java.util.*;

public class BreathFirstTraversal {
	// O(V2)
	public static void breathFirstTraversal(int[][] adjMatrix) {
		if (adjMatrix.length == 0) {
			return;
		}
		int n = adjMatrix.length;
		boolean visited[] = new boolean[n];
		Queue<Integer> pendingNodes = new LinkedList<>();
		visited[0] = true;
		pendingNodes.add(0);

		while (!pendingNodes.isEmpty()) {
			int currentVertex = pendingNodes.poll();
			System.out.print(currentVertex + " ");
			for (int i = 0; i < n; i++) {
				if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
					pendingNodes.add(i);
					visited[i] = true;
				}
			}
		}
	}
// solved by me
	public static void bfs(int[][] adjMatrix) {
		if (adjMatrix.length == 0) {
			return;
		}
		int n = adjMatrix.length;
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				Queue<Integer> pendingNodes = new LinkedList<>();
						
				pendingNodes.add(i);
				
				visited[i] = true;

				while (!pendingNodes.isEmpty()) {
					int currentVertex = pendingNodes.poll();
					System.out.print(currentVertex + " ");
					for (int j = 0; j < n; j++) {
						if (adjMatrix[currentVertex][j] == 1 && visited[j] == false) {

							visited[j] = true;
							pendingNodes.add(j);
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int totalNumOfVertex = s.nextInt();
		int edges = s.nextInt();
		int[][] adjMatrix = new int[totalNumOfVertex][totalNumOfVertex];
		for (int i = 0; i < edges; i++) {
			int vertices1 = s.nextInt();
			int vertices2 = s.nextInt();
			adjMatrix[vertices1][vertices2] = 1;
			adjMatrix[vertices2][vertices1] = 1;

		}
		breathFirstTraversal(adjMatrix);

	}

}
