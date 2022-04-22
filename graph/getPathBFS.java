package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class getPathBFS {
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
				;
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

	public static ArrayList<Integer> getpathBFS(int[][] adjMatrix, int s, int e) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean visited[] = new boolean[adjMatrix.length];
		visited[s] = true;
		pendingVertices.add(s);
		map.put(s, -1);
		boolean pathfound = false;
		while (!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			for (int i = 0; i < adjMatrix.length; i++) {
				if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
					map.put(i, currentVertex);
					if (i == e) {
						// path found
						pathfound = true;
						break;

					}
				}
			}
		}
		if (pathfound) {
			ArrayList<Integer> path = new ArrayList<>();
			int currentVertex = e;
			while (currentVertex != -1) {
				path.add(currentVertex);
				int parent = map.get(currentVertex);
				currentVertex = parent;
			}
			return path;
		} else {
			return null;
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
		int source = s.nextInt();
		int end = s.nextInt();
		ArrayList<Integer> path = getpathBFS(adjMatrix, source, end);
		for (int i : path) {
			System.out.print(i + " ");
		}

	}

}
